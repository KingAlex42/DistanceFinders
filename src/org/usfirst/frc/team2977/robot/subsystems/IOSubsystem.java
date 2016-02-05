package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.RobotMap;
import org.usfirst.frc.team2977.robot.commands.INITCommand;


//import org.usfirst.frc.team2977.robot.commands.IntakeCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
//import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IOSubsystem extends Subsystem {
	
    Jaguar intaker = new Jaguar (RobotMap.intaker);
    DigitalInput intakeLimit = new DigitalInput(2);
    boolean intaked = intakeLimit.get();
    
    public void INIT() {
    	if (intaked = true) {
    		SmartDashboard.putBoolean("Inny Takey", true);
    		intaker.set(0);
    	}
    	else if (intaked = false) {
    		SmartDashboard.putBoolean("Inny Takey", false);
    		intaker.set(1);
    	}
    	else {
    		
    	}
    }
    public void Intake() {
    	intaker.set(1);
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
    
    public void Outtaking() {
    	if (intakeLimit.get() == false) {
    		intaker.set(1);
    	}
    	else if (intakeLimit.get() == true) {
    		intaker.set(0);
    	}
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new INITCommand());
    	//setDefaultCommand(new OuttakeCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}