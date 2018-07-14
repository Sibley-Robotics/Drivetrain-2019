package frc.team3100.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.robotparts.claw.ClawActuate;
import frc.team3100.robot.robotparts.climber.ClimbingPiston;
import frc.team3100.robot.mapping.RobotMap;
import frc.team3100.robot.mapping.XBoxStates;


public class OI {

    private XBoxStates techControls = RobotMap.techControls;
    private XBoxStates driveControls = RobotMap.driveControls;


    public Button aTech = new JoystickButton(techControls,RobotMap.aButtonChannel);
    public Button bTech = new JoystickButton(techControls,RobotMap.bButtonChannel);
    public Button xTech = new JoystickButton(techControls,RobotMap.xButtonChannel);
    public Button yTech = new JoystickButton(techControls,RobotMap.yButtonChannel);





    // Defining state variables to log the states of different subsystems
    public boolean clawOpenState = false;
    public boolean clawCollectState = false;
    public boolean climbState = false;
    public boolean cubeHeld = false;
    public boolean test = true;
    public boolean test2 = true;
    public boolean platState = false;
    public int autoRan = 0;

    public int distanceDriven = 0;





    public OI() {


        aTech.whenPressed(new ClawActuate());
        bTech.whenPressed(new ClimbingPiston());




    }
}
