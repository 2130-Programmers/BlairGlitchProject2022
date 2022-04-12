package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class IntakeRollerSub extends SubsystemBase {
  private TalonFX intakeMotor;

  /** Creates a new intakeRollerSub. */
  public IntakeRollerSub() {
    intakeMotor = new TalonFX(3);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  // ----------------I collapsed these methods because they are simple and easy to understand-------------------
  // to expand press the arrow by the line number
  /**Runs the intake at half speed */
  public void intakeSpin() {
    intakeMotor.set(ControlMode.PercentOutput, .5);
  }

  /**Stops the intake */
  public void stopRollers() {
    intakeMotor.set(ControlMode.PercentOutput, 0);
  }

  /** uses the driver b button to reverse the direction of the intake */
  public int bIsTrue() {
    if (RobotContainer.intakeRevButValue()) {
      return -1;
    } else {
      return 1;
    }
  }

  /**runs the intake with the functionality of reversing the direction */
  public void ReverseIntake() {
    if (RobotContainer.intakeSub.isExtended) {
      intakeMotor.set(ControlMode.PercentOutput, .5 * bIsTrue());
    } else {
      intakeMotor.set(ControlMode.PercentOutput, 0);
    }
  }
}
