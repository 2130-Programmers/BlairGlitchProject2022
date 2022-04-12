package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class DriveCommand extends CommandBase {
  /** Creates a new DriveCommand. */
  private DriveTrain driveTrain;

  public DriveCommand(DriveTrain driveTrain) {
    this.driveTrain = driveTrain;
    addRequirements(this.driveTrain);
  }

  /*This code makes our swervedrives run */

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //in previous versions axis 1 and 5 are always inverted
    driveTrain.moveSwerveAxis(-RobotContainer.driverJoy.getRawAxis(0), 
                -RobotContainer.driverJoy.getRawAxis(1), 
                RobotContainer.driverJoy.getRawAxis(4));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //always set values to zero in end
    driveTrain.moveSwerveAxis(0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
