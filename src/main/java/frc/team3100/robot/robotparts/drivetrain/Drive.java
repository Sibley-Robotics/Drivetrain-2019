package frc.team3100.robot.robotparts.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.mapping.RobotMap;

public class Drive extends Command {

    private double move;
    private double rotate;

    public Drive() {
        requires(Robot.drive);
    }

    protected void initialize() {
    }

    protected void execute() {
        move = RobotMap.driveControls.getLeftStickY();
        rotate = RobotMap.driveControls.getRightStickX();

        double scalar = SmartDashboard.getNumber("Drivetrain Scalar", 1);

        move *= scalar;
        rotate *= scalar;

        Robot.drive.driveArcade(move, rotate);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        Robot.drive.stop();
    }

    protected void interrupted() {
        end();
    }
}
