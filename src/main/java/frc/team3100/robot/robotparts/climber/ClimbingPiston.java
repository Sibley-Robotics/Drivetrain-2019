package frc.team3100.robot.robotparts.climber;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;

public class ClimbingPiston extends Command {
    public ClimbingPiston() {
        super("ClimbingPiston");
    }

    @Override
    public void initialize() {
        if(Robot.varLog.climbState) {
            Robot.climber.out();
            Robot.varLog.climbState = false;
        } else {
            Robot.climber.in();
            Robot.varLog.climbState = true;
        }
    }

    @Override
    public void execute() {


    }

    public boolean isFinished() {
        return true;
    }

    @Override
    public void end() {

    }

    public void interrupted() {
        end();
    }
}
