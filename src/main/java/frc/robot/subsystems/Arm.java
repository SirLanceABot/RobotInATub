package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase
{
    private TalonFX motor = new TalonFX(1);
    // private CANSparkMax motor = new CANSparkMax(3, CANSparkLowLevel.MotorType.kBrushless);
    
    public Arm()
    {}

    public void moveUp()
    {
        motor.set(0.1);
    }

    public void moveDown()
    {
        motor.set(-0.1);
    }

    public void stop()
    {
        motor.set(0.0);
    }

    public Command moveUpCommand()
    {
        return 
        runEnd(
            () -> moveUp(),
            () -> stop()
        );
    }

    public Command moveDownCommand()
    {
        return
        runEnd(
            this::moveDown,
            this::stop
        );
    }

    public Command stopCommand()
    {
        return runOnce( () -> stop() );
    }
}
