package frc.team3100.robot.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables.ArmPosition;
import frc.team3100.robot.mapping.RobotMap;

public class AutoArmMotion extends Command {
    private ArmPosition target;

    public AutoArmMotion(ArmPosition targetPos) {
        super("AutoArmMotion");
        this.target = targetPos;
        requires(Robot.arm);
    }

    public void initialize() {
        Robot.arm.setSetpoint(target.getPosition());
        Robot.arm.enable();
    }

    public void execute() {




    }

    public boolean isFinished() {
        if(Math.abs(RobotMap.techControls.getLeftStickY()) > .1) {
            return true;
        } else {
            return false;
        }
    }

    public void end() {
        Robot.arm.disable();

    }

    public void interrupted() { end(); }
}

