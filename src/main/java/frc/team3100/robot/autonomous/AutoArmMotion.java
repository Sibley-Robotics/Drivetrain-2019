package frc.team3100.robot.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables.ArmPosition;
import frc.team3100.robot.mapping.RobotMap;
import frc.team3100.robot.mapping.XBoxStates;

public class AutoArmMotion extends Command {
    private int frontBottomPos = -1000;
    private int backBottomPos = 1000;
    private int frontSwitchPos = -500;
    private int backSwitchPos = 500;
    private ArmPosition target;
    private int targetNum;

    public AutoArmMotion(ArmPosition targetPos) {
        super("AutoArmMotion");
        this.target = targetPos;
        requires(Robot.arm);
    }

    public void initialize() {
        if(target == ArmPosition.FRONTGROUND) {
            targetNum = frontBottomPos;
        } else if(target == ArmPosition.BACKGROUND) {
            targetNum = backBottomPos;
        } else if(target == ArmPosition.FRONTSWITCH) {
            targetNum = frontSwitchPos;
        } else {
            targetNum = backSwitchPos;
        }
        Robot.arm.setSetpoint(targetNum);
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

