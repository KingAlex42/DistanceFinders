package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeCommand extends Command {
	boolean isDone;
	boolean alreadyIntaked;
	boolean intakerRunning;
    public IntakeCommand() {
    	requires(Robot.ioSubsystem);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	alreadyIntaked = Robot.ioSubsystem.limitSwitch();
    	intakerRunning = Robot.ioSubsystem.intakerRunning();
    	if(alreadyIntaked) {
    		setTimeout(3);
    	}

    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.ioSubsystem.Intake();

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(alreadyIntaked) {
    		return intakerRunning || isTimedOut();
    	}
    	else {
    		return intakerRunning || Robot.ioSubsystem.limitSwitch();
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.ioSubsystem.Stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}