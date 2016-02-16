package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;
import org.usfirst.frc.team2977.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shoot extends Command {
	boolean startingState;  //starting position of the kicker
	boolean hasPassed;  //has the kicker passed the limit switch
	boolean isDone;		// has the kicker passed the limit switch for the last time
	boolean finalOscillation;  //is this the last time the kicker code needs to run
	double currentSpeed;  //current speed the kicker is running at
	double voltage;

    public Shoot() {
    	requires(Robot.kicker);   //FIXME Make sure some of this stuff runs everytime the button is pressed
    	setTimeout(.25);
    	voltage = DriverStation.getInstance().getBatteryVoltage();
    	currentSpeed = RobotMap.kickerMaxSpeed + ((12.7 - voltage)/10);
    	SmartDashboard.putNumber("BatteryVoltage", voltage);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putNumber("CurrentSpeed", currentSpeed);
    	/* since the code is meant to oscillate back to try and get as close to the switch as possible, the negative value
    	 * is meant to make sure the kicker always ends before or on the limitswitch   */
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.kicker.forward(currentSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.kicker.limitSwitch() && isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kicker.stop(); 

    	}
    

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
