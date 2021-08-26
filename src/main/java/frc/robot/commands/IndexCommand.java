package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.IndexSubsystem;

public class IndexCommand extends CommandBase {
    boolean Up;
    boolean Down;
    IndexSubsystem Index;

    public IndexCommand(boolean Up, boolean Down, IndexSubsystem Index) {
        this.Up = Up;
        this.Down = Down;
        this.Index = Index;

        addRequirements((Subsystem) Index);
    }

    @Override
    public void execute() {
        if (Up) {
            Index.index(1);
        } if (Down) {
            Index.index(-1);
        } if (Up && Down) {
            // Display error on the driver station
        } else {
            Index.index(0);
        }
    }
}
