package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class IndexSubsystem {

    private final WPI_VictorSPX indexRollers = new WPI_VictorSPX(Constants.indexRollers);

    public final void index (double speed) {
        indexRollers.set(ControlMode.PercentOutput,speed);
    }
}
