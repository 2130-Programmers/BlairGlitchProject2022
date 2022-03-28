package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.*;
import frc.robot.commands.auto.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;



public class RobotContainer {
  //we use this are to create and define code, I have sectioned it off to make it easier to follow.
  // -----------------------------------------------------------------------------\\
  //                                                                              \\
  //                                joysticks                                     \\
  //                                                                              \\
  // -----------------------------------------------------------------------------\\
  public static Joystick driverJoy = new Joystick(0);
  public static Joystick operatorJoy = new Joystick(1);

  // -----------------------------------------------------------------------------\\
  //                                                                              \\
  //                                Buttons                                       \\
  //                                                                              \\
  // -----------------------------------------------------------------------------\\
  public static JoystickButton extendBut = new JoystickButton(driverJoy, Constants.ButtonX);
  public static JoystickButton retractBut = new JoystickButton(driverJoy, Constants.ButtonY);
  public static JoystickButton runIntakeBut = new JoystickButton(driverJoy, Constants.ButtonA);
  public static JoystickButton runIntakeRevBut = new JoystickButton(driverJoy, Constants.ButtonB);
  public static JoystickButton deployArms = new JoystickButton(driverJoy, Constants.ButtonLB);
  public static JoystickButton retractArms = new JoystickButton(driverJoy, Constants.ButtonRB);

  public static JoystickButton startLauncher = new JoystickButton(operatorJoy, Constants.ButtonRB);
  public static JoystickButton stopLauncher = new JoystickButton(operatorJoy, Constants.ButtonLB);
  public static JoystickButton switchPipe = new JoystickButton(operatorJoy, Constants.ButtonStart);
  public static JoystickButton fingerUp = new JoystickButton(operatorJoy, Constants.ButtonA);
  public static JoystickButton fingerDown = new JoystickButton(operatorJoy, Constants.ButtonB);
  public static JoystickButton resetFingerEncoderButton = new JoystickButton(operatorJoy, Constants.ButtonX);
  public static JoystickButton limeCamer = new JoystickButton(operatorJoy, Constants.ButtonBack);

  //public static JoystickButton fire = new JoystickButton(operatorJoy, Constants.operatorButtonLB);

  // -----------------------------------------------------------------------------\\
  //                                                                              \\
  //                                subsystems                                    \\
  //                                                                              \\
  // -----------------------------------------------------------------------------\\
  public final static DriveTrain driveTrain = new DriveTrain();
  public final static LimelightSub limelightSub = new LimelightSub();
  public final static TurretSub turretSub = new TurretSub();
  public final static IntakeSub intakeSub = new IntakeSub();
  public final static IntakeRollerSub intakeRollerSub = new IntakeRollerSub();
  public final static ClimbSub climbSub = new ClimbSub();
  public final static PhotonSub photonSub = new PhotonSub();
  public final static LauncherSub launcherSub = new LauncherSub();
  public final static Finger finger = new Finger();

  
  // -----------------------------------------------------------------------------\\
  //                                                                              \\
  //                                commands                                      \\
  //                                                                              \\
  // -----------------------------------------------------------------------------\\
  public final static SwitchPipelineCom switchPipelineCom = new SwitchPipelineCom(limelightSub);
  public final DriveCommand driveCommand = new DriveCommand(driveTrain);
  public final TurretCommand turretCommand = new TurretCommand(turretSub);
  public final ExtendIntake extendIntake = new ExtendIntake(intakeSub);
  public final RetractIntake retractIntake = new RetractIntake(intakeSub);
  public final IntakeCom intakeCom = new IntakeCom(intakeRollerSub);
  public final ClimberDeploy climberDeploy = new ClimberDeploy(climbSub);
  public final ClimberRetract climberRetract = new ClimberRetract(climbSub);
  public final SkyHookExtendCom skyHookExtendCom = new SkyHookExtendCom(climbSub);
  public final Launcher launcher = new Launcher(launcherSub);
  public final Belt belt = new Belt(intakeSub);
  public final FingerDownCom fingerDownCom = new FingerDownCom(finger);
  public final FingerUpCom fingerUpCom = new FingerUpCom(finger);
  public final AutoFingerCom autoFingerCom = new AutoFingerCom(finger);
  public final ResetFingerEncoder resetFingerEncoder = new ResetFingerEncoder(finger);
  public final AutoLauncher autoLauncher = new AutoLauncher(launcherSub);
  public final LimelightDefault limelightDefault = new LimelightDefault(limelightSub);
  public final AutoStopBooleanChange autoStopBooleanChange =  new AutoStopBooleanChange();
  public final ZeroTurretInitCom zeroTurretInitCom = new ZeroTurretInitCom(turretSub);

  // -----------------------------------------------------------------------------\\
  //                                                                              \\
  //                                auto Commands                                 \\
  //                                                                              \\
  // -----------------------------------------------------------------------------\\
  public final SwitchToBlue switchToBlue = new SwitchToBlue(photonSub);
  public final SwitchToRed switchToRed = new SwitchToRed(photonSub);
  public final SwitchToDriver switchToDriver = new SwitchToDriver(photonSub);
  public final static AutonTurnCom autonTurnLeft = new AutonTurnCom(driveTrain, 1);
  public final static AutonTurnCom autonStop = new AutonTurnCom(driveTrain, 2);
  public final static AutonTurnCom autonTurnRight = new AutonTurnCom(driveTrain, 3);
  public final AutonIntake autonIntake = new AutonIntake(intakeRollerSub);
  public final AutonTowardsBall towardsBall = new AutonTowardsBall(driveTrain);
  public final Taxi taxiTwoBall = new Taxi();
  public final TaxiThreeBalls taxiThreeBalls = new TaxiThreeBalls();
  public final AutonDrive forwardOneSec = new AutonDrive(driveTrain, .5, 0, 0, 1);
  public final AutonPause halt = new AutonPause(driveTrain, 2);
  public final AutonLaunch autonLaunch = new AutonLaunch(launcherSub);
  public final AutonLaunchStop autonLaunchStop = new AutonLaunchStop(launcherSub);
  public final AutonBelt autonBelt = new AutonBelt(intakeSub);
  public final AutonTurret autonTurret = new AutonTurret(turretSub);
  public final AutonAutoLauncher autonAutoLauncher = new AutonAutoLauncher(launcherSub);
  public final AutonFinger autonFinger = new AutonFinger(finger);
  public final LimelightTarget limelightTarget = new LimelightTarget(limelightSub);
  
  // -----------------------------------------------------------------------------\\
  //                                                                              \\
  //                                    other                                     \\
  //                                                                              \\
  // -----------------------------------------------------------------------------\\
  static SendableChooser<Command> whichColor = new SendableChooser<>();
  static SendableChooser<Command> whichPath = new SendableChooser<>();

  public static boolean autoDone = false;


  //define default commands here and add options for sendable choosers
  public RobotContainer() {
    //runs the configure button binding method
    configureButtonBindings();

    driveTrain.setDefaultCommand(driveCommand);
    turretSub.setDefaultCommand(turretCommand);
    intakeRollerSub.setDefaultCommand(intakeCom);
    climbSub.setDefaultCommand(skyHookExtendCom);
    intakeSub.setDefaultCommand(belt);
    //finger.setDefaultCommand(autoFingerCom);
    //launcherSub.setDefaultCommand(autoLauncher);

    whichColor.setDefaultOption("blue", switchToBlue);
    whichColor.addOption("red", switchToRed);

    whichPath.setDefaultOption("Taxi two ball", taxiTwoBall);
    whichPath.addOption("Taxi three ball", taxiThreeBalls);
    whichPath.addOption("right", autonTurnRight);
  }

  // use this to configure button bindings.
  private void configureButtonBindings() {
    switchPipe.whenPressed(switchPipelineCom);
    extendBut.whenPressed(extendIntake);
    retractBut.whenPressed(retractIntake);
    deployArms.whenPressed(climberDeploy);
    retractArms.whenPressed(climberRetract);
    startLauncher.whenPressed(autoLauncher);
    fingerUp.whenPressed(fingerUpCom);
    fingerDown.whenPressed(fingerDownCom);
    limeCamer.whenPressed(limelightDefault);
    startLauncher.whenPressed(autoFingerCom);
    resetFingerEncoderButton.whenPressed(resetFingerEncoder);
    }

    //making a boolean method defined from runIntakeRevButton value
  public static boolean intakeRevButValue(){
    return runIntakeRevBut.get();
  }

    //making a boolean method defined from stopLauncher button value
  public static boolean stopLauncherValue(){
    return stopLauncher.get();
  }


  //use this to schedule autonomous code
  public Command getAutonomousCommand() {

    //everything seperated by commas in the parallel run at the same time
      //everything seperated by commas in the sequential run after the previous finishes
    return new ParallelCommandGroup(
      new SequentialCommandGroup(
        whichColor.getSelected(),
        halt,
        whichPath.getSelected(),
        autoStopBooleanChange
      ),
      new SequentialCommandGroup(
        extendIntake,
        autonIntake,
        autonBelt
      ),
      new SequentialCommandGroup(
        zeroTurretInitCom,
        limelightTarget,
        autonTurret
      ),
      autonAutoLauncher,
      autonFinger
    );
  }

}
