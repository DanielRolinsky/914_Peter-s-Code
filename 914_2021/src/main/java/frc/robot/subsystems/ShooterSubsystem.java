package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANEncoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ShooterSubsystem extends SubsystemBase {
    private final CANSparkMax rightWheel = new CANSparkMax(Constants.Shooter_rightWheel, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax leftWheel = new CANSparkMax(Constants.Shooter_leftWheel, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax angleAdjust = new CANSparkMax(Constants.Shooter_angle, CANSparkMaxLowLevel.MotorType.kBrushless);

    private final CANEncoder leftWheelEncoder = leftWheel.getEncoder();
    private final CANEncoder rightWheelEncoder = rightWheel.getEncoder();
    private final CANEncoder angleAdjustEncoder = angleAdjust.getEncoder();

    public final XboxController masterController = new XboxController(0);

    public void rotationDirection() {
        //leftWheel.setInverted(false);
        //rightWheel.setInverted(false);

        /**
        leftWheelEncoder.setInverted(true);
        rightWheelEncoder.setInverted(false);

        angleAdjust.setInverted(false);
        angleAdjustEncoder.setInverted(false);
        */
    }

    public void shoot(double speed) {
        leftWheel.set(-speed);
        rightWheel.set(speed);
        /**
        double leftVelocity = leftWheelEncoder.getVelocity();
        double rightVelocity = rightWheelEncoder.getVelocity();
        double newSpeed = speed;

        while (rightVelocity != leftVelocity) {
            if (rightVelocity > leftVelocity && (leftVelocity + rightVelocity) / 2 < .85) {
                leftWheel.set(newSpeed + .01);
                newSpeed = newSpeed + .01;
            } if (rightVelocity < leftVelocity && (leftVelocity + rightVelocity) / 2 < .85) {
                rightWheel.set(newSpeed + .01);
                newSpeed = newSpeed + .01;
            } if (rightVelocity > leftVelocity && (leftVelocity + rightVelocity) / 2 > .85) {
                rightWheel.set(newSpeed - .01);
                newSpeed = newSpeed - .01;
            } if (rightVelocity < leftVelocity && (leftVelocity + rightVelocity) / 2 > .85) {
                leftWheel.set(newSpeed - .01);
                newSpeed = newSpeed - .01;
            }
        }*/
    }

    public void stopShooting() {
        leftWheel.set(0);
        rightWheel.set(0);
    }

    @Override
    public void periodic() {
        if (masterController.getY(GenericHID.Hand.kRight) > .25) {
            angleAdjust.set(0.05);
        } else if (masterController.getY(GenericHID.Hand.kRight) < -.25) {
            angleAdjust.set(-0.05);
        } else if (masterController.getY(GenericHID.Hand.kRight) > -.24 && masterController.getY(GenericHID.Hand.kRight) < .24) {
            angleAdjust.set(0);
        } else if (masterController.getTriggerAxis(GenericHID.Hand.kRight) > 0) {
            leftWheel.set(-masterController.getTriggerAxis(GenericHID.Hand.kRight));
            rightWheel.set(masterController.getTriggerAxis(GenericHID.Hand.kRight));
        }
    }
    /**
    public void adjustAngleUp() {
        while (angleAdjustEncoder.getPosition() < 6.6) {
            angleAdjust.set(0.02);
        }
    }
    public void adjustAngleDown() {
        while (angleAdjustEncoder.getPosition() > -2.88) {
            angleAdjust.set(-0.02);
        }
    }*/
}
