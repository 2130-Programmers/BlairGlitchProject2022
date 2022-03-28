package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Finger;

public class FingerDownCom extends CommandBase {
  /** Creates a new FingerDownCom. */
  private Finger finger;
  public FingerDownCom(Finger finger) {
    this.finger = finger;
    addRequirements(this.finger);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  /*This code runs the fingers down manually */

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    finger.fingerDown();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    finger.fingerStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !RobotContainer.fingerDown.get();
  }
}
