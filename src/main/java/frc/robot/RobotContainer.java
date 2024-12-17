// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.sensors.ArmLimit;
import frc.robot.subsystems.Arm;

public class RobotContainer 
{
    private final Arm arm = new Arm();
    private final ArmLimit armLimit = new ArmLimit();
    private final CommandXboxController xbox = new CommandXboxController(0);

    RobotContainer() 
    {}

    public Arm getArm()
    {
        return arm;
    }

    public ArmLimit getArmLimit()
    {
        return armLimit;
    }

    public CommandXboxController getCommandXboxController()
    {
        return xbox;
    }
}
