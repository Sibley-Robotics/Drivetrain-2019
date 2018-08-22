package frc.team3100.robot.robotparts.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.mapping.RobotMap;

public class Drive extends Command {

    private double move;
    private double rotate;
    private boolean ran = true;
    private double JoystickEpsilon = 0.1;

    public Drive() {
        requires(Robot.drive);
    }

    protected void initialize() {
        Robot.drive.disable();
    }

    protected void execute() {
        double scalar = SmartDashboard.getNumber("Drivetrain Scalar", 1);
        move = RobotMap.driveControls.getLeftStickY() * scalar;
        rotate = RobotMap.driveControls.getRightStickX() * scalar;

        if(Math.abs(rotate) > JoystickEpsilon) {
            if(!ran) {
                Robot.drive.disable();
                ran = true;
            }
        } else {
            if(ran) {
                Robot.drive.setSetpoint(RobotMap.gyro.getAngle());
                Robot.drive.enable();
            }
        }

        Robot.drive.driveArcade(move, rotate);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {

    }

    protected void interrupted() {
        end();
    }
}
