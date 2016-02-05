package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.RobotMap;
import org.usfirst.frc.team2977.robot.commands.LiftStop;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lifter extends Subsystem {
    Jaguar lifter = new Jaguar(8);
    DigitalInput lifterSwitch = new DigitalInput(3);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void Lifting() {
    	if(lifterSwitch.get() == true) {
    		lifter.set(0);
    	}
    	else if (lifterSwitch.get() == false) {
    		lifter.set(1);
    	}
    }
    public void StopLifting() {
    	lifter.set(0);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new LiftStop());
    }
}

