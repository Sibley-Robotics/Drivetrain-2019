package frc.team3100.robot.robotparts.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.mapping.RobotMap;

/**
 * @author Jake Backer
 */
public class DriveStraightDistance extends Command {

	private double distance;

	public DriveStraightDistance(double distance) {
		requires(Robot.drive);
		this.distance = distance;
	}

	protected void initialize() {
		double leftPosition = RobotMap.leftDriveEncoder.getDistance() + distance; // Convert relative to absolute
		double rightPosition = RobotMap.rightDriveEncoder.getDistance() + distance;

		Robot.drive.setDistance(leftPosition, rightPosition);
		Robot.drive.enableEncoderPID();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return Robot.drive.leftPodPID.onTarget() && Robot.drive.rightPodPID.onTarget();
	}

	protected void end() {
		Robot.drive.disableEncoderPID();
	}

	protected void interrupted() {
		end();
	}
}
