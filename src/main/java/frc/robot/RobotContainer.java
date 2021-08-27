// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  public final DriveSubsystem Drivetrain = new DriveSubsystem();

  public final XboxController masterController = new XboxController(0);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    Drivetrain.setDefaultCommand(new RunCommand(() -> Drivetrain.arcadeDrive(masterController.getY(GenericHID.Hand.kLeft), masterController.getX(GenericHID.Hand.kLeft)), Drivetrain));
  }

  final IntakeSubsystem Intake = new IntakeSubsystem();
  final IndexSubsystem Index = new IndexSubsystem();
  final ShooterSubsystem Shoot = new ShooterSubsystem();
  final ClimbSubsystem Climb = new ClimbSubsystem();

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    new JoystickButton(masterController, 2)
            .whileHeld(
            () -> {
              IntakeCommand Intaking = new IntakeCommand(true, Intake);
            },
            Intake);

    /**new JoystickButton(masterController, 2)
            .whileHeld(
              () -> {
                IndexCommand Indexing = new IndexCommand(true, false, Index);
              },
              Index);
*/
    /**if (masterController.getAButton()) {
      IntakeCommand Intaking = new IntakeCommand(true, Intake);
    }
    if (masterController.getXButton()) {
      IndexCommand Indexing = new IndexCommand(true, false, Index);
    }
    if (masterController.getTriggerAxis(GenericHID.Hand.kRight) != 0) {
      double speed = masterController.getTriggerAxis(GenericHID.Hand.kRight);
      if (speed > 1) {
        speed = speed / 100; //Getting the value of speed lower than 1 since the scale value given by the remote is unknown
      }
      ShooterCommand Shooting = new ShooterCommand(false, false, true, speed, Shoot);
    }
    if (masterController.getY(GenericHID.Hand.kRight) != 0) {
      if (masterController.getY(GenericHID.Hand.kRight) > 0) {
        ShooterCommand Shooting = new ShooterCommand(true, false, false, 0, Shoot);
      }
      if (masterController.getY(GenericHID.Hand.kRight) < 0) {
        ShooterCommand Shooting = new ShooterCommand(false, true, false, 0, Shoot);
      }
    }
    if (masterController.getYButtonPressed()) {
      ClimbCommand Climbing = new ClimbCommand(false, false, Climb);
      if (Climbing.latestAction == 'r') {
        ClimbCommand ClimbingE = new ClimbCommand(true, false, Climb);
      }
      if (Climbing.latestAction == 'e') {
        ClimbCommand ClimbingR = new ClimbCommand(false, true, Climb);
      }
    } else if (true) {
      IntakeCommand Intaking = new IntakeCommand(true, Intake);
    }  //Add drive binding */

    SmartDashboard.putBoolean("AButtonValue", masterController.getAButton());
  }
    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
     public Command getAutonomousCommand() {
      // An ExampleCommand will run in autonomous
      return m_autoCommand;
     }
}
