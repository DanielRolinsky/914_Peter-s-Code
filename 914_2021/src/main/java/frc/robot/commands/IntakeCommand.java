package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {
    boolean spinIn;
    boolean Drop;
    boolean Pull;
    private final IntakeSubsystem intake;

    public IntakeCommand(boolean spinIn, boolean Drop, boolean Pull, IntakeSubsystem intake) {
        this.spinIn = spinIn;
        this.Drop = Drop;
        this.Pull = Pull;
        this.intake = intake;

        addRequirements(intake);
    }

    @Override
    public void execute() {
        if(this.spinIn) {
            intake.intake(0.5);
        } else if (this.spinIn == false) {
            intake.intake(0);
        } else if (this.Drop) {
            intake.dropIntake();
        } else if (this.Pull) {
            intake.pullIntake();
        }
    }
}
