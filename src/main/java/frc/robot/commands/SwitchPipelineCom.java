package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LimelightSub;

public class SwitchPipelineCom extends CommandBase {
  /** Creates a new SwitchPipelineCom. */
  private LimelightSub limelightSub;
  public SwitchPipelineCom(LimelightSub limelightSub) {
    this.limelightSub = limelightSub;
    addRequirements(this.limelightSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

/* this code switches between the zoomed and non zoomed pipelines */

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    limelightSub.targetSwitch();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
