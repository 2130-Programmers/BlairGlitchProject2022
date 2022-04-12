package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LauncherSub;

public class AutonAutoLauncher extends CommandBase {
  /** Creates a new AutonLauncher. */
  private LauncherSub launcherSub;
  public AutonAutoLauncher(LauncherSub launcherSub) {
    this.launcherSub = launcherSub;
    addRequirements(launcherSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    launcherSub.autoLaunch();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
