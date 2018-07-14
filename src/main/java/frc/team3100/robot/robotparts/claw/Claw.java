package frc.team3100.robot.robotparts.claw;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team3100.robot.mapping.RobotMap;


public class Claw extends Subsystem {


    private SpeedController clawMotors = RobotMap.clawMotors;

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ClawDrive());
    }



    // Changes the speed of the wheels to intake or output the power cube.
    public void run(double speed) {
        clawMotors.set(speed);
    }


    public void stop() {

    }

    public void open() {
        RobotMap.clawCloser.set(false);
        RobotMap.clawOpener.set(true);
    }

    public void close() {
        RobotMap.clawOpener.set(false);
        RobotMap.clawCloser.set(true);

    }




}