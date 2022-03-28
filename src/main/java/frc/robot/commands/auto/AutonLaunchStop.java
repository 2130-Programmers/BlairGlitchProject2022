package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.LauncherSub;

public class AutonLaunchStop extends InstantCommand {
  private LauncherSub launcherSub;
  public AutonLaunchStop(LauncherSub launcherSub) {
    this.launcherSub = launcherSub;
    addRequirements(launcherSub);
  }

  @Override
  public void initialize() {
    launcherSub.stopLauncher();
  }
}
