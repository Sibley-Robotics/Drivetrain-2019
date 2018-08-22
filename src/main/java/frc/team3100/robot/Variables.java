package frc.team3100.robot;

public class Variables {

    public enum RelativeDirection {
        LEFT,
        RIGHT,
        FRONT,
        BACK,
        TOP,
        BOTTOM
    }

    public enum ArmPosition {
        FRONTGROUND,
        BACKGROUND,
        FRONTSWITCH,
        BACKSWITCH
    }
    public boolean clawOpenState = false;
    public boolean climbState = false;
    public boolean cubeHeld = false;
    public double drivePIDRotchange = 0;

}

