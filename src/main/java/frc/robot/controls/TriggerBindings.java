package frc.robot.controls;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.RobotContainer;
import frc.robot.sensors.ArmLimit;
import frc.robot.subsystems.Arm;

public abstract class TriggerBindings 
{
    private static Arm arm;
    private static ArmLimit armLimit;
    private static CommandXboxController xbox;

    private TriggerBindings()
    {}

    public static void createBindings(RobotContainer robotContainer)
    {
        arm = robotContainer.getArm();
        armLimit = robotContainer.getArmLimit();
        xbox = robotContainer.getCommandXboxController();

        configXButton();
        configYButton();
    }

    private static void configXButton()
    {
        Trigger xButtonTrigger = xbox.x();
        xButtonTrigger
            .whileTrue(arm.moveUpCommand());
    }

    private static void configYButton()
    {
        Trigger yButtonTrigger = xbox.y();
        yButtonTrigger
            .whileTrue(arm.moveDownCommand());
    }
}
