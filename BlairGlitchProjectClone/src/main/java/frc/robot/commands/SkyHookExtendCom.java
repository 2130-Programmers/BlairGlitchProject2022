package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSub;

public class SkyHookExtendCom extends CommandBase {
  /** Creates a new SkyHookExtendCom. */
  private ClimbSub climbSub;
  public SkyHookExtendCom(ClimbSub climbSub) {
    this.climbSub = climbSub;
    addRequirements(climbSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

/* This code runs the skyhooks up or down */

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    climbSub.skyHookExtend();
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
