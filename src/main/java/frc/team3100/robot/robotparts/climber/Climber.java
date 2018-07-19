package frc.team3100.robot.robotparts.climber;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team3100.robot.mapping.RobotMap;


public class Climber extends Subsystem {

    // Defining objects from RobotMap that control the claw
    private SpeedController climbMotors = RobotMap.climbMotor;
    private Solenoid climbOut = RobotMap.climbOut;
    private Solenoid climbIn = RobotMap.climbIn;

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Climbing());
    }

    public void move(double speed) {
        climbMotors.set(speed);
    }

    public void out() {
        climbOut.set(true);
        climbIn.set(false);
    }

    public void in() {
        climbOut.set(false);
        climbIn.set(true);

    }



}