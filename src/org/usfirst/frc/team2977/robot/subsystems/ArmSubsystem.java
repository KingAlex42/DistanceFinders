package org.usfirst.frc.team2977.robot.subsystems;
    
import org.usfirst.frc.team2977.robot.RobotMap;
import org.usfirst.frc.team2977.robot.commands.ArmCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
    
/** 
 *	Created by Jerry & Jimmy 
 */ 
public class ArmSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Jaguar motor = new Jaguar(RobotMap.motor);
	DigitalInput arm1 = new DigitalInput(RobotMap.limit1);
	public boolean limitBoolean;
	
	public void Arming(){		
		if (arm1.get() == true) {
			motor.set(0);
		}
	}
	public void Motoring() {
		motor.set(1); //sets motor to forward
	}
	public void ArmBack() {
		motor.set(-1); //sets motor to backward
	}
	public void ArmStop() {
		motor.set(0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ArmCommand()); 
    }
}   