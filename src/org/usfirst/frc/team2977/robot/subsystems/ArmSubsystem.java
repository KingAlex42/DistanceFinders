package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.commands.ArmCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *	Created by Jerry, Gari & Jimmy (not Tessss)
 */
public class ArmSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Jaguar motor = new Jaguar(7);
	DigitalInput limit1 = new DigitalInput(4);
	DigitalInput limit2 = new DigitalInput(3);
	public double motorSpeed = 1;
	public boolean limitBoolean;
	
	
	
	public void Limiting(){
		if(limit1.get() == true){
			motor.set(0);
			motorSpeed = -1;
			SmartDashboard.putBoolean("Limit 1", true);
		}
		else if(limit1.get() == false){
			SmartDashboard.putBoolean("Limit 1", false);
		}
		if(limit2.get() == true){
			motor.set(0);
			motorSpeed = 1;
			SmartDashboard.putBoolean("Limit 2", true);
		}
		else if(limit2.get() == false){
			SmartDashboard.putBoolean("Limit 2", false);
		}
	}
	public void Motoring() {
		motor.set(motorSpeed);
	}
	//public void Arming(){
			//if (limit1.get() == false){//Default.. Starts false
				//motor.set(1);
			//}
			//else if (limit1.get() == true){
				//motor.set(-1);
			//}
			//else{
				//SmartDashboard.putString("Boolean: ", "Not Defined");
			//}
		//}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ArmCommand());
    }
}