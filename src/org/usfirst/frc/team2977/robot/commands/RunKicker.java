package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunKicker extends Command {
	boolean startingState;  //starting position of the kicker
	boolean hasPassed;  //has the kicker passed the limit switch
	boolean isDone;		// has the kicker passed the limit switch for the last time
	boolean finalOscillation;  //is this the last time the kicker code needs to run
	double currentSpeed;  //current speed the kicker is running at

    public RunKicker(double speed) {
    	requires(Robot.kicker);
    	setTimeout(5);
    	currentSpeed = speed;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	hasPassed = false;
    	isDone = false;
    	startingState = Robot.kicker.limitSwitch();
    	finalOscillation = currentSpeed < -.5; 
    	/* since the code is meant to oscillate back to try and get as close to the switch as possible, the negative value
    	 * is meant to make sure the kicker always ends before or on the limitswitch   */
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(startingState) {  //if the kicker starts on the limit switch, it first needs to move off it
    		Robot.kicker.forward(currentSpeed);  
    		while(!hasPassed && !isTimedOut()) {  //Move Kicker until it is off the limit switch
    			hasPassed = !Robot.kicker.limitSwitch();
    		}
    		while(hasPassed && !isTimedOut() && !isDone) {  //Run until kicker hits the limit switch again
    			isDone = Robot.kicker.limitSwitch();
    		}
    	}
    	else {  /*if the kicker does not start on the limit switch, it should in theory be in front of it
    			   unless a driver override has been sent*/
    		Robot.kicker.forward(currentSpeed);  
    		while(!hasPassed && !isTimedOut() && !isDone){   //move until reaching the limit switch
    			hasPassed = Robot.kicker.limitSwitch();
    		}
    		hasPassed = false;
    		while(!hasPassed && !isTimedOut()) {  //Move Kicker until it is off the limit switch
    			hasPassed = !Robot.kicker.limitSwitch();
    		}
    		while(hasPassed && !isTimedOut() && !isDone){
    			isDone = Robot.kicker.limitSwitch();
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut() || isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kicker.stop(); 
    	if(!finalOscillation) {
    		new RunKicker(-currentSpeed *.5);  //run the kicker in the other direction for a more accurate position on the switch
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
