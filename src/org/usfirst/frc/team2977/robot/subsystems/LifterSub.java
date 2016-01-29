
package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.commands.ShaftEncoderCommand;

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
	public DigitalSource aChannel;
    public DigitalSource bChannel;
	Encoder encoder = new Encoder(aChannel, bChannel);
	int shaft = encoder.get();

	public void Lift() {
		motor.set(1);
	}
	
	public void stopLifting() {
		motor.set(0); 
	}
	
	public void advancedLifter() {
		SmartDashboard.putNumber("Encoder Value", encoder.get());
		if (encoder.get() >= 0 | shaft != 1);
			motor.set(-1);
			
		if (encoder.get() == 0);
			motor.set(0);	
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new ShaftEncoderCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

