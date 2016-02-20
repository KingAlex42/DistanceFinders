package org.usfirst.frc.team2977.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *	Moves through the defense to the right of the low bar and shoots in the low goal
 */
public class Auto2 extends CommandGroup {
		Timer autoTimer = new Timer();
    public  Auto2() {
    	autoTimer.start();
    	addSequential(new SlowGyroCommand(5, 0));
    	addSequential(new GyroCommand(20, 0, 63));
    	addSequential(new GyroTurn(-14));
    	addSequential(new SlowGyroCommand(1, 0));
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
