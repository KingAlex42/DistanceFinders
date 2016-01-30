package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroCommand extends Command {
	boolean isAuto;

    public GyroCommand() {
    	requires(Robot.chassis);
    	isAuto = false;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    public GyroCommand(double duration) {
    	isAuto = true;
    	setTimeout(duration);
    }

    // Called just before this Command runs the first time
    protected void initialize() { 
    	System.out.println("Gyro Drive Enabled");
    	Robot.chassis.Reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.GyroDrive();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(isAuto) {
    		return isTimedOut();
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Manual Drive Control Restored");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
