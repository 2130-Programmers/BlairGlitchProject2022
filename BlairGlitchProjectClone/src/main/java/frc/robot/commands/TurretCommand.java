package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretSub;

public class TurretCommand extends CommandBase {
  private TurretSub turretSub;
  /** Creates a new turretCommand. */
  public TurretCommand(TurretSub turretSub) {
    this.turretSub = turretSub;
    addRequirements(this.turretSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

/* This code runs the method that turns the turret based off limelight*/

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
     turretSub.turretRotation();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    turretSub.turretStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
