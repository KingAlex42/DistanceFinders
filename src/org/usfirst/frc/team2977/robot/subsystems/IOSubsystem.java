package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.RobotMap;
import org.usfirst.frc.team2977.robot.commands.INITCommand;
//import org.usfirst.frc.team2977.robot.commands.IntakeCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
//import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IOSubsystem extends Subsystem {
	
    Talon intaker = new Talon (RobotMap.intaker);
    DigitalInput intakeLimit = new DigitalInput(RobotMap.intakeLimit);
    
    public void INIT() {
    	if (intakeLimit.get() == true) {
    		SmartDashboard.putBoolean("Inny Takey", true);
    		intaker.set(0);
    		
    	}
    	else if (intakeLimit.get() == false) {
    		SmartDashboard.putBoolean("Inny Takey", false);
    		}
    }
    
    public void Outtake() {
    	intaker.set(-1);
    }
    public void Intake() {
    	intaker.set(1);
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
    	setDefaultCommand(new INITCommand());
        // Set the default command for a subsystem here.
    }
}