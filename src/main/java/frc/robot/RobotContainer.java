// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer 
{
    private TalonFX motor = new TalonFX(1);
    // private CANSparkMax motor = new CANSparkMax(3, CANSparkLowLevel.MotorType.kBrushless);
    private CommandXboxController xbox = new CommandXboxController(0);

    public RobotContainer() 
    {
        configureBindings();
    }

    private void configureBindings() 
    {
        xbox.a()
            .whileTrue( Commands.runEnd( 
                () -> motor.set(0.1),
                () -> motor.set(0.0) 
            ) );
    }

    public Command getAutonomousCommand() 
    {
        return Commands.print("No autonomous command configured");
    }

    public TalonFX getMotor()
    {
        return motor;
    }

    // public CANSparkMax getMotor()
    // {
    //     return motor;
    // }
}
