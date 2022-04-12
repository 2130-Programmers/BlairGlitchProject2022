package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSub;

public class ExtendIntake extends CommandBase {
  /** Creates a new ExtendIntake. */
  private IntakeSub intakeSub;
  public ExtendIntake(IntakeSub intakeSub) {
    this.intakeSub = intakeSub;
    addRequirements(this.intakeSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  /*this code extends the intake, it also begins intake motor while it does this as well */

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeSub.extendIntake();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
