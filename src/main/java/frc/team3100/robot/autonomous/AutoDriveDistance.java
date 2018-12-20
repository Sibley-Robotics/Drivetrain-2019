package frc.team3100.robot.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.mapping.RobotMap;

public class AutoDriveDistance extends Command {
    private double inputTarget;
    private double targetValLeft;
    private double targetValRight;
    private double ticksPerInch = 100;

    public AutoDriveDistance(int distance) {
        super("AutoDriveDistance");
        this.inputTarget = distance * ticksPerInch;
        requires(Robot.drive);
    }

    public void initialize() {

    }

    public void execute() {



    }

    public boolean isFinished() {
        return true;
    }

    public void end() {


    }

    public void interrupted() {  }
}

