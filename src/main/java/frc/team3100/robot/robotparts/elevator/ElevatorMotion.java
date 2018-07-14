package frc.team3100.robot.robotparts.elevator;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.mapping.RobotMap;
import frc.team3100.robot.mapping.XBoxStates;

public class ElevatorMotion extends Command {


    public ElevatorMotion() {
        super("ElevatorMotion");
        requires(Robot.elevator);
    }
    private static XBoxStates controller = RobotMap.techControls;

    public void initialize() {

    }

    public void execute() {
        Robot.elevator.move(-controller.getLeftStickY());
    }

    public boolean isFinished() {
        return false;
    }

    public void end() {

    }

    public void interrupted() {


    }
}

