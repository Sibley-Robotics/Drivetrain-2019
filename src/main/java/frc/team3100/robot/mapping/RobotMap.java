package frc.team3100.robot.mapping;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.interfaces.Gyro;


public class RobotMap {

    //     C O N T R O L L E R S
    private static int driveController = 1;
    private static int techController = 2;

    //     P W M
    private static int armChannel = 1;
    private static int clawChannel = 3;

    //     C A N
    private static int driveLeftChannel = 1;
    private static int driveRightChannel = 0;

    //     P C M
    private static int clawCloseChannel = 0;
    private static int clawOpenChannel = 1;
    private static int UPP2Channel = 2;
    private static int UPP3Channel = 3;
    private static int UPP4Channel = 4;
    private static int UPP5Channel = 5;

    //     D I O
    private static int armEncoderAChannel = 0;
    private static int armEncoderBChannel = 1;
    private static int armFrontButtonChannel = 4;
    private static int armBackButtonChannel = 5;
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

    //    Initialize speed controllers
    public static SpeedController leftDriveMotor = new WPI_TalonSRX(driveLeftChannel);
    public static SpeedController rightDriveMotor = new WPI_TalonSRX(driveRightChannel);
    public static SpeedController armMotor = new Spark(armChannel);
    public static SpeedController clawMotors = new Spark(clawChannel);

    //    Initialize pneumatic controllers (solenoids)
    public static Solenoid clawCloser = new Solenoid(clawCloseChannel);
    public static Solenoid clawOpener = new Solenoid(clawOpenChannel);

    //    Initialize servos


    //    Initialize sensors
    public static Gyro gyro = new ADXRS450_Gyro();
    public static DigitalInput armFrontButton = new DigitalInput(armFrontButtonChannel);
    public static DigitalInput armBackButton = new DigitalInput(armBackButtonChannel);
    public static Encoder armEncoder = new Encoder(armEncoderAChannel,armEncoderBChannel);





}
