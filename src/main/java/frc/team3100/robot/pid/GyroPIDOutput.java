package frc.team3100.robot.pid;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class GyroPIDOutput implements PIDOutput {

	private DifferentialDrive dd;

	public GyroPIDOutput(DifferentialDrive dd) {
		this.dd = dd;
	}

	@Override
	public void pidWrite(double output) {
		dd.arcadeDrive(0, -output);
	}
}
