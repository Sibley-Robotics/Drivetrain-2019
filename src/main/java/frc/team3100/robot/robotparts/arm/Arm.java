package frc.team3100.robot.robotparts.arm;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.mapping.RobotMap;
import frc.team3100.robot.mapping.XBoxStates;


public class Arm extends PIDSubsystem {

    // Defining objects from RobotMap that control the arm
    private static SpeedController armMotor = RobotMap.armMotor;
    private static XBoxStates controller = RobotMap.techControls;
    private double limit = 0.1;
    private double limitedSpeed = 0;
    private double changeSpeed = 0;

    public Arm() {
        super("Arm", SmartDashboard.getNumber("P",1),
                SmartDashboard.getNumber("I",0),
                SmartDashboard.getNumber("D",0));
        setAbsoluteTolerance(2);
        getPIDController().setContinuous(false);
        setOutputRange(-.8,.8);
    }



    protected double returnPIDInput() {
        return RobotMap.armEncoder.get(); // returns the sensor value that is providing the feedback for the system
    }

    protected void usePIDOutput(double output) {
        SmartDashboard.putNumber("ArmSpeed",output);
        this.move(-output); // this is where the computed output value from the PIDController is applied to the motor
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ArmMotion());
    }

    public void move(double speed) {
        changeSpeed = speed - limitedSpeed;
        if(changeSpeed > limit) {
            changeSpeed = limit;
        } else if (changeSpeed < -limit) {
            changeSpeed = -limit;
        }
        limitedSpeed += changeSpeed;

        if(!RobotMap.armBackButton.get() && limitedSpeed <= 0){
            armMotor.set(0);
        } else if (!RobotMap.armFrontButton.get() && limitedSpeed >= 0) {
            armMotor.set(0);
        } else {
            if (limitedSpeed < -.8) {
                limitedSpeed = -.8;
            } else if (limitedSpeed > .8) {
                limitedSpeed = .8;
            }
            SmartDashboard.putNumber("ArmSpeed",limitedSpeed);
            armMotor.set(limitedSpeed);
        }

    }
}