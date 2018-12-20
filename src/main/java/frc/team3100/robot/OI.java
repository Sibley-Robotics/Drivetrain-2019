package frc.team3100.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.mapping.RobotMap;
import frc.team3100.robot.mapping.XBoxStates;
import frc.team3100.robot.robotparts.drivetrain.DriveShift;


public class OI {

    private XBoxStates driveControls = RobotMap.driveControls;


    public Button shifter = new JoystickButton(driveControls,RobotMap.aButtonChannel);


    public OI() {
        shifter.whenPressed(new DriveShift());




    }
}
