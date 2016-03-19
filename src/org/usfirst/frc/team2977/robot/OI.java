package org.usfirst.frc.team2977.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2977.robot.commands.AdamDrive;
import org.usfirst.frc.team2977.robot.commands.ArmBack;
import org.usfirst.frc.team2977.robot.commands.ArmLift;
import org.usfirst.frc.team2977.robot.commands.ArmMove;
import org.usfirst.frc.team2977.robot.commands.ArmStop;
import org.usfirst.frc.team2977.robot.commands.ClimbRoutine;
import org.usfirst.frc.team2977.robot.commands.ArmZero;
import org.usfirst.frc.team2977.robot.commands.GyroCommand;
import org.usfirst.frc.team2977.robot.commands.IntakeCommand;
import org.usfirst.frc.team2977.robot.commands.LiftDownCommand;
import org.usfirst.frc.team2977.robot.commands.LiftStop;
import org.usfirst.frc.team2977.robot.commands.LifterCommand;
import org.usfirst.frc.team2977.robot.commands.MoveWincho;
import org.usfirst.frc.team2977.robot.commands.KickerRoutine;
import org.usfirst.frc.team2977.robot.commands.KickerStop;
import org.usfirst.frc.team2977.robot.commands.OuttakeCommand;
import org.usfirst.frc.team2977.robot.commands.ResetCount;
import org.usfirst.frc.team2977.robot.commands.ResetGyro;
import org.usfirst.frc.team2977.robot.commands.RunKicker;
import org.usfirst.frc.team2977.robot.commands.GyroDataGenerator;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick stick = new Joystick(1);
	Joystick stick2 = new Joystick(2);
	Button A = new JoystickButton(stick, 1);
	Button B = new JoystickButton(stick, 2);
	Button X = new JoystickButton(stick, 3);
	Button Y = new JoystickButton(stick, 4);
	Button LB = new JoystickButton(stick, 5);
	Button RB = new JoystickButton(stick, 6);
	Button Back = new JoystickButton(stick, 7);
	Button Start = new JoystickButton(stick, 8);
	Button L3 = new JoystickButton(stick, 9);
	Button R3 = new JoystickButton(stick, 10);
	Button Y2 = new JoystickButton(stick2, 4);
	Button B2 = new JoystickButton(stick2, 5);
	Button A2 = new JoystickButton(stick2, 1);
	Button X2 = new JoystickButton(stick2, 3);
	Button Butt2 = new JoystickButton(stick2, 2);
	Button RB2 = new JoystickButton(stick2, 6);
	Button LB2 = new JoystickButton(stick2, 5);
	Button Start2 = new JoystickButton(stick2, 8);
	Button Butt9 = new JoystickButton(stick2, 9);
	Button Butt10 = new JoystickButton(stick2, 10);

	public boolean winchButton() {
		return X2.get();
	}


	public OI() {
		//Driving Controller
	
		B.whileHeld(new GyroCommand());
		LB.whenPressed(new IntakeCommand());
		RB.whileHeld(new OuttakeCommand());
		A.whenPressed(new KickerRoutine());	
		Y.whileHeld(new AdamDrive());
		//Y.whenPressed(new GyroDataGenerator(1, 15));
		//X.whenPressed(new ResetCount());
		
		//Operator Controller
		
		LB2.whenPressed(new IntakeCommand());
		RB2.whileHeld(new OuttakeCommand());
		B2.whenPressed(new ResetGyro());
		X2.whenPressed(new KickerStop());
		Start2.whenPressed(new RunKicker());
		//X2.whileHeld(new MoveWincho());
		
		
		//Start.whenPressed(new ArmMove());
		//Start.whenReleased(new ArmStop());
		//Back.whenPressed(new ArmBack());
		//Back.whenReleased(new ArmStop());
		//Y2.whenPressed(new LifterCommand());
		//Y2.whenReleased(new LiftStop());
		//B2.whenPressed(new LiftDownCommand(true));
		//B2.whenReleased(new LiftStop());
		//A2.whenPressed(new ClimbRoutine());
		//Back.whenPressed(new ArmBack());
		//Back.whenReleased(new ArmStop());  
		//Butt6.whenPressed(new ArmLift());
		//Butt6.whenReleased(new ArmStop());
		//Butt7.whenPressed(new ArmZero());
		//Butt7.whenReleased(new ArmStop());
	
		


	}
	public double getLeftY() {
		if (stick.getRawAxis(1) < -.15 | stick.getRawAxis(1)> .15){
			return -stick.getRawAxis(1);
		}
		else {
			return 0;
		}
	}
	
	public double getLeftX() {
		if (stick.getRawAxis(0) < -.15 | stick.getRawAxis(0)> .15){
			return -stick.getRawAxis(0);
		}
		else {
			return 0;
		}
	}
	
	
	public double getLeftX2() {
		if (stick2.getRawAxis(0) < -.15 | stick2.getRawAxis(0)> .15){
			return -stick2.getRawAxis(0);
		}
		else {
			return 0;
		}
	}
	
	public double getRightY() { 
		if (stick.getRawAxis(5) < -.15 | stick.getRawAxis(5) > .15) {
			return -stick.getRawAxis(5);			
		}
		else {
			return 0;
		}

		
		
	}
		public double getRightX() { 
			if (stick.getRawAxis(4) < -.15 | stick.getRawAxis(4) > .15) {

				return -stick.getRawAxis(4);
						
			}
			else {
				return 0;
			}
		}
			
			public double getRightX2() { 
				if (stick2.getRawAxis(4) < -.15 | stick2.getRawAxis(4) > .15) {

					return -stick2.getRawAxis(4);
							
				}
				else {
					return 0;
				}
				
	}


		


	

			
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

