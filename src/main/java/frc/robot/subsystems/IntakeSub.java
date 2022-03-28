package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class IntakeSub extends SubsystemBase {
  /** Creates a new IntakeSub. */

  private TalonSRX beltMotor;

  private DoubleSolenoid extendSol;

  public DigitalInput limitSwitch;

  public boolean isExtended = false;
  public boolean toggleBool = false;

  public IntakeSub() {
    beltMotor = new TalonSRX(2);

    extendSol = new DoubleSolenoid(PneumaticsModuleType.REVPH, 0, 7);

    limitSwitch = new DigitalInput(9);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // ----------------I collapsed these methods because they are simple and easy to understand-------------------
  // to expand press the arrow by the line number
  /**brings the intake in and sets isExtended to false*/
  public void retractIntake() {
    extendSol.set(Value.kForward);
    isExtended = false;
  }

  /**extends the intake and sets isExtended to True */
  public void extendIntake() {
    extendSol.set(Value.kReverse);
    isExtended = true;
  }

  /**stops the internal intake from running */
  public void stopInternals() {
    beltMotor.set(ControlMode.PercentOutput, 0);
  }

  /**This is the function that moves balls through the robot, it runs until it hits the limit switch where it waits
   * for the operator to confirm the shot
   */
  public void moveBalls() {
    if (isExtended) {
      if (!limitSwitch.get() && RobotContainer.operatorJoy.getRawAxis(Constants.RightAxisTrigger) < .9) {
        beltMotor.set(ControlMode.PercentOutput, 0);
      } else {
        beltMotor.set(ControlMode.PercentOutput, -1);
      }
    } else {
      beltMotor.set(ControlMode.PercentOutput, 0);
    }
  }

  /**The command to run during auton, it replaces the operator confirm with a function that checks if the robot is moving and
   * if the limelight is in range
   */
  public void autoBelt() {
    if (isExtended) {
      if (!limitSwitch.get() && !RobotContainer.turretSub.readyToFire()) {
        beltMotor.set(ControlMode.PercentOutput, 0);
      } else {
        beltMotor.set(ControlMode.PercentOutput, -1);
      }
    } else {
      beltMotor.set(ControlMode.PercentOutput, 0);
    }
  }
}
