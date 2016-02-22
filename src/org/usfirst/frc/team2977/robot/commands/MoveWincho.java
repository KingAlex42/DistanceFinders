package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.OI;
import org.usfirst.frc.team2977.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveWincho extends Command {
	boolean isDone;
    public MoveWincho() {
    	requires(Robot.winchSubsystem);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.winchSubsystem.Motorotorotor();
    }

    // Called repeatedly when this Command is scheduled to run
    	boolean isPressed;
    	boolean isClicked;
    	boolean hasCounted = false;
    protected void execute() {
    	isClicked = Robot.winchSubsystem.getWinchCam();
    	while(Robot.winchSubsystem.getWinchCam()) {   //TODO ADD A WAY TO GET OUT OF THIS LOOP
    		hasCounted = false;
    	}
    	if(!hasCounted) {
    		Robot.winchSubsystem.count++;
    		hasCounted = true;
    	}
    	
    	

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.winchSubsystem.atTop() || !Robot.oi.winchButton();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.winchSubsystem.StopWinch();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.winchSubsystem.StopWinch();
    }
}
