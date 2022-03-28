package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretSub;

public class ZeroTurretInitCom extends CommandBase {
  /** Creates a new ZeroTurretInitCom. */
  private TurretSub turretSub;
  public ZeroTurretInitCom(TurretSub turretSub) {
    this.turretSub = turretSub;
    addRequirements(turretSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

/* this code is for setting the turret to zero, it is a relative encoder so it needs to be set every time, we get away
  with this becuase it starts the same way every time, we just turn it clockwise till it hit the prox */ 

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    turretSub.initailTurretZero();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    turretSub.turretStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !turretSub.turretProx.get();
  }
}
