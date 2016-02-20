package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Kicker extends Subsystem {
	static final double coefficientSpeed = -1;
	Talon kicker1 = new Talon(RobotMap.kickerA);
	Talon kicker2 = new Talon(RobotMap.kickerB);
	DigitalInput kickerSwitch = new DigitalInput(RobotMap.kickerSwitch);
	boolean kickerState;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void forward(double speed) {
		kicker1.set(coefficientSpeed * speed);
		kicker2.set(coefficientSpeed * speed);
		
	}
	
	public void backward(double speed) {
		kicker1.set(-coefficientSpeed * speed);
		kicker2.set(-coefficientSpeed * speed);
	}
	
	public void stop() {
		kicker1.set(0);
		kicker2.set(0);
	}
	
	public boolean limitSwitch() {  //return state of the kicker switch and print it to the SmartDashboard
		kickerState = kickerSwitch.get();
		SmartDashboard.putBoolean("Kicker Switch", kickerState);
		return kickerState;
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

