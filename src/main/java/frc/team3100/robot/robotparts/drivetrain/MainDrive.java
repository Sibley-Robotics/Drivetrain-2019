package frc.team3100.robot.robotparts.drivetrain;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Dashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.mapping.RobotMap;
import frc.team3100.robot.mapping.XBoxStates;

import static com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput;


public class MainDrive extends Subsystem implements Dashboard.DashboardUpdatable {



    private double dMoveLimit = 0.1;
    private double limitedMoveLeft = 0;
    private double limitedMoveRight = 0;
    drivetrain1 =

    public MainDrive() {
        super("MainDrive");
    }

    public void shiftLow() {

    }

    public void shiftHigh() {

    }

    public void initDefaultCommand() {setDefaultCommand(new Drive());}




    public void driveArcade(double inputMoveLeft, double inputMoveRight) {


        double dMoveLeft = inputMoveLeft - limitedMoveLeft;
        if (dMoveLeft > dMoveLimit) {
            dMoveLeft = dMoveLimit;
        } else if (dMoveLeft < -dMoveLimit) {
            dMoveLeft = -dMoveLimit;
        }

        limitedMoveLeft += dMoveLeft;



        double dMoveRight = inputMoveLeft - limitedMoveRight;
        if(dMoveRight > dMoveLimit) {
            dMoveRight = dMoveLimit;
        } else if (dMoveRight < -dMoveLimit) {
            dMoveRight = -dMoveLimit;
        }

        limitedMoveRight += dMoveRight;

        RobotMap.leftDriveMotor1.set(PercentOutput, limitedMoveLeft);
        RobotMap.rightDriveMotor1.set(PercentOutput, limitedMoveRight);

    }

    public void initSD() {


    }

    public void updateSD() {

    }
}