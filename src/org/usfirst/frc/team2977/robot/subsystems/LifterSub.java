
package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.commands.StopLifting;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LifterSub extends Subsystem {
    
	public Jaguar lifter = new Jaguar(5);
	double lifterspeed = lifter.get();
	
	public void Lift() {
		lifter.set(1);
	}
	
	public void deLift() {
		lifter.set(-1);  
	}
	
	public void stopLifting() {
		lifter.set(0); 
	}
	
	//public void advancedLift() {
		
	//}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new StopLifting());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


