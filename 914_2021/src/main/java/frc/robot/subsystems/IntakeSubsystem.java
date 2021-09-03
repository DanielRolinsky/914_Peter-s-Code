package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    private final WPI_VictorSPX intakeRollers = new WPI_VictorSPX(Constants.intakeRollers);
    // Add solenoid for the intake drop down

    public final void intake(double speed) {
        intakeRollers.set(ControlMode.PercentOutput, speed);
    }

    // Add function for intake drop down

}
