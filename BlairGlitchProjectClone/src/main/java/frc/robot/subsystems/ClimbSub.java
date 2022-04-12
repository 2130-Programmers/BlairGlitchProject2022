package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ClimbSub extends SubsystemBase {

  private DoubleSolenoid climbSol;
  public TalonFX climbMaster;
  public VictorSPX climbSlave;

  /** Creates a new ClimbSub. */
  public ClimbSub() {
    climbMaster = new TalonFX(4);
    climbSlave = new VictorSPX(6);

    climbSlave.follow(climbMaster);

    climbSol = new DoubleSolenoid(PneumaticsModuleType.REVPH, 1, 6);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  /**extends and retracts the skyhooks */
  public void skyHookExtend() {
    climbMaster.set(ControlMode.PercentOutput, RobotContainer.driverJoy.getRawAxis(Constants.LeftAxisTrigger) - RobotContainer.driverJoy.getRawAxis(Constants.RightAxisTrigger));
  }

  /**pushes the climbers out */
  public void out(){
    climbSol.set(Value.kForward);
  }

  /**pulls the climbers back in */
  public void in(){
    climbSol.set(Value.kReverse);
  }
}
