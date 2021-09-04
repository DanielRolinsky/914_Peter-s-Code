package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;

public class IntakeSubsystem extends SubsystemBase {

    private final WPI_VictorSPX intakeRollers = new WPI_VictorSPX(Constants.intakeRollers);

    private final Solenoid Solenoid1 = new Solenoid(0);
    //private final Solenoid Solenoid2 = new Solenoid(0, 5);
    //private final Solenoid Solenoid3 = new Solenoid(0, 6);
    //private final Solenoid Solenoid4 = new Solenoid(0, 7);

    public final void intake(double speed) {
        intakeRollers.set(ControlMode.PercentOutput, speed);
    }

    public final void dropIntake() {
        //Solenoid.set(true);
        Solenoid1.set(true);
        /** Solenoid.toggle();*/
        //Solenoid2.toggle();
    }

    public final void pullIntake() {
        //Solenoid.set(false);
        Solenoid1.set(false);
    }
}
