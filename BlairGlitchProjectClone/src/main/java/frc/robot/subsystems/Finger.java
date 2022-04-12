package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class Finger extends SubsystemBase {
  /** Creates a new Finger. */
  public TalonSRX fingerEncoder;
  public TalonSRX fingerMotor;

  public double encoderPos = 0;

  public double encoderTarget = 0;

  private double encoderMod = 0;

  public Finger() {
    fingerMotor = new TalonSRX(13);
    fingerEncoder = new TalonSRX(15);
  }

  @Override
  public void periodic() {
    // gets the encoder position of the finger height every cycle
    encoderPos = fingerEncoder.getSelectedSensorPosition();
    // This method will be called once per scheduler run
  }

  // ----------------I collapsed these methods because they are simple and easy to
  // understand-------------------
  // to expand press the arrow by the line number
  /** runs the finger up */
  public void fingerUp() {
    fingerMotor.set(ControlMode.PercentOutput, .575);
  }

  /** runs the fingers down */
  public void fingerDown() {
    fingerMotor.set(ControlMode.PercentOutput, -.3);
  }

  /** stops the fingers */
  public void fingerStop() {
    fingerMotor.set(ControlMode.PercentOutput, 0);
  }

  /** resets the encoder */
  public void resetEnc() {
    fingerEncoder.setSelectedSensorPosition(0);
  }

  /** Automatically aims the fingers based on the y value of the limelight */
  public void autoFinger() {
    // linear function for getting the value based on y
    encoderTarget = -346 * (RobotContainer.limelightSub.y) + 22600;

    // runs the fingers in the correct direction
    if (encoderPos > encoderTarget) {
      encoderMod = -.2;
    } else {
      encoderMod = .25;
    }

    // safety measures, similar to set susan from turretSub
    if (encoderPos > 19000 && encoderMod > 0 || encoderPos < 1000 && encoderMod < 0) {
      fingerMotor.set(ControlMode.PercentOutput, 0);
    } else {
      //checking to see if it has a target
      if (LimelightSub.valid > 0) {
        fingerMotor.set(ControlMode.PercentOutput, encoderMod);
      }
    }
  }

  public double fingerEncoderValue() {
    return fingerEncoder.getSelectedSensorPosition(0);
  }
}
