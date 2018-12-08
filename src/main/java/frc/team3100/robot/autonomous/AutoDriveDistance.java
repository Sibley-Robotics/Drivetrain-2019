package frc.team3100.robot.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.mapping.RobotMap;

public class AutoDriveDistance extends Command {
    private double inputTarget;
    private double targetValLeft;
    private double targetValRight;
    private double ticksPerInch = 100;

    public AutoDriveDistance(int distance) {
        super("AutoDriveDistance");
        this.inputTarget = distance * ticksPerInch;
        requires(Robot.drive);
    }

    public void initialize() {
        /*
        Robot.drive.setSetpoint(RobotMap.gyro.getAngle());
        Robot.drive.enable();
        RobotMap.leftDriveEncoder.reset();
        RobotMap.rightDriveEncoder.reset();
        */
    }

    public void execute() {
        /*
        if(targetValLeft > RobotMap.leftDriveEncoder.get()) {
            Robot.drive.driveArcade( (1-(RobotMap.leftDriveEncoder.get()/inputTarget) + .1) ,0);
        } else {
            Robot.drive.driveArcade( -1 * (1-(RobotMap.leftDriveEncoder.get()/inputTarget) + .1),0);
        }
        */


    }

    public boolean isFinished() {
        /*
        if(Math.abs(RobotMap.leftDriveEncoder.get())-Math.abs(inputTarget) < 100) {
            return true;
        } else {
            return false;
        } */
        return true;
    }

    public void end() {


    }

    public void interrupted() { end(); }
}

