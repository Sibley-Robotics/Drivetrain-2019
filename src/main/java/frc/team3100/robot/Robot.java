package frc.team3100.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.robotparts.drivetrain.MainDrive;
import frc.team3100.robot.mapping.RobotMap;


public class Robot extends IterativeRobot{
    private Command AutoChosen;
    private boolean ran = false;
    // Define subsystems for Commands to access
    public static Compressor compressor;
    public static MainDrive drive;
    public static Variables varLog;
    public static OI oi;

    // Define variables used later in the Robot class
    public static boolean autoVal;
    public static String gameData;



    public void robotInit() {


        gameData = DriverStation.getInstance().getGameSpecificMessage();

        //Creates instances of all of the subsystems for the autonomous to access.
        compressor = new Compressor();
        drive = new MainDrive();
        varLog = new Variables();

        // ALWAYS initialize OI after subsystems
        oi = new OI();


        RobotMap.leftDriveMotor2.follow(RobotMap.leftDriveMotor1);
        RobotMap.leftDriveMotor3.follow(RobotMap.leftDriveMotor1);
        RobotMap.rightDriveMotor2.follow(RobotMap.rightDriveMotor2);
        RobotMap.rightDriveMotor3.follow(RobotMap.rightDriveMotor3);

        SmartDashboard.putData("MainDrive", drive);
        RobotMap.gyro.calibrate();

    }


    public void autonomousInit() {

        RobotMap.gyro.reset();
        // What to run ONCE at the beginning of the autonomous period
        autoVal = true;
        SmartDashboard.putBoolean("autoVal",autoVal);
    }

    public void autonomousPeriodic() {
        // Running auto code for the first 15 seconds of the match.
        Scheduler.getInstance().run();
        Dashboard.updateDashboard();
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
        SmartDashboard.putBoolean("autoVal",autoVal);


    }

    public void teleopPeriodic() {
        // Starts the scheduler for the teleop period to run the autonomous
        Scheduler.getInstance().run();
        Dashboard.updateDashboard();





    }

     public void testInit() {
         autoVal = false;
         SmartDashboard.putBoolean("autoVal",autoVal);
         // this is the part where Anne gets to write whatever the frickity fraack she wants

    }

    public void testPeriodic() {
        // Starts the scheduler for the teleop period to run the autonomous
        Scheduler.getInstance().run();
        Dashboard.updateDashboard();

    }

    public void disabledInit() {
        ran = false;
        RobotMap.gyro.reset();

    }

    public void disabledPeriodic() {

    }

}

