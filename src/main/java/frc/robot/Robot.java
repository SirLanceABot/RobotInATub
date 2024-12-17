// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.MyCommands;
import frc.robot.controls.TriggerBindings;

public class Robot extends TimedRobot 
{
    private Command autonomousCommand = null;
    private final RobotContainer robotContainer = new RobotContainer();

    public Robot()
    {
        System.out.println("J Wood");
        MyCommands.createMyCommands(robotContainer);
        TriggerBindings.createBindings(robotContainer);
    }

    @Override
    public void robotPeriodic() 
    {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void disabledInit() 
    {}

    @Override
    public void disabledPeriodic() 
    {}

    @Override
    public void disabledExit() 
    {}

    @Override
    public void autonomousInit() 
    {
        autonomousCommand = MyCommands.autonomousCommand();

        if (autonomousCommand != null) 
        {
            autonomousCommand.schedule();
        }
    }

    @Override
    public void autonomousPeriodic() 
    {}

    @Override
    public void autonomousExit() 
    {
        // if (autonomousCommand != null) 
        // {
        //     autonomousCommand.cancel();
        //     autonomousCommand = null;
        // }
    }

    @Override
    public void teleopInit() 
    {
        if (autonomousCommand != null) 
        {
            autonomousCommand.cancel();
            autonomousCommand = null;
        }        
    }

    @Override
    public void teleopPeriodic() 
    {}

    @Override
    public void teleopExit() 
    {}

    @Override
    public void testInit() 
    {
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void testPeriodic() 
    {}

    @Override
    public void testExit() 
    {}
}
