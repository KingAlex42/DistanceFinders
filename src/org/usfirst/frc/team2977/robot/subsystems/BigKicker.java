package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.commands.StopCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BigKicker extends Subsystem {
    Jaguar kicker = new Jaguar(6);
    DigitalInput limit = new DigitalInput(6);
    public void Kicking(){
    	if(limit.get()== true){
    		kicker.set(0);
    	}
    	else if(limit.get()== false){
    		kicker.set(1);
    	}
    }
    public void Stopping(){
    	if(limit.get()== true){
    		kicker.set(0);
    	}
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
       setDefaultCommand(new StopCommand());
    }
}

