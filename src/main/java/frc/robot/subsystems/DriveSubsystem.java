package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Solenoid;

public class DriveSubsystem extends SubsystemBase {
    private final Solenoid highGear = new Solenoid(1); //Check the solenoid channel and update it
    private final Solenoid lowGear = new Solenoid(2); //Check the solenoid channel and update it

    private final CANSparkMax right1 = new CANSparkMax(Constants.rightDrive1, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax right2 = new CANSparkMax(Constants.rightDrive2, CANSparkMaxLowLevel.MotorType.kBrushless);
    SpeedControllerGroup right = new SpeedControllerGroup(right1, right2);

    private final CANSparkMax left1 = new CANSparkMax(Constants.leftDrive1, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax left2 = new CANSparkMax(Constants.leftDrive2, CANSparkMaxLowLevel.MotorType.kBrushless);
    SpeedControllerGroup left = new SpeedControllerGroup(left1, left2);

    DifferentialDrive drive = new DifferentialDrive(right, left);

    public DriveSubsystem() {
        final CANEncoder rightEncoder1 = right1.getEncoder();
        final CANEncoder rightEncoder2 = right2.getEncoder();

        final CANEncoder leftEncoder1 = left1.getEncoder();
        final CANEncoder leftEncoder2 = left2.getEncoder();
    }

    public void arcadeDrive(double speed, double rotation) {drive.arcadeDrive(speed, rotation);}

    public void shiftGear(int stage) {
        if (stage == 1) {
            highGear.set(true);
        } if (stage == 2) {
            lowGear.set(true);
        }
    }
}
