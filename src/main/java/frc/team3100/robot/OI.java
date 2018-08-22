package frc.team3100.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.autonomous.AutoArmMotion;
import frc.team3100.robot.robotparts.claw.ClawActuate;
import frc.team3100.robot.mapping.RobotMap;
import frc.team3100.robot.mapping.XBoxStates;


public class OI {

    private XBoxStates techControls = RobotMap.techControls;
    private XBoxStates driveControls = RobotMap.driveControls;


    public Button aTech = new JoystickButton(techControls,RobotMap.aButtonChannel);
    public Button bTech = new JoystickButton(techControls,RobotMap.bButtonChannel);
    public Button xTech = new JoystickButton(techControls,RobotMap.xButtonChannel);
    public Button yTech = new JoystickButton(techControls,RobotMap.yButtonChannel);


    public OI() {


        aTech.whenPressed(new ClawActuate());
        xTech.whenPressed(new AutoArmMotion(Variables.ArmPosition.FRONTGROUND));
        bTech.whenPressed(new AutoArmMotion(Variables.ArmPosition.BACKGROUND));
        yTech.whenPressed(new AutoArmMotion(Variables.ArmPosition.FRONTSWITCH));




    }
}
