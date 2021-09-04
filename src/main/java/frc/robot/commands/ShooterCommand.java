package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand extends CommandBase{
    boolean adjustAngleUp;
    boolean adjustAngleDown;
    boolean shoot;
    double shootingSpeed;
    ShooterSubsystem Shooter;

    public ShooterCommand(boolean adjustAngleUp, boolean adjustAngleDown, boolean shoot, double shootingSpeed, ShooterSubsystem Shooter) {
        this.adjustAngleUp = adjustAngleUp;
        this.adjustAngleDown = adjustAngleDown;
        this.shoot = shoot;
        this.shootingSpeed = shootingSpeed;
        this.Shooter = Shooter;

        addRequirements(Shooter);
        }

    @Override
    public void execute() {
        if (shoot) {
            Shooter.rotationDirection();
            Shooter.shoot(shootingSpeed);
        } else if (adjustAngleUp) {
            Shooter.adjustAngleUp();
        } else if (adjustAngleDown) {
            Shooter.adjustAngleDown();
        } else if (shoot == false){
            Shooter.stopShooting();
            Shooter.shoot(0);
        }
    }
}