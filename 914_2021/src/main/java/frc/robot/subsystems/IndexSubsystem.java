package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class IndexSubsystem extends SubsystemBase{

    private final WPI_VictorSPX indexRollers = new WPI_VictorSPX(Constants.indexRollers);

    public final void index (double speed) {
        indexRollers.set(ControlMode.PercentOutput,speed);
    }
}
