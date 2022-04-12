package frc.robot.subsystems;

import org.photonvision.PhotonCamera;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PhotonSub extends SubsystemBase {
  /** Creates a new PhotonSub. */
  // you need to know the name of the camera, you can find this from the internet
  // at http://photonvision.local:5800/#/dashboard while
  // connected to the robot
  public PhotonCamera camera = new PhotonCamera("Microsoft_LifeCam_HD-3000");

  // the values I want
  public boolean hasTarget = false;
  public static double yaw = 0;
  public static double area = 0;

  public PhotonSub() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // I want to check to make sure it has a target before I read it, this makes
    // sure nothing wonky happens
    var results = camera.getLatestResult();
    if (results.hasTargets()) {
      area = results.getBestTarget().getArea();
      hasTarget = true;
    } else {
      hasTarget = false;
    }

    RunCamera();
  }

  // ----------------I collapsed these methods because they are simple and easy to understand-------------------
  // to expand press the arrow by the line number
  /**sets the cameraMode to driver */
  public void driveMode() {
    camera.setDriverMode(true);
  }

  /**sets the cameraMode to targeting */
  public void cameraMode() {
    camera.setDriverMode(false);
  }

  /**sets the targeting to look for blue balls */
  public void BlueBalls() {
    camera.setPipelineIndex(0);
  }

  /**sets the targeting to look for red balls */
  public void RedBalls() {
    camera.setPipelineIndex(1);
  }

  /**this gets the yaw value, it is called in periodic of photonSub to always get a value. */
  public void RunCamera() {
    double placeholder = 0;
    var results = camera.getLatestResult();

    if (results.hasTargets()) {
      placeholder = results.getBestTarget().getYaw();
    } else {
      placeholder = 0;
    }
    yaw = -placeholder;
  }
}
