package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.commands.DriveCommand;
import org.usfirst.frc.team2977.robot.commands.GyroCommand;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Chassis extends Subsystem {
	
	Talon m1 = new Talon(1);  //front Right
	Talon m2 = new Talon(2);  //front Left
	Talon m3 = new Talon(3);  //back Right
	Talon m4 = new Talon(4);  //back Left
	AnalogGyro gyro = new AnalogGyro(1); 
	double adjust;  
	double angle; // not degrees	
	double constant = .25; //motor speed
	double factor = .75; 
	
	//------------------- Gyro Driving -------------------------------------//
	
	public void Reset() { 
			gyro.reset();
			SmartDashboard.putBoolean("Resetted", true);
	  }
	    
    public void GyroDrive() {   //Drives straight using feedback from a gyro
    	angle = gyro.getAngle();
    	adjust = Math.abs(constant * (factor * angle));
    
    	SmartDashboard.putNumber("Angle", angle);
    	SmartDashboard.putNumber("Adjust", adjust);
    	
    	if (angle < -.1){  // Robot tilting right
    		AdjustRightSide();
    	}
    		
    	else if (angle > .1){  // Robot tilting left
    		AdjustLeftSide();
    	}
    		
    	else {
    		SetEqual();   //Within acceptable threshold
    	}
    }
    	
    	public void AdjustRightSide() {
    		m3.set(-(constant + adjust));  // right side
       		m1.set(-(constant + adjust));
    	}
    
       	public void AdjustLeftSide() {
   			m4.set(constant + adjust);	 // left side
   			m2.set(constant + adjust);
    		//Robot.memeBase.meme1.set(dank);
    	}
       	public void SetEqual() {
       		m1.set(-constant);
       		m2.set(constant);
       		m3.set(-constant);
       		m4.set(constant);

       	}
    // ---------------------------------------------------------------------//
       	//--Standard Drive--//
       	
        public void Drive (double speedL, double speedR) {//Drive with manual value input
          	m1.set(speedR);
           	m3.set(speedR);
        	m2.set(speedL);
        	m4.set(speedL);
    		SmartDashboard.putNumber("Angle", gyro.getAngle());
        }


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveCommand());
    }
}

