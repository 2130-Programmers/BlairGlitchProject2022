package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;

public class TaxiFiveBalls extends SequentialCommandGroup {
  
  public TaxiFiveBalls() {
    addCommands(
       new AutonTowardsBall(RobotContainer.driveTrain),
       new AutonPause(RobotContainer.driveTrain, 3),
       new AutonTurnCom(RobotContainer.driveTrain, 3),
       new AutonTowardsBall(RobotContainer.driveTrain),
       new AutonPause(RobotContainer.driveTrain, 3),
       new AutonTurnCom(RobotContainer.driveTrain, 1),
       new AutonTowardsBall(RobotContainer.driveTrain),
       new AutonPause(RobotContainer.driveTrain, 3),
       new AutoStopBooleanChange()
      );
  }
}
