package frc.team3100.robot.robotparts.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;
import frc.team3100.robot.mapping.RobotMap;

public class DriveShift extends Command {


    public DriveShift() {
        requires(Robot.drive);
    }

    protected void initialize() {
        if(Variables.driveTrainState == Variables.DriveTrainStates.low) {
            Robot.drive.shiftHigh();
            Variables.driveTrainState = Variables.DriveTrainStates.high;
        } else {
            Robot.drive.shiftLow();
            Variables.driveTrainState = Variables.DriveTrainStates.low;
        }
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}
