package frc.team3100.robot.robotparts.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.mapping.RobotMap;

public class Drive extends Command {


    public Drive() {
        requires(Robot.drive);
    }

    protected void initialize() {

    }

    protected void execute() {
        Robot.drive.driveArcade(RobotMap.driveControls.getLeftStickY(), RobotMap.driveControls.getRightStickX());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}
