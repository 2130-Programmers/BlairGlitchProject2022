package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LimelightSub;

public class LimelightDefault extends CommandBase {
  /** Creates a new LimelightDefault. */
  private LimelightSub limelightSub;
  public LimelightDefault(LimelightSub limelightSub) {
    this.limelightSub = limelightSub;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  /* this code sets the limelight into manual aim mode */

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    limelightSub.cameraMode();
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
