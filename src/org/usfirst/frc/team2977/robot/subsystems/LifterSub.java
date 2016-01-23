
package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.commands.StopLifting;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LifterSub extends Subsystem {
    
	public Jaguar hooker = new Jaguar(5);
	double hookspeed = hooker.get();
	
	public void Hook() {
		hooker.set(1);
	}
	
	public void deHook() {
		hooker.set(-1);  
	}
	
	public void stopHooking() {
		hooker.set(0); 
	}
	
	public void advancedHooker() {
		
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new StopLifting());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

