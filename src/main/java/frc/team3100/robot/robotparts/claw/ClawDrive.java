package frc.team3100.robot.robotparts.claw;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.mapping.RobotMap;
import frc.team3100.robot.mapping.XBoxStates;

public class ClawDrive extends Command {


    public ClawDrive(){
        super("ClawDrive");
        requires(Robot.claw);
    }
    private static XBoxStates controller = RobotMap.techControls;
    private double triggerError = 0.1;

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        SmartDashboard.putNumber("triggerVal",controller.getLeftTrigger());
        if(controller.getLeftTrigger() > triggerError) {
            Robot.claw.run(controller.getLeftTrigger());
        } else if(controller.getRightTrigger() > triggerError) {
            Robot.claw.run(-controller.getRightTrigger());
        } else {
            Robot.claw.run(0);
        }
        SmartDashboard.putBoolean("ClawState1",Robot.oi.clawOpenState);

    }


    protected boolean isFinished() {
        return false;
    }


    protected void interrupted(){

    }

    @Override
    protected void end() {

    }
}
