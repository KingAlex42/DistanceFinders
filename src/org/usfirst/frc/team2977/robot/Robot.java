
package org.usfirst.frc.team2977.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team2977.robot.commands.Shoot;
import org.usfirst.frc.team2977.robot.commands.Auto1;
import org.usfirst.frc.team2977.robot.commands.Auto2;
import org.usfirst.frc.team2977.robot.commands.Auto3;
import org.usfirst.frc.team2977.robot.commands.Auto4;
import org.usfirst.frc.team2977.robot.commands.Auto5;
import org.usfirst.frc.team2977.robot.commands.Auto6;
import org.usfirst.frc.team2977.robot.subsystems.CANChassis;
import org.usfirst.frc.team2977.robot.subsystems.ArmSubsystem;
import org.usfirst.frc.team2977.robot.subsystems.Chassis;
import org.usfirst.frc.team2977.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team2977.robot.subsystems.IOSubsystem;
import org.usfirst.frc.team2977.robot.subsystems.Kicker;
import org.usfirst.frc.team2977.robot.subsystems.Winch;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */ 
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final CANChassis chassis = new CANChassis();
	public static final IOSubsystem ioSubsystem = new IOSubsystem();
	public static final Kicker kicker = new Kicker();
	public static final Winch winchSubsystem = new Winch();
	public static final ArmSubsystem armSubsystem = new ArmSubsystem();
	public static OI oi;

    Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new Auto1());
        chooser.addObject("Position 2", new Auto2());
        chooser.addObject("Position 3", new Auto3());
        chooser.addObject("Position 4", new Auto4());
        chooser.addObject("Position 5", new Auto5());
        chooser.addObject("Position 6", new Auto6());
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
    

	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
