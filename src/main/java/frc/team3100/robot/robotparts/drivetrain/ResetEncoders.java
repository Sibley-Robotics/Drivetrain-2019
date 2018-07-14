package frc.team3100.robot.robotparts.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.mapping.RobotMap;

public class ResetEncoders extends Command {

    public ResetEncoders() {
        setRunWhenDisabled(true);
    }

    protected void initialize() {
        RobotMap.leftDriveEncoder.reset();
        RobotMap.rightDriveEncoder.reset();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {

    }

    protected void interrupted() {
        end();
    }
}

