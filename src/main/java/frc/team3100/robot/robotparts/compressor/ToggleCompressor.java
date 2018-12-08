package frc.team3100.robot.robotparts.compressor;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

/**
 *
 */
public class ToggleCompressor extends Command {

    public ToggleCompressor() {}

    protected void initialize() {
    	boolean state = Robot.compressor.getClosedLoopControl();
    	Robot.compressor.setClosedLoopControl(!state);
    }

    protected void execute() {}

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
