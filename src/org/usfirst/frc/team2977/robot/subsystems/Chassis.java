package org.usfirst.frc.team2977.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {
	
	public Talon m1 = new Talon(1);
	public Talon m2 = new Talon(2);
	public Talon m3 = new Talon(3);
	public Talon m4 = new Talon(4);
	
	public void Drive(double speed, double rotate) {
		m1.set(speed + rotate);
		m2.set(speed - rotate);
		m3.set(speed + rotate);
		m4.set(speed - rotate);	
	}
		 // Put methods for controlling this subsystem //
        // here. Call these from Commands.            //
	   // Put methods for controlling this subsystem //
	  // here. Call these from Commands.            //
	 // Put methods for controlling this subsystem //
    // here. Call these from Commands.            //
   // Put methods for controlling this subsystem //
  // here. Call these from Commands.            //
 // Put methods for controlling this subsystem //
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new ());
    }
}

