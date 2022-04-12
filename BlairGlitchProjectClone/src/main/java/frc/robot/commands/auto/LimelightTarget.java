package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.LimelightSub;

public class LimelightTarget extends InstantCommand {
  private LimelightSub limelightSub;
  public LimelightTarget(LimelightSub limelightSub) {
    this.limelightSub = limelightSub;
    addRequirements(limelightSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    limelightSub.targetMode();
  }
}
