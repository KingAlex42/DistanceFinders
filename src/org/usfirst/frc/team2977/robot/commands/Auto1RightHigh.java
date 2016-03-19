package org.usfirst.frc.team2977.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Should be Auto 1 but shoot for high goal
 */
public class Auto1RightHigh extends CommandGroup {
		Timer autoTimer = new Timer();
    public  Auto1RightHigh() {
    	addSequential(new MedGyroCommand(6, 0));
    	addParallel(new RunKicker());
    	addSequential(new MedGyroCommand(20, 0, 86));  //Worked at 90 inches before 77 off carpet
    	addSequential(new GyroTurn(-14));
    	addSequential(new MedGyroCommand(4, 0, 22));
    	addSequential(new IntakeCommand());
    	addSequential(new TimedWait(1));
    	addSequential(new Shoot());
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
