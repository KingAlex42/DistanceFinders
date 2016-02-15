package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.RobotMap;
//import org.usfirst.frc.team2977.robot.commands.IntakeCommand;
import org.usfirst.frc.team2977.robot.commands.StopOuttake;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
//import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IOSubsystem extends Subsystem {
	boolean intaked;
	final static double intakeSpeed = 1;
	Talon intaker = new Talon (RobotMap.intaker);
    DigitalInput intakeLimit = new DigitalInput(RobotMap.intakeLimit);
    
    public void INIT() {
    	if (intakeLimit.get()) {
    		SmartDashboard.putBoolean("Inny Takey", true);
    		intaker.set(0);
    		
    	}
    	else if (!intakeLimit.get()) {
    		SmartDashboard.putBoolean("Inny Takey", false);
    		}
    }
    
    public boolean limitSwitch() {
    	intaked = !intakeLimit.get();
    	SmartDashboard.putBoolean("IntakeSwitch", intaked);
    	return intaked;
    }
    
    public boolean intakerRunning() {
    	SmartDashboard.putNumber("Intake.get()", intaker.get());
    	return intaker.get() != (double) 0;
    }
    
    public void Outtake() {
    	intaker.set(1 * intakeSpeed);
    }
    public void Intake() {
    	intaker.set(-1 * intakeSpeed);
    }
    public void Stop() {
    	intaker.set(0);
    }
    
    	//if (intakeLimit.get() == false) {
    		//SmartDashboard.putBoolean("Limit 1", false);
    	//}
    	//if (intakeLimit.get() == true) {
    		//SmartDashboard.putBoolean("Limit 1", true);
    		//intaker.set(0);
    		
    	//}
    //}
    //public void Intaking() {
    	
    	//if (intakeLimit.get() == false) {
    		//intaker.set(-1);
    		//SmartDashboard.putBoolean("Limit 1", false);
    	//}
    	//else if (intakeLimit.get() == true) {
    		//intaker.set(0);
    		//SmartDashboard.putBoolean("Limit 1", true);
    		
    	//}
    //}
    

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new StopOuttake());
        // Set the default command for a subsystem here.
    }
}