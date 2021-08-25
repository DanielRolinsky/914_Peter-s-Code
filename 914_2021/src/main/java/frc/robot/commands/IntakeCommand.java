package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {
    boolean spinIn;
    private final IntakeSubsystem intake;

    public IntakeCommand(boolean spinIn, IntakeSubsystem intake) {
        this.spinIn = spinIn;
        this.intake = intake;

        addRequirements(intake);
    }
    public void execute() {
        if(this.spinIn) {
            intake.intake(1);
        } else {
            intake.intake(0);
        }
    }
}
