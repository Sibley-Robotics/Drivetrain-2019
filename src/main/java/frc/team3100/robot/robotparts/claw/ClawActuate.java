package frc.team3100.robot.robotparts.claw;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class ClawActuate extends Command {


    public ClawActuate(){
        super("ClawActuate");
    }

    @Override
    protected void initialize() {
        if(Robot.varLog.clawOpenState) {
            Robot.claw.close();
            Robot.varLog.clawOpenState = false;
        } else {
            Robot.claw.open();
            Robot.varLog.clawOpenState = true;
        }
    }

    @Override
    protected void execute() {


    }


    protected boolean isFinished() {
        return true;
    }


    protected void interrupted(){

    }

    @Override
    protected void end() {

    }
}
