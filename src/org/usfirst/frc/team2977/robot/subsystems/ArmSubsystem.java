package org.usfirst.frc.team2977.robot.subsystems;
    
import org.usfirst.frc.team2977.robot.RobotMap;
import org.usfirst.frc.team2977.robot.commands.ArmZero;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
    
/** 
 *	Created by Jerry & Jimmy (pretty much Alekai) 
 */ 
public class ArmSubsystem extends Subsystem {
	Jaguar motor = new Jaguar(RobotMap.arm);
	DigitalInput arm1 = new DigitalInput(RobotMap.armSwitch);
	Encoder armEncoder = new Encoder(RobotMap.armA, RobotMap.armB);
	
	public void zeroEncoder() {
		armEncoder.reset();
	}
	
	//----------Getting Encoder Stuff----------------------//
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

			else {
				return false;
			}
	}
			
	public void printEncoder() {
		encoderDistance();
		encoderCount();



	}
	
	public void MoveForward() {
		if (encoderCount() >= 3 | encoderCount() <= 3.1) {
			motor.set(RobotMap.armPower);
		}
		else if (encoderCount() > 5 | encoderCount() <= 5.1) {
			motor.set(RobotMap.armPower);
		}
		else if (encoderCount() > 7) {
			motor.set(0);
		}
		else if (encoderCount() < 3) {
			motor.set(-RobotMap.armPower);
		}
		else if (encoderCount() == 0 | arm1.get() == true) {
			motor.set(0);
			armEncoder.reset();
		}
			
		else {
			motor.set(0);
		}
	}

	
	//---------LimitSwitch---------------------------------//
	public boolean limitSwitch() {
		boolean limit = !arm1.get();
		SmartDashboard.putBoolean("ArmSwitch", limit);
		return limit;
	}
	
	public void lift() {
		motor.set(-RobotMap.armMaxPower);
	}
	

	//----------Methods to Move Arm------------------------//

	public void Motoring() {
		motor.set(-RobotMap.armPower); //sets motor to forward
		printEncoder();
	}
	
	public void ArmBack() {
		motor.set(RobotMap.armPower); //sets motor to backward
		printEncoder();
	}
	
	public void ArmStop() {
		motor.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
}   