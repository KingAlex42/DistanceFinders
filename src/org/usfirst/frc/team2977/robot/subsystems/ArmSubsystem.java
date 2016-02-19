package org.usfirst.frc.team2977.robot.subsystems;
    
import org.usfirst.frc.team2977.robot.RobotMap;
import org.usfirst.frc.team2977.robot.commands.ArmZero;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
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
	DigitalInput arm1 = new DigitalInput(RobotMap.armSwitch);
	Encoder armEncoder = new Encoder(RobotMap.armA, RobotMap.armB);
	

	public int encoderCount() {
		int encoderCount = armEncoder.get();
		
		SmartDashboard.putNumber("EncoderCount", encoderCount);
		return encoderCount;
		
	}
	
	public double encoderDistance() {
		double encoderDistance = armEncoder.getDistance();
		SmartDashboard.putNumber("EncoderDistance", encoderDistance);
		return encoderDistance;
	}
	
	public boolean isZeroed(){	 
		if (limitSwitch()) {
			armEncoder.reset();
			return true;
		}
		return false;

	}
	
	public void printEncoder() {
		encoderDistance();
		encoderCount();
	}
	
	
	public boolean limitSwitch() {
		boolean limit = !arm1.get();
		SmartDashboard.putBoolean("ArmCAM", limit);
		return limit;
	}
	
	public void lift() {
		motor.set(RobotMap.armMaxPower);
	}
	
	public void Motoring() {
		motor.set(RobotMap.armPower); //sets motor to forward
		printEncoder();
	}
	public void ArmBack() {
		motor.set(-RobotMap.armPower); //sets motor to backward
		printEncoder();
	}
	public void ArmStop() {
		motor.set(0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ArmZero()); 
    }
}   