package frc.team3100.robot.pid;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedController;

public class DrivePodPIDOutput implements PIDOutput {

	private SpeedController c;
	private boolean inverted;


	public DrivePodPIDOutput(SpeedController c, boolean inverted) {
		this.c = c;
		this.inverted = inverted;
	}

	public DrivePodPIDOutput(SpeedController c) {
		this(c, false);
	}

	@Override
	public void pidWrite(double output) {
		c.set(inverted ? -output : output);
	}

}
