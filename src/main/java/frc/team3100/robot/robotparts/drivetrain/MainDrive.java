package frc.team3100.robot.robotparts.drivetrain;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.team3100.robot.OI;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;
import frc.team3100.robot.mapping.RobotMap;
import frc.team3100.robot.pid.DrivePodPIDOutput;
import frc.team3100.robot.pid.EncoderPIDSource;


public class MainDrive extends Subsystem {

    private final EncoderPIDSource leftPodPIDSource;
    private final EncoderPIDSource rightPodPIDSource;
    public final PIDController leftPodPID;
    public final PIDController rightPodPID;



    public DifferentialDrive driveTrain = new DifferentialDrive(RobotMap.leftDriveMotor,RobotMap.rightDriveMotor);



    public MainDrive() {
        leftPodPIDSource = new EncoderPIDSource(RobotMap.leftDriveEncoder);
        leftPodPID = new PIDController(0.05, 0.00001, 0, leftPodPIDSource,
                new DrivePodPIDOutput(RobotMap.leftDriveMotor, true));
        leftPodPID.disable();
        leftPodPID.setOutputRange(-.8, 0.8);
        leftPodPID.setAbsoluteTolerance(2);

        rightPodPIDSource = new EncoderPIDSource(RobotMap.rightDriveEncoder);
        rightPodPID = new PIDController(0.05, 0.00001, 0, rightPodPIDSource,
                new DrivePodPIDOutput(RobotMap.rightDriveMotor));
        rightPodPID.disable();
        rightPodPID.setOutputRange(-0.8, 0.8);
        rightPodPID.setAbsoluteTolerance(2);
    }

    public void initDefaultCommand() {setDefaultCommand(new Drive());}

    public void driveArcade(double move, double rotate) {
        driveTrain.arcadeDrive(move, rotate);
    }

    public void driveTank(double left,double right) {
        driveTrain.tankDrive(left,right);
    }

    public void stop() {
        driveTank(0, 0);
    }

    public void setEncoderPID(Variables.RelativeDirection side, double p, double i, double d) {
        if (side == Variables.RelativeDirection.LEFT) {
            leftPodPID.setPID(p, i, d);
        } else {
            rightPodPID.setPID(p, i, d);
        }
    }

    public void setDistance(double distance) {
        leftPodPID.setSetpoint(distance);
        rightPodPID.setSetpoint(distance);
    }

    public void setDistance(double leftDistance, double rightDistance) {
        leftPodPID.setSetpoint(leftDistance);
        rightPodPID.setSetpoint(rightDistance);
    }

    public boolean encodersOnTarget() {
        final double ABSOLUTE_TOLERANCE = 3.0; // TODO: Change this to something more reasonable???
        return Math.abs((leftPodPID.getSetpoint() - leftPodPIDSource.pidGet())) <= ABSOLUTE_TOLERANCE &&
                Math.abs((rightPodPID.getSetpoint() - rightPodPIDSource.pidGet())) <= ABSOLUTE_TOLERANCE;
    }

    public void enableEncoderPID() {
        leftPodPID.enable();
        rightPodPID.enable();
    }

    public void disableEncoderPID() {
        leftPodPID.disable();
        rightPodPID.disable();
    }


}