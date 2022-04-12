package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;

public class Taxi extends SequentialCommandGroup {
  /** Creates a new TaxiOneBall. */
  public Taxi() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new AutonTowardsBall(RobotContainer.driveTrain),
      new AutonDrive(RobotContainer.driveTrain, 0, 0, 0, 5),
      new AutoStopBooleanChange()
    );
  }
}
