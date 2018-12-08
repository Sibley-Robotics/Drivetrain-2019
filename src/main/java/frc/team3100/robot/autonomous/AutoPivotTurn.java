package frc.team3100.robot.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.mapping.RobotMap;

public class AutoPivotTurn extends Command {
    private int inputTarget;
    private double targetVal;

    public AutoPivotTurn(int rotVal) {
        super("AutoPivotTurn");
        this.inputTarget = rotVal;
        requires(Robot.drive);
    }

    public void initialize() {
        targetVal = RobotMap.gyro.getAngle() + inputTarget;
        if (targetVal < 0) {
            targetVal += 360;
        }
        Robot.drive.setSetpoint(targetVal);
        Robot.drive.enable();
    }

    public void execute() {




    }

    public boolean isFinished() {
        if(Robot.drive.onTarget()) {
            return true;
        } else {
            return false;
        }
    }

    public void end() {


    }

    public void interrupted() { end(); }
}

