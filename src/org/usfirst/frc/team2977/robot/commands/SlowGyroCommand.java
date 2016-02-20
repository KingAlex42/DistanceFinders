package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SlowGyroCommand extends Command {
	boolean isAuto;
	double angle;
	double threshold;
	double speed = .5;

    public SlowGyroCommand() { //For Tele-op
    	requires(Robot.chassis);
    	isAuto = false;
    	angle = 0;
    	threshold = 0;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    public SlowGyroCommand(double duration, double turnAngle) { //For autonomous
    	requires(Robot.chassis);
    	isAuto = true;
    	setTimeout(duration);
    	angle = turnAngle;
    	threshold = 0;
    }
   
    public SlowGyroCommand(double duration, double turnAngle, double rangeThreshold) { //For autonomous
    	requires(Robot.chassis);
    	isAuto = true;
    	setTimeout(duration);
    	angle = turnAngle;
    	threshold = rangeThreshold;
    }

    // Called just before this Command runs the first time
    protected void initialize() { 
    	System.out.println("Gyro Drive Enabled");
    	Robot.chassis.Reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.GyroDrive(angle, speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(isAuto) {
    		return isTimedOut() || (threshold >= Robot.chassis.leftDistance() && threshold != 0);
   	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.Drive(0, 0);
    	System.out.println("Manual Drive Control Restored");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("Manual Drive Control Restored");
    }
}
