package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;
import org.usfirst.frc.team2977.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmBack extends Command {
boolean isDone;
int startingState;
    public ArmBack() {
    	requires(Robot.armSubsystem);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startingState = Robot.armSubsystem.encoderCount();
    //	setTimeout(2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.armSubsystem.ArmBack();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Math.abs(startingState) - Math.abs(Robot.armSubsystem.encoderCount()) >= RobotMap.armPositionThreshold) /* || isTimedOut() */;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.armSubsystem.ArmStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.armSubsystem.ArmStop();
    }
}

