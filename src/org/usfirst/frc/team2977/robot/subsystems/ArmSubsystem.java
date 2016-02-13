package org.usfirst.frc.team2977.robot.subsystems;
    
import org.usfirst.frc.team2977.robot.RobotMap;
import org.usfirst.frc.team2977.robot.commands.ArmCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
    
/** 
 *	Created by Jerry & Jimmy 
 */ 
public class ArmSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Jaguar motor = new Jaguar(RobotMap.arm);
	DigitalInput arm1 = new DigitalInput(RobotMap.limit1);
	boolean limit;
	
	
	public void Arming(){	
		limit = limitSwitch();
		SmartDashboard.putBoolean("ArmCAM", limit);
		if (limit) {
			motor.set(0);
		}
	}
	
	public boolean limitSwitch() {
		return !arm1.get();
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