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

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        move = RobotMap.driveControls.getLeftStickY();
        rotate = RobotMap.driveControls.getRightStickX();

        double scalar = SmartDashboard.getNumber("Drivetrain Scalar", 1);

        move *= scalar;
        rotate *= scalar;

        Robot.drive.driveArcade(move, rotate);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
