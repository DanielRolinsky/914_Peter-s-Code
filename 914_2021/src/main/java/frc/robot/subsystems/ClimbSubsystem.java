package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ClimbSubsystem extends SubsystemBase {
    private final WPI_TalonSRX climbMotor1 = new WPI_TalonSRX(Constants.climb1);
    private final WPI_TalonSRX climbMotor2 = new WPI_TalonSRX(Constants.climb2);

    public void extendClimber() {
        climbMotor1.set(ControlMode.PercentOutput, 0.1); //Check the direction of each motor and if one needs to be reversed.
        climbMotor2.set(ControlMode.PercentOutput, 0.1); //Check the direction of each motor and if one needs to be reversed.
    }

    public void retractClimber() {
        climbMotor1.set(ControlMode.PercentOutput, -0.1); //Check the direction of each motor and if one needs to be reversed.
        climbMotor2.set(ControlMode.PercentOutput, -0.1); //Check the direction of each motor and if one needs to be reversed.
    }
}
