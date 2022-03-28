package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

public class TurretSub extends SubsystemBase {

  private TalonSRX turret;
  public TalonFX turretEncoder;

  public DigitalInput turretProx;

  public boolean directionBool = true;
  public boolean auto = true;

  public double limelightTX = 0;
  public double limelightTA = 0;


  /** Creates a new turretSub. */
  public TurretSub() {
    turret = new TalonSRX(10);
    turretEncoder = new TalonFX(3);
    turretProx = new DigitalInput(8);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    readyToFire();
  }

  /**stops the turret */
  public void turretStop(){
    turret.set(ControlMode.PercentOutput, 0);
  }
  
  /**initial value when finding the prox*/
  public void initailTurretZero() {
    turret.set(ControlMode.PercentOutput, -.6);
  }

  //this is the main function when using the turret in teleop
  /**this will follow the reflective target untill the operator overides with left trigger*/
  public void turretRotation() 
  { 
      if(RobotContainer.operatorJoy.getRawAxis(2)<.9)
      {
        if(LimelightSub.valid > 0) 
        {
          auto = true;
          //set susan is a method made by us to make sure it doesn't go beyond bounds
          setSusan(LimelightSub.x * -.05);
          }else{
          //always make sure when it stops reading to set the value to zero
          setSusan(0);
        }
      }else{
        //manual override
        auto = false;
        setSusan(-RobotContainer.operatorJoy.getRawAxis(4));
        }
  }

  /**this is the version of the turret we use in auton */
  public void autoTurret(){
    if(LimelightSub.valid > 0) 
        {
          auto = true;
          setSusan(limelightTX*.2);
          turret.set(ControlMode.PercentOutput, LimelightSub.x * -.05);
        }
  }

  /**this is out custom .set for the turret, it makes sure that the turret doesn't go to far, the logic goes
   if the turret is at the limit and it is trying to go farther stop, check other side, and continue
   this is necessary because if we just stop it when it hits the value we wouldn't be able to bring it back 
   into range
   @param power (double) - what percent power to run from -1 to 1
   */
  public void setSusan(double power){
    if(turretEncoder.getSelectedSensorPosition() > 9500 && power > 0 || turretEncoder.getSelectedSensorPosition() < -3500 && power < 0){
      turret.set(ControlMode.PercentOutput, 0);
    }else{
      turret.set(ControlMode.PercentOutput, power);
    }
  }

  /**A function for auto that check to see if it's ready to fire */
  public boolean readyToFire(){
    if(Math.abs(LimelightSub.x) < 5 && RobotContainer.driveTrain.notMoving  && LimelightSub.valid > 0){
      return true;
    }else{
      return false;
    }
  }

  /**this zeros the encoder on the turret, it is called in RobotPeriodic in Robot */
  public void zeroTurretEncoder() {
      if(!turretProx.get()){
        turretEncoder.setSelectedSensorPosition(0);
      }
    }

}
