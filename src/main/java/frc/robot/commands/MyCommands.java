package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.RobotContainer;
import frc.robot.sensors.ArmLimit;
import frc.robot.subsystems.Arm;

public abstract class MyCommands
{
    private static Arm arm;
    private static ArmLimit armLimit;
    private static CommandXboxController xbox;

    private MyCommands()
    {}

    public static void createMyCommands(RobotContainer robotContainer)
    {
        arm = robotContainer.getArm();
        armLimit = robotContainer.getArmLimit();
        xbox = robotContainer.getCommandXboxController();
    }

    public static Command autonomousCommand()
    {
        return
        arm.moveUpCommand()
            .withTimeout(3.0)
        .andThen( arm.moveDownCommand()
            .withTimeout(2.0) )
        .andThen( arm.stopCommand() ); 
        // Commands.runOnce( () -> arm.moveUp() )
        // .andThen( Commands.waitSeconds(3.0) )
        // .andThen( Commands.runOnce( () -> arm.moveDown() ) )
        // .andThen( Commands.waitSeconds(2.0) )
        // .andThen( arm.stopCommand() ); 
    }
}
