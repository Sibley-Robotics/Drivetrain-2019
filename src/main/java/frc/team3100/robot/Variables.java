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

    public enum ElevatorPosition {
        GROUND,
        SWITCH,
        SCALE
    }
    public boolean clawOpenState = false;
    public boolean climbState = false;
    public boolean cubeHeld = false;
}

