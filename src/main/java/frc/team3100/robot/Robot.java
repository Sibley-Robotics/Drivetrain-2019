package frc.team3100.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.robotparts.claw.Claw;
import frc.team3100.robot.robotparts.climber.Climber;
import frc.team3100.robot.autonomous.*;
import frc.team3100.robot.robotparts.drivetrain.MainDrive;
import frc.team3100.robot.robotparts.drivetrain.StartEncoderPID;
import frc.team3100.robot.robotparts.elevator.Elevator;
import frc.team3100.robot.robotparts.elevator.ElevatorMotion;
import frc.team3100.robot.mapping.RobotMap;


public class Robot extends IterativeRobot{
    private Command ElevatorMotion;
    private Command AutoChosen;
    private SendableChooser <Character> autoChoice;
    private SendableChooser <Character> autoType;
    private SendableChooser <Character> autoPriority;
    private SendableChooser <Character> autoFar;
    private boolean ran = false;
    // Define subsystems for Commands to access
    public static Claw claw;
    public static Climber climber;
    public static Elevator elevator;
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

        //Creating a camera object and defining its characteristics
        UsbCamera server = CameraServer.getInstance().startAutomaticCapture("cam2", 0);
        server.setBrightness(20);
        server.setResolution(IMG_WIDTH, IMG_HEIGHT);
        gameData = DriverStation.getInstance().getGameSpecificMessage();

        //Creates instances of all of the subsystems for the autonomous to access.
        claw = new Claw();
        climber = new Climber();
        elevator = new Elevator();
        drive = new MainDrive();
        varLog = new Variables();

        // ALWAYS initialize OI after subsystems
        oi = new OI();


        //Unless you need something from it...
        ElevatorMotion = new ElevatorMotion();

        RobotMap.leftDriveCounter.setDistancePerPulse(1);
        RobotMap.rightDriveCounter.setDistancePerPulse(1);

        SmartDashboard.putData("MainDrive", drive);
        RobotMap.clawOpener.set(false);
        RobotMap.climbOut.set(true);
        RobotMap.UPP2.set(true);
        RobotMap.clawCloser.set(true);
        RobotMap.UPP3.set(true);
        RobotMap.climbIn.set(false);
        RobotMap.elevatorCounter.reset();
        RobotMap.gyro.calibrate();


        autoChoice = new SendableChooser<>();
        autoChoice.addDefault("Auto-Run",'A');
        autoChoice.addObject("Left", 'L');
        autoChoice.addObject("Center", 'C');
        autoChoice.addObject("Right", 'R');
        SmartDashboard.putData("Autonomous",autoChoice);

        autoType = new SendableChooser<>();
        autoType.addObject("In Front of Switch", 'O');
        autoType.addDefault("To the Side of the Switch",'N');
        SmartDashboard.putData("Type", autoType);

        autoPriority = new SendableChooser<>();
        autoPriority.addDefault("Scale",'C');
        autoPriority.addObject("Switch",'W');
        SmartDashboard.putData("Priority",autoPriority);

        autoFar = new SendableChooser<>();
        autoFar.addDefault("Yes",'Y');
        autoFar.addObject("No", 'N');
        SmartDashboard.putData("Far Side",autoFar);

        RobotMap.leftDriveEncoder.setDistancePerPulse(1 / 39.92);
        RobotMap.rightDriveEncoder.setDistancePerPulse(1 / 39.92);
        RobotMap.leftDriveMotor.setInverted(true);
        RobotMap.rightDriveMotor.setInverted(true);

        SmartDashboard.putNumber("Left Encoder P", drive.leftPodPID.getP());
        SmartDashboard.putNumber("Left Encoder I", drive.leftPodPID.getI());
        SmartDashboard.putNumber("Left Encoder D", drive.leftPodPID.getD());
        SmartDashboard.putNumber("Left Encoder Setpoint", 0);

        SmartDashboard.putNumber("Right Encoder P", drive.rightPodPID.getP());
        SmartDashboard.putNumber("Right Encoder I", drive.rightPodPID.getI());
        SmartDashboard.putNumber("Right Encoder D", drive.rightPodPID.getD());
        SmartDashboard.putNumber("Right Encoder Setpoint", 0);
        SmartDashboard.putData(new StartEncoderPID());
    }


    public void autonomousInit() {
        RobotMap.gyro.reset();
        // What to run ONCE at the beginning of the autonomous period
        gameData = DriverStation.getInstance().getGameSpecificMessage();
        autoVal = true;
    }

    public void autonomousPeriodic() {
        // Running auto code for the first 15 seconds of the match.
        if(!ran) {
            if (gameData.length() == 0 && autoTime < 200) {
                gameData = DriverStation.getInstance().getGameSpecificMessage();
            } else {
                AutoChosen = new AutoMaster(autoChoice.getSelected(),gameData,autoType.getSelected(),autoPriority.getSelected(),autoFar.getSelected());
                AutoChosen.start();
                ran = true;
            }
        }
        Scheduler.getInstance().run();
        autoTime += 1;
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
        ElevatorMotion.start();
        autoVal = false;
        RobotMap.platformDeployLeft.set(.3);
        RobotMap.platformDeployRight.set(.4);


    }

    public void teleopPeriodic() {
        // Starts the scheduler for the teleop period to run the autonomous
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("autoVal",autoVal);
        SmartDashboard.putBoolean("cubeHeld",Robot.varLog.cubeHeld);
        SmartDashboard.putBoolean("test",Robot.varLog.test);
        SmartDashboard.putBoolean("test2",Robot.varLog.test2);
        SmartDashboard.putData("Autonomous",autoChoice);
        SmartDashboard.putString("autoPriority",gameData + autoPriority.getSelected() + autoType.getSelected() + autoChoice.getSelected());

    }

     public void testInit() {
         autoVal = false;
         // this is the part where Anne gets to write whatever the frickity fraack she wants

    }

    public void testPeriodic() {
        // Starts the scheduler to test different autonomous.
        Scheduler.getInstance().run();
    }

    public void disabledInit() {
        ran = false;
        RobotMap.gyro.reset();
        RobotMap.leftDriveEncoder.reset();
        RobotMap.rightDriveEncoder.reset();

    }

    public void disabledPeriodic() {

    }

}

