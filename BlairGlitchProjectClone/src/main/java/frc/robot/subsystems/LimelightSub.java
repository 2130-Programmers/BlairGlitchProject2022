package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimelightSub extends SubsystemBase {
  /** Creates a new LimelightSub. */
  private NetworkTable limelightTable;
  public NetworkTableEntry tx;
  private NetworkTableEntry ty;
  private NetworkTableEntry ta;
  private NetworkTableEntry tvert;
  private NetworkTableEntry thor;
  private NetworkTableEntry ts;
  private NetworkTableEntry pipe;
  private NetworkTableEntry tv;

  public boolean pipebool = true;

  public static double x;
  public double y;
  public double area;
  public double linearEncoderValue;
  public double h;
  public double v;
  public double offset;
  public double xOffset = 0;
  public double pipeValue = 0;
  public static double valid;
  public double zoom = 1;

  private static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  // Limelight values work by having an array of variables each assigned a name,
  // what we call a network table
  // To access this you need to get the entry of whatever the variable has been
  // named, examples below
  public LimelightSub() {
    limelightTable = NetworkTableInstance.getDefault().getTable("limelight");

    tx = limelightTable.getEntry("tx");
    ty = limelightTable.getEntry("ty");
    ta = limelightTable.getEntry("ta");
    tvert = limelightTable.getEntry("tvert");
    thor = limelightTable.getEntry("thor");
    ts = limelightTable.getEntry("ts");
    pipe = table.getEntry("getpipe");

    tv = limelightTable.getEntry("tv");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // sets our variables to the network tables
    x = tx.getDouble(0);
    y = ty.getDouble(0);
    area = ta.getDouble(0);
    h = tvert.getDouble(0);
    v = thor.getDouble(0);
    offset = ts.getDouble(0);
    pipeValue = pipe.getDouble(0);
    valid = tv.getDouble(0);
  }

  // ----------------I collapsed these methods because they are simple and easy to understand-------------------
  // to expand press the arrow by the line number
  /**changes the camera to a normal vision mode*/
  public void cameraMode() {
    NetworkTableEntry pipelineEntry = table.getEntry("pipeline");
    pipelineEntry.setNumber(0);
    zoom = 1;
  }

  /**changes the camera to a non zoomed targeting */
  public void targetMode() {
    NetworkTableEntry pipelineEntry = table.getEntry("pipeline");
    pipelineEntry.setNumber(1);
    zoom = 1;
  }

  /**changes the camera to a 2x zoomed targeting */
  public void targetZoomMode() {
    NetworkTableEntry pipelineEntry = table.getEntry("pipeline");
    pipelineEntry.setNumber(2);
    zoom = 2;
  }

  /** function to switch between zoomed and not zoomed even while in camera mode */
  public void targetSwitch() {
    int switchNum = (int) pipeValue;
    switch (switchNum) {
      case 1:
        targetZoomMode();
        break;
      case 2:
        targetMode();
        break;
      default:
        targetMode();
    }
  }
}
