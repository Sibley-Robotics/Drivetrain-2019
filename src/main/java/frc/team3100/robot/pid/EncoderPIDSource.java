package frc.team3100.robot.pid;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class EncoderPIDSource implements PIDSource {
	private Encoder encoder;

	public EncoderPIDSource(Encoder encoder) {
		this.encoder = encoder;
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet() {
		return this.encoder.getDistance();
	}
}
