package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSub;

public class RetractIntake extends CommandBase {
  /** Creates a new RetractIntake. */
  private IntakeSub intakeSub;
  public RetractIntake(IntakeSub intakeSub) {
    this.intakeSub = intakeSub;
    addRequirements(intakeSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

/* This command pulls the intake back in */

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intakeSub.retractIntake();
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
