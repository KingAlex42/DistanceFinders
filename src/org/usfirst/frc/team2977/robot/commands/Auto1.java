package org.usfirst.frc.team2977.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *	Goes through the low bar and shoots for the low goal.  Possibility: Shoot at high goal?
 */
public class Auto1 extends CommandGroup {
	Timer autoTimer = new Timer();
    
    public  Auto1() {
    	autoTimer.start();
    	addSequential(new GyroCommand(5, 0));
    	addSequential(new GyroCommand(20, 0, 50));
    	addSequential(new GyroTurn(-10.5));
    	addSequential(new GyroCommand(4, 0));
    	addSequential(new OuttakeCommand(2));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
