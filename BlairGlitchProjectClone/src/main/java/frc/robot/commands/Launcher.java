package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.LauncherSub;

public class Launcher extends CommandBase {
  /** Creates a new Launcher. */
  private LauncherSub launcherSub;
  public Launcher(LauncherSub launcherSub) {
    this.launcherSub = launcherSub;
    addRequirements(this.launcherSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  /* This is the code that starts the launcher at a set speed */

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    launcherSub.runLauncher();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    launcherSub.stopLauncher();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //this is a button press
    return RobotContainer.stopLauncherValue();
  }
}
