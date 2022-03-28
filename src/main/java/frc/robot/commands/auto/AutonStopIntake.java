package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.IntakeRollerSub;

public class AutonStopIntake extends InstantCommand {
  private IntakeRollerSub intakeRollerSub;
  public AutonStopIntake(IntakeRollerSub intakeRollerSub) {
    this.intakeRollerSub = intakeRollerSub;
    addRequirements(intakeRollerSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeRollerSub.stopRollers();
  }
}
