package frc.team3100.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.robotparts.claw.Claw;
import frc.team3100.robot.robotparts.drivetrain.MainDrive;
import frc.team3100.robot.robotparts.arm.Arm;
import frc.team3100.robot.mapping.RobotMap;


public class Robot extends IterativeRobot{
    private Command AutoChosen;
    private boolean ran = false;
    // Define subsystems for Commands to access
    public static Claw claw;
    public static Arm arm;
    public static MainDrive drive;
    public static Variables varLog;
    public static OI oi;

    // Define variables used later in the Robot class
    public static boolean autoVal;
    public static String gameData;
    private static final int IMG_WIDTH = 320;
    private static final int IMG_HEIGHT = 240;
    private int autoTime = 0;


    public void robotInit() {

        SmartDashboard.putNumber("P",1);
        SmartDashboard.putNumber("I",0);
        SmartDashboard.putNumber("D",0);
        SmartDashboard.putNumber("target",0);


        //Creating a camera object and defining its characteristics
        UsbCamera server = CameraServer.getInstance().startAutomaticCapture("cam2", 0);
        server.setBrightness(20);
        server.setResolution(IMG_WIDTH, IMG_HEIGHT);
        gameData = DriverStation.getInstance().getGameSpecificMessage();

        //Creates instances of all of the subsystems for the autonomous to access.
        claw = new Claw();
        arm = new Arm();
        drive = new MainDrive();
        varLog = new Variables();

        // ALWAYS initialize OI after subsystems
        oi = new OI();




        SmartDashboard.putData("MainDrive", drive);
        RobotMap.clawOpener.set(false);
        RobotMap.clawCloser.set(true);
        RobotMap.UPP2.set(false);
        RobotMap.UPP3.set(true);
        RobotMap.UPP4.set(false);
        RobotMap.UPP5.set(true);
        RobotMap.gyro.calibrate();

    }


    public void autonomousInit() {
        RobotMap.gyro.reset();
        // What to run ONCE at the beginning of the autonomous period
        autoVal = true;
    }

    public void autonomousPeriodic() {
        // Running auto code for the first 15 seconds of the match.
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("autoVal",autoVal);
    }

    public void teleopInit() {
        // Setting autoVal equal to false so the auto code stops running
        RobotMap.gyro.reset();
        if(autoVal) {
            if(AutoChosen.isRunning()) {
                AutoChosen.cancel();
            }
        }
        autoVal = false;


    }

    public void teleopPeriodic() {
        // Starts the scheduler for the teleop period to run the autonomous
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("autoVal",autoVal);
        SmartDashboard.putNumber("EncoderPos",RobotMap.armEncoder.get());
        SmartDashboard.putNumber("EncoderRate",RobotMap.armEncoder.getRate());
        SmartDashboard.putNumber("PIDgetSetpoint",Robot.arm.getSetpoint());
        SmartDashboard.putNumber("PIDgetPosition",Robot.arm.getPosition());
        SmartDashboard.putData("Arm",Robot.arm);
        SmartDashboard.putNumber("ArmMove",RobotMap.techControls.getLeftStickY());
        SmartDashboard.putData("PID",Robot.arm.getPIDController());





    }

     public void testInit() {
         autoVal = false;
         // this is the part where Anne gets to write whatever the frickity fraack she wants

    }

    public void testPeriodic() {
        Robot.arm.setSetpoint(SmartDashboard.getNumber("target",0));
        // Starts the scheduler for the teleop period to run the autonomous
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("autoVal",autoVal);
        SmartDashboard.putNumber("EncoderPos",RobotMap.armEncoder.get());
        SmartDashboard.putNumber("EncoderRate",RobotMap.armEncoder.getRate());
        SmartDashboard.putNumber("PIDgetSetpoint",Robot.arm.getSetpoint());
        SmartDashboard.putNumber("PIDgetPosition",Robot.arm.getPosition());
        SmartDashboard.putData("PID",Robot.arm.getPIDController());
    }

    public void disabledInit() {
        ran = false;
        RobotMap.gyro.reset();

    }

    public void disabledPeriodic() {

    }

}

