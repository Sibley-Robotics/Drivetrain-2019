package frc.team3100.robot.robotparts.claw;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class ClawActuate extends Command {

    // Since this does not affect any other claw function, we do not have to require all other claw actions to stop.
    // This avoids a one-tick long stutter in the intake motors.

    public ClawActuate(){
        super("ClawActuate");
    }

    private boolean clawOpen = Robot.varLog.clawOpenState;

    @Override
    protected void initialize() {
        if(clawOpen) {
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
