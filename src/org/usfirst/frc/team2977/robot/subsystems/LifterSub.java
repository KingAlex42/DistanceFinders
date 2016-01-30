
package org.usfirst.frc.team2977.robot.subsystems;



import org.usfirst.frc.team2977.robot.commands.ShaftStop;

import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LifterSub extends Subsystem {
    
	public Jaguar motor = new Jaguar(5);
	double motorspeed = motor.get();


	public void Lift() {
		motor.set(1);
	}
	
	public void stopLifting() {
		motor.set(0); 
	}
	

	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new ShaftStop());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

