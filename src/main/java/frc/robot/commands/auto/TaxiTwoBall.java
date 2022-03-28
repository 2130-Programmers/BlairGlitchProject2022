package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;

public class TaxiTwoBall extends SequentialCommandGroup {
  /** Creates a new TaxiTwoBall. */
  public TaxiTwoBall() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new AutonTowardsBall(RobotContainer.driveTrain),
      new AutoStopBooleanChange ()
      );
  }
}
