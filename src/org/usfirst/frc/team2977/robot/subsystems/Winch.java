package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
              
/**           
 *            
 */           
public class Winch extends Subsystem {
    public int count = 0;
    int click = 1;
    DigitalInput winchLimit = new DigitalInput(RobotMap.winchLimit);
    CANTalon winch = new CANTalon(RobotMap.winch);
    int maxCount = 6;
    
    public Winch() {
    	winch.enableControl();
    	winch.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    }
    boolean pressed;
    
	public boolean atTop() {
	        SmartDashboard.putNumber("Number of Cripsy Clicky Baits", count);
	   if (count >= maxCount) {
		   return true;
		
	   }
	   else {
		   return false;
	   }
	}
	   public boolean getWinchCam() {
		   SmartDashboard.putBoolean("WinchCam", winchLimit.get());
		   return winchLimit.get();
	   }
	   

	   

	  
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void StopWinch() {
	    winch.set(0);
	}
	public void Motorotorotor() {
    	winch.set(1);
    }         
	public void ResetWinch() {
		count = 0;
	}
	public void initDefaultCommand() {
 
	}
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
}   
             

