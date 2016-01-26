package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.Robot;
import org.usfirst.frc.team2977.robot.commands.GyroCommand;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */

public class GyroSub extends Subsystem {
	AnalogGyro gyro = new AnalogGyro(1); //i cr38 the gyr0
	double adjust; // adjust me dadi
	double angle; // radians? no degrees lol	
	double constant = .25; // big motor speed (gotta go fest)
	double factor = .5; // GCF
	
	public void Reset() { 
			gyro.reset();
			SmartDashboard.putBoolean("Resetted", true);
	  }
	    
    public void GyroDrive() { 
    	angle = gyro.getAngle();
    	adjust = constant * (factor * angle);
    
    	SmartDashboard.putNumber("Angle", angle);
    	
    	if (angle < 0);
    		AdjustLeftSide();
    		
    	if (angle > 0);
    		AdjustRightSide();
    		
    	if (angle == 0);
    		SetEqual();
    }
    	
    	public void AdjustRightSide() {
    		Robot.chassis.m3.set(constant + adjust);  // right side
       		Robot.chassis.m1.set(constant + adjust);
    	}
    
       	public void AdjustLeftSide() {
   			Robot.chassis.m4.set(constant + adjust);	 // left side
   			Robot.chassis.m2.set(constant + adjust);
    		//Robot.memeBase.meme1.set(dank);
    	}
       	public void SetEqual() {
       		Robot.chassis.m1.set(constant);
       		Robot.chassis.m2.set(constant);
       		Robot.chassis.m3.set(constant);
       		Robot.chassis.m4.set(constant);

       	}

    // Put the memes for controlling this planet
    // here. Call these from 4Chan.
    
    public void initDefaultCommand() {
        setDefaultCommand(new GyroCommand());
    }
}