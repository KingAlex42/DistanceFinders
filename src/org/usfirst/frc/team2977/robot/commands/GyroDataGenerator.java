package org.usfirst.frc.team2977.robot.commands;

import org.usfirst.frc.team2977.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GyroDataGenerator extends Command {
	Timer timer = new Timer();
	double[] gyroValue;
	int i = 1;
	int j;
	int arraySize;
	double intervl;
	double d;

    public GyroDataGenerator(double interval, double duration) {  
    	arraySize = (int) Math.round((duration/interval) + 1);
    	gyroValue = new double[arraySize];
    	intervl = interval;
    	d = duration;
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    	gyroValue[0] = Robot.chassis.GyroAngle();  //Gets the initial reading of the gyro
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	if(timer.get() >= intervl * i) {  //checks to see if the required amount of time has passed before taking another reading
        	System.out.println("Getting GyroValues");
    		gyroValue[i] = Robot.chassis.GyroAngle();
    		i++;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return i >= arraySize;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Generating Table");
    	j = 0;
    	while(j <= i-1) {  //writes all the values to the smartdashboard
    		SmartDashboard.putNumber(Double.toString(j * intervl), gyroValue[j]);
    		j++;
    	}
    	System.out.println("GyroTableGenerated");
    	timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
