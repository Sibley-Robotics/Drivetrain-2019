package frc.team3100.robot.robotparts.elevator;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.mapping.RobotMap;
import frc.team3100.robot.mapping.XBoxStates;


public class Elevator extends Subsystem {

    // Defining objects from RobotMap that control the elevator
    private static SpeedController elevatorMotor = RobotMap.elevatorMotor;
    private static Counter elevationSensor = RobotMap.elevatorCounter;
    private static XBoxStates controller = RobotMap.techControls;
    private double limit = 0.1;
    private double limitedSpeed = 0;
    private double changeSpeed = 0;


    public void initDefaultCommand() {
        setDefaultCommand(new ElevatorMotion());
    }

    public void move(double speed) {
        changeSpeed = speed - limitedSpeed;
        if(changeSpeed > limit) {
            changeSpeed = limit;
        } else if (changeSpeed < -limit) {
            changeSpeed = -limit;
        }
        limitedSpeed += changeSpeed;
        if(!RobotMap.elevatorLowerButton.get() && limitedSpeed <= 0){
            elevatorMotor.set(0);
            SmartDashboard.putNumber("elevatorValues",0);
        } else {
            if (limitedSpeed < -.8) {
                limitedSpeed = -.8;
            }
            elevatorMotor.set(limitedSpeed);
        }
        SmartDashboard.putNumber("ElevatorInputSpeed",speed);
        SmartDashboard.putNumber("ElevatorActualSpeed",limitedSpeed);

    }
}