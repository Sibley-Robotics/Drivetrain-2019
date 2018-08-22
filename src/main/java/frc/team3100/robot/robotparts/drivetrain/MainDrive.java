package frc.team3100.robot.robotparts.drivetrain;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.mapping.RobotMap;
import frc.team3100.robot.mapping.XBoxStates;


public class MainDrive extends PIDSubsystem {

    private DifferentialDrive driveTrain = new DifferentialDrive(RobotMap.leftDriveMotor,RobotMap.rightDriveMotor);
    private static SpeedController leftMotor = RobotMap.leftDriveMotor;
    private static SpeedController rightMotor = RobotMap.rightDriveMotor;
    private static XBoxStates controller = RobotMap.techControls;
    private double dMoveLimit = SmartDashboard.getNumber("MoveLimitValue",0.1);
    private double dRotateLimit = SmartDashboard.getNumber("RotateLimitValue",0.1);
    private double limitedMove = 0;
    private double limitedRotate = 0;

    public MainDrive() {
        super("MainDrive", SmartDashboard.getNumber("P",0),
                SmartDashboard.getNumber("I",0),
                SmartDashboard.getNumber("D",0));
        getPIDController().setInputRange(0,360);
        getPIDController().setContinuous(true);
        setOutputRange(-1,1);

    }

    protected double returnPIDInput() {
        return RobotMap.gyro.getAngle(); // returns the sensor value that is providing the feedback for the system
    }

    protected void usePIDOutput(double output) {
        SmartDashboard.putNumber("drivePIDoutput",output);
        Robot.varLog.drivePIDRotchange = output;
    }

    public void initDefaultCommand() {setDefaultCommand(new Drive());}


    public void stop() {
        limitedRotate = 0;
        limitedMove = 0;
        driveArcade(0,0);
    }

    public void driveArcade(double inputMove, double inputRotate) {
        inputRotate += Robot.varLog.drivePIDRotchange;
        double dMove = inputMove - limitedMove;
        if (dMove > dMoveLimit) {
            dMove = dMoveLimit;
        } else if (dMove < -dMoveLimit) {
            dMove = -dMoveLimit;
        }

        limitedMove += dMove;
        SmartDashboard.putNumber("driveMove", limitedMove);

        double dRotate = inputRotate - limitedRotate;
        if(dRotate > dRotateLimit) {
            dRotate = dRotateLimit;
        } else if (dRotate < -dRotateLimit) {
            dRotate = -dRotateLimit;
        }

        limitedRotate += dRotate;
        SmartDashboard.putNumber("driveRotate",limitedRotate);

        driveTrain.arcadeDrive(limitedMove,limitedRotate);
    }
}