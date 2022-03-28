package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Finger;

public class AutoFingerCom extends CommandBase {
  /** Creates a new AutoFingerCom. */
  private Finger finger;
  public AutoFingerCom(Finger finger) {
    this.finger = finger;
    addRequirements(finger);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  /*this code runs automatic finger adjustment  */

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    finger.autoFinger();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    finger.fingerStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return RobotContainer.operatorJoy.getRawButton(Constants.ButtonLB);
  }
}
