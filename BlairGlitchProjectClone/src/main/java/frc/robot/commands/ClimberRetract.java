package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSub;

public class ClimberRetract extends CommandBase {
  /** Creates a new ClimberRetract. */
  private ClimbSub climbSub;
  public ClimberRetract(ClimbSub climbSub) {
    this.climbSub = climbSub;
    addRequirements(this.climbSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  /*this code deploys the climber */

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    climbSub.out();
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
