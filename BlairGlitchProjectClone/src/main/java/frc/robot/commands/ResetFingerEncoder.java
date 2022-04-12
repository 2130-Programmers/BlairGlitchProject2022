package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Finger;

public class ResetFingerEncoder extends CommandBase {
  /** Creates a new ResetFingerEncoder. */
  private Finger finger;
  public ResetFingerEncoder(Finger finger) {
    this.finger = finger;
    addRequirements(finger);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  /* this code resets the finger encoder value */

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    finger.resetEnc();
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
