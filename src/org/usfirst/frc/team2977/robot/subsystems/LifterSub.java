
package org.usfirst.frc.team2977.robot.subsystems;



import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LifterSub extends Subsystem {
	public Jaguar lifter = new Jaguar(5);
	
	
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
   
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


