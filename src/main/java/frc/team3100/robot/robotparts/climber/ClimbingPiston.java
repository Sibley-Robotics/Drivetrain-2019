package frc.team3100.robot.robotparts.climber;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class ClimbingPiston extends Command {
    public ClimbingPiston() {
        super("ClimbingPiston");
    }

    @Override
    public void initialize() {
        if(Robot.oi.climbState) {
            Robot.climber.out();
            Robot.oi.climbState = false;
        } else {
            Robot.climber.in();
            Robot.oi.climbState = true;
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

    }
}
