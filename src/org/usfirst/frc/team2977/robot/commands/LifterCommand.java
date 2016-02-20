package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LifterCommand extends Command {
	Timer timer = new Timer();
    public LifterCommand() {
    	requires(Robot.lifterSubsystem);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	SmartDashboard.putBoolean("LifterSwitch", Robot.lifterSubsystem.Up());
    	Robot.lifterSubsystem.LiftUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.lifterSubsystem.Up();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lifterSubsystem.Off();
    	Robot.lifterSubsystem.markTime(timer.get());
    	timer.stop();
 
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.lifterSubsystem.Off();
    }
}
