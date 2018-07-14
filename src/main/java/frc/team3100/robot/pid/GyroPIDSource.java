package frc.team3100.robot.pid;


import frc.team3100.robot.mapping.RobotMap;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;


public class GyroPIDSource implements PIDSource {
	@Override
	public void setPIDSourceType(PIDSourceType pidSourceType) {

	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet() {
		return RobotMap.gyro.getAngle();
	}
}
