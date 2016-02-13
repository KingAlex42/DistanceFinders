package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.Robot;
import org.usfirst.frc.team2977.robot.commands.LiftInitCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LifterSubsystem extends Subsystem {
	 Relay lifterMotor = new Relay(4);
	    DigitalInput lift = new DigitalInput(4);
	    public boolean isUp;
	    Timer time = new Timer(); 
	   
	    public void Off() {								//spike stops
	     	lifterMotor.set(Relay.Value.kOff);
	    }
	   
	 
	    public double TimerValue(){						//time that lifter goes up until hits limit switch
	       	time.get();
	    	return time.get();
	    }
	    

	    public boolean Up() {							//when limit switch is pressed, spike = off, and is up
	    	if (lift.get() == false){					//when limit switch isn't pressed, is down
	    		isUp = false;
	    	}
	    	if (lift.get() == true) {
	    		isUp = true;
	    	} 
	    	return isUp;
	    	
	    }
	    
	    public void LiftDown() {
	    	lifterMotor.set(Relay.Value.kReverse);
	    	lifterMotor.setExpiration(TimerValue());
	    		}
	    	
	    public void LiftUp() {
	    	lifterMotor.set(Relay.Value.kForward);
	    	TimerValue();
	    }
	   
	    public void Lift() {
	       	if (Robot.lifterSubsystem.Up() == true) {
	       		lifterMotor.set(Relay.Value.kOff);
	    	}
	    	else if (Robot.lifterSubsystem.Up() == false) {
	        	lifterMotor.set(Relay.Value.kForward);
	        	TimerValue();
	        	
	    	}
	    }
	   
	    	
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new LiftInitCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

