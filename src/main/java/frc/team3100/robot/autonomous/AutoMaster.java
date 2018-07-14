package frc.team3100.robot.autonomous;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team3100.robot.robotparts.drivetrain.*;

/*
COPY AND PASTE THESE

TO DRIVE FORWARDS:
addSequential(new AutoDriveForwards(FEET));

TO DRIVE BACKWARDS:
addSequential(new AutoDriveBackwards(FEET));

TO TURN RIGHT:
addSequential(new AutoDriveTurnRight(DEGREES));

TO TURN LEFT:
addSequential(new AutoDriveTurnLeft(DEGREES));

TO COLLECT A CUBE:
addSequential(new AutoCubeCollect());

*/
public class AutoMaster extends CommandGroup {
    public AutoMaster(Character autoChoice, String autoData, Character autoType, Character autoPriority, Character autoFar) {
        addSequential(new DriveStraightDistance(10));

    }
}
