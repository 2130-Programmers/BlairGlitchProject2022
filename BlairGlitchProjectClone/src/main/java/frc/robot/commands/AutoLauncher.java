package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.LauncherSub;

public class AutoLauncher extends CommandBase {
  /** Creates a new AutoLauncher. */
  private LauncherSub launcherSub;
  public AutoLauncher(LauncherSub launcherSub) {
    this.launcherSub = launcherSub;
    addRequirements(this.launcherSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  /*this code runs the automatic launcher wheel speed adjustment */

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
  public void end(boolean interrupted) {
    launcherSub.stopLauncher();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return RobotContainer.operatorJoy.getRawButton(Constants.ButtonLB);
  }
}
