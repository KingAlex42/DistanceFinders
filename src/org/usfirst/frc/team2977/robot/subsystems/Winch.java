package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.RobotMap;
import org.usfirst.frc.team2977.robot.commands.DecideTheWinch;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
              
/**           
 *            
 */           
public class Winch extends Subsystem {
    int count;
    int click = 1;
    DigitalInput winchLimit = new DigitalInput(RobotMap.winchLimit);
    Jaguar winch = new Jaguar(RobotMap.winch);
    boolean pressed;
    
	public void Decide() {
	        SmartDashboard.putNumber("Number of Cripsy Clicky Baits", count);

	   if (winchLimit.get() == false){
	       pressed = false;
	   }
	   if (winchLimit.get() == true && pressed == false){
		   count = count + click;
	       pressed = true;
	   }
	   if (count == 5) {
		   winch.set(0);
	   }
	   else if (count > 5) {
		   winch.set(0);
	   }
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
    	setDefaultCommand(new DecideTheWinch());
	}
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
}   
             

