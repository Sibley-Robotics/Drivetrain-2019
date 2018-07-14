package frc.team3100.robot.mapping;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.interfaces.Gyro;


public class RobotMap {

    //     C O N T R O L L E R S
    public static int driveController = 1;
    public static int techController = 2;

    //     P W M
    private static int driveLeftChannel = 1;
    private static int driveRightChannel = 2;
    private static int elevatorChannel = 4;
    private static int clawChannel = 3;
    private static int platformChannel = 5;
    private static int platformDeployLeftChannel = 6;
    private static int platformDeployRightChannel = 7;
    private static int climberMotorChannel = 8;

    //     P C M
    private static int clawCloseChannel = 0;
    private static int clawOpenChannel = 1;
    private static int UPP2Channel = 2;
    private static int UPP3Channel = 3;
    private static int climbOutChannel = 4;
    private static int climbInChannel = 5;

    //     D I O
    private static int driveLeftCounterChannel = 2;
    private static int driveRightCounterChannel = 1;
    private static int elevatorCounterChannel = 0;
    private static int clawButtonChannel = 3;
    private static int elevatorLowerLimitChannel = 4;
    private static int elevatorUpperLimitChannel = 5;
    private static int leftDriveChannelA = 6;
    private static int leftDriveChannelB = 7;
    private static int rightDriveChannelA = 8;
    private static int rightDriveChannelB = 9;

    //     X B O X
    public static final int rightXAxisChannel = 4;
    public static final int rightYAxisChannel = 5;
    public static final int leftXAxisChannel = 0;
    public static final int leftYAxisChannel = 1;

    public static final int aButtonChannel = 1;
    public static final int bButtonChannel = 2;
    public static final int xButtonChannel = 3;
    public static final int yButtonChannel = 4;

    public static final int rightBumperChannel = 6;
    public static final int leftBumperChannel = 5;

    public static final int rightTriggerChannel = 3;
    public static final int leftTriggerChannel = 2;




    //    Initialize XBox Controllers
    public static XBoxStates driveControls = new XBoxStates(driveController);
    public static XBoxStates techControls = new XBoxStates(techController);

    //    Initialize speed controllers          This is the ONLY spot sparks should be referenced
    public static SpeedController leftDriveMotor = new Spark(driveLeftChannel);
    public static SpeedController rightDriveMotor = new Spark(driveRightChannel);
    public static SpeedController elevatorMotor = new Spark(elevatorChannel);
    public static SpeedController clawMotors = new Spark(clawChannel);
    public static SpeedController platformMotor = new Spark(platformChannel);
    public static SpeedController climbMotor = new Spark(climberMotorChannel);

    //    Initialize pneumatic controllers (solenoids)
    public static Solenoid clawCloser = new Solenoid(clawCloseChannel);
    public static Solenoid clawOpener = new Solenoid(clawOpenChannel);
    public static Solenoid climbOut = new Solenoid(climbOutChannel);
    public static Solenoid climbIn = new Solenoid(climbInChannel);
    public static Solenoid UPP2 = new Solenoid(UPP2Channel);
    public static Solenoid UPP3 = new Solenoid(UPP3Channel);

    //    Initialize servos
    public static Servo platformDeployLeft = new Servo(RobotMap.platformDeployLeftChannel);
    public static Servo platformDeployRight = new Servo(RobotMap.platformDeployRightChannel);


    //    Initialize sensors
    public static Gyro gyro = new ADXRS450_Gyro();
    public static Counter elevatorCounter = new Counter(elevatorCounterChannel);
    public static Counter leftDriveCounter = new Counter(driveLeftCounterChannel);
    public static Counter rightDriveCounter = new Counter(driveRightCounterChannel);
    public static DigitalInput clawButton = new DigitalInput(clawButtonChannel);
    public static DigitalInput elevatorUpperButton = new DigitalInput(elevatorUpperLimitChannel);
    public static DigitalInput elevatorLowerButton = new DigitalInput(elevatorLowerLimitChannel);

    public static Encoder leftDriveEncoder = new Encoder(leftDriveChannelA,leftDriveChannelB);
    public static Encoder rightDriveEncoder = new Encoder(rightDriveChannelA,rightDriveChannelB);





}
