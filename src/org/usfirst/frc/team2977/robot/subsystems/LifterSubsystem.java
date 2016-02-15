package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.Robot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LifterSubsystem extends Subsystem {
	 	Victor lifterMotor = new Victor (4);
	    DigitalInput lift = new DigitalInput(4);
	    //Timer time = new Timer();
	    double markedTime = 0;
	   
	   
	    public void Off() {								//spike stops
	     	lifterMotor.set(0);
	    }
	   
	    
	    
	    public void markTime(double time) {
	    	markedTime = time;
	    }
	    
	    public double markedTime() {
	    	return markedTime;
	    }

	    public boolean Up() {							//when limit switch is pressed, spike = off, and is up
	    	
	    	return !lift.get();
	    	
	    }
	    
	    public void LiftDown() {
	    	lifterMotor.set(-1);
	//    	lifterMotor.setExpiration(TimerValue());
	    		}
	    	
	    public void LiftUp() {
	    	lifterMotor.set(1);;
//	    	TimerValue();
	    }
	   
	    public void Lift() {
	       	if (Robot.lifterSubsystem.Up() == true) {
	       		lifterMotor.set(0);;
	    	}
	    	else if (Robot.lifterSubsystem.Up() == false) {
	        	lifterMotor.set(1);;
	    
	        	
	    	}
	    }
	   
	    	
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	//setDefaultCommand(new LiftInitCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

