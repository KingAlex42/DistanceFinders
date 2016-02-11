package org.usfirst.frc.team2977.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//CAN
	public static int m1 = 2;	//front right
	public static int m2 = 4;	//front left	
	public static int m3 = 3;	//back right
	public static int m4 = 1;	//back left
	
	//PWM
	public static int winch = 5;
	public static int intaker = 0;
	public static int arm = 1;
	public static int kickerA = 2;
	public static int kickerB = 3;
	public static int lifter = 4;  //Victor
	
	//DigitalInput
	public static int intakeLimit = 1;
	public static int winchLimit = 0;
	public static int kickerSwitch = 2;  //Not Made Yet
	
	//Analog
	public static int gyro = 0;
	
	//Constants
	public static int gyroCoefficient = 42;
	public static int kickerMaxSpeed = 1;  //max speed for the kicker

    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
