package frc.team3100.robot.robotparts.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.Variables;




public class StartEncoderPID extends Command {

	public StartEncoderPID() {
		requires(Robot.drive);
	}

	protected void initialize() {
		Robot.drive.setEncoderPID(Variables.RelativeDirection.LEFT, SmartDashboard.getNumber("Left Encoder P", 0),
				SmartDashboard.getNumber("Left Encoder I", 0),
				SmartDashboard.getNumber("Left Encoder D", 0));
		Robot.drive.setEncoderPID(Variables.RelativeDirection.RIGHT, SmartDashboard.getNumber("Right Encoder P", 0),
				SmartDashboard.getNumber("Right Encoder I", 0),
				SmartDashboard.getNumber("Right Encoder D", 0));
		Robot.drive.setDistance(SmartDashboard.getNumber("Left Encoder Setpoint", 0),
				SmartDashboard.getNumber("Right Encoder Setpoint", 0));
		Robot.drive.enableEncoderPID();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		System.out.println("End");
		Robot.drive.disableEncoderPID();
	}

	protected void interrupted() {
		end();
	}
}
