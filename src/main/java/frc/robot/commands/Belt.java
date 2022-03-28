package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSub;

public class Belt extends CommandBase {
  /** Creates a new Belt. */
  private IntakeSub intakeSub;
  public Belt(IntakeSub intakeSub) {
    this.intakeSub = intakeSub;
    addRequirements(this.intakeSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  /*this code runs the internal intake  */

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeSub.moveBalls();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSub.stopInternals();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
