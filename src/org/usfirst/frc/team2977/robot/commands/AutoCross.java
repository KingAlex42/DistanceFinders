package org.usfirst.frc.team2977.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *	Just Crosses a Defense
 */
public class AutoCross extends CommandGroup {
		Timer autoTimer = new Timer();
    public  AutoCross() {
    	autoTimer.start();
    	addSequential(new Shoot());
    	addParallel(new RunKicker());
    	addSequential(new GyroTurn(-15));
    	addSequential(new GyroCommand(5,0));
    	addSequential(new GyroTurn(42));
    	addSequential(new GyroCommand(5,0));
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