package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;

public class ClimbCommand extends CommandBase {
    boolean extend;
    boolean retract;
    ClimbSubsystem Climb;
    public char latestAction = 'r';

    public ClimbCommand(boolean extend, boolean retract, ClimbSubsystem Climb) {
        this.extend = extend;
        this.retract = retract;
        this.Climb = Climb;

        addRequirements(Climb);
    }

    @Override
    public void execute() {
        if (extend) {
            Climb.extendClimber();
            latestAction = 'e';
        } if (retract) {
            Climb.retractClimber();
            latestAction = 'r';
        } else if (extend == false && retract == false) {
            Climb.stopMotor();
        }
    }
}
