package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroTurn extends Command {
	double startingAngle; //where we started
	double currentAngle;  //where we are at
	double turnAngle;  //How much we want it to turn
	double constant = .5;  //default motor speed
	double speed;
	double thresholdBounds = 1;  //Actual turn must be within the turn angle +- this
	
	int correctionCycle = 1;
	int lastPosition;
	
	boolean beforeThreshold;
	boolean isDone;
	boolean pastThreshold;

    public GyroTurn(double angle)  {  //GyroAngle, not actual angle
    	isDone = false;
    	requires(Robot.chassis);
    	turnAngle = angle;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startingAngle = Robot.chassis.GyroAngle();
    }

    // Called repeatedly when this Command is scheduled to run
     protected void execute() {
    	 speed = constant / correctionCycle;
    	beforeThreshold = (Math.abs(currentAngle - startingAngle) <= Math.abs(turnAngle) - 1);
    	//Check to see if the robot has turned the desired amount
    	pastThreshold = (Math.abs(currentAngle - startingAngle) >= Math.abs(turnAngle) + 1);
    	//Check to see if the robot has passed the desired amount
    	currentAngle = Robot.chassis.GyroAngle();
    	if(beforeThreshold) {
    		if(lastPosition != 1) {
    			lastPosition = 1;
    		}
    		if(turnAngle > 0) { //robot turn left
    			Robot.chassis.Drive(-speed, speed); }
    		if (turnAngle < 0) {
    			Robot.chassis.Drive(speed, -speed); //Making Turn Right
    		}
    	}
    	if(pastThreshold) {
    		if(lastPosition != 3) {
    			correctionCycle++;
    			lastPosition = 3;
    		}
    		if(turnAngle < 0) { //robot turn back right
    			Robot.chassis.Drive(-speed, speed); }
    		if (turnAngle > 0) {
    			Robot.chassis.Drive(speed, -speed); //Making Turn back left
    		}
    	}
    	if(!pastThreshold && !beforeThreshold) {
    		if(lastPosition != 2) {
    			correctionCycle++;
    			Robot.chassis.Drive(0, 0);
    			lastPosition = 2;
    			}
    		}
    	}
    
    //dont put ALL of the memes in your car they might get stolen
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !beforeThreshold && !pastThreshold;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.Drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
