package frc.team3100.robot.robotparts.arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.mapping.RobotMap;
import frc.team3100.robot.mapping.XBoxStates;

public class ArmMotion extends Command {


    public ArmMotion() {
        super("ArmMotion");
        requires(Robot.arm);
    }
    private boolean ran = true;
    private static XBoxStates controller = RobotMap.techControls;

    public void initialize() {
        Robot.arm.disable();
    }

    public void execute() {
        if(Math.abs(controller.getLeftStickY()) > .1) {
            if(!ran) {
                Robot.arm.disable();
                ran = true;
            }
            Robot.arm.move(-controller.getLeftStickY());
        } else {
            if(ran) {
                Robot.arm.setSetpoint(RobotMap.armEncoder.get());
                Robot.arm.enable();
                ran = false;
            }
        }
    }

    public boolean isFinished() {
        return false;
    }

    public void end() {

    }

    public void interrupted() {


    }
}

