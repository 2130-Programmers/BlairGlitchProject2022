package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class LauncherSub extends SubsystemBase {
  /** Creates a new LauncherSub. */
  private CANSparkMax launcherMotor;
  public double launcherOutput = 0;

  public LauncherSub() {
    launcherMotor = new CANSparkMax(14, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /** sets launcher to a slow, static, base speed */
  public void runLauncher() {
    launcherMotor.set(.45);
  }

  /** stops the launcher speed */
  public void stopLauncher() {
    launcherMotor.set(0);
  }

  /** a linear graph that changes wheel speed based on distance. */
  public void autoLaunch() {
    launcherOutput = -.004 * (RobotContainer.limelightSub.y) + .49;

    if (LimelightSub.valid > 0 && RobotContainer.limelightSub.y > 0) {
      launcherMotor.set(launcherOutput);
    } else {
      launcherMotor.set(.45);
    }
  }
}
