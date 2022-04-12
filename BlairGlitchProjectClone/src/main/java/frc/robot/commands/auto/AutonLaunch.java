package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.LauncherSub;

public class AutonLaunch extends InstantCommand {
  private LauncherSub launcherSub;
  public AutonLaunch(LauncherSub launcherSub) {
    this.launcherSub = launcherSub;
    addRequirements(launcherSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    launcherSub.runLauncher();
  }
}
