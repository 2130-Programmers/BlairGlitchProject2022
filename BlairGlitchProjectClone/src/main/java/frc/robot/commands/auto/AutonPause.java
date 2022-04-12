package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class AutonPause extends CommandBase {
  /** Creates a new AutonPause. */
  private DriveTrain driveTrain;
  private double time;
  private double timeAtStart = 0;

  public AutonPause(DriveTrain driveTrain, double time) {
    this.driveTrain = driveTrain;
    this.time = time;    
    addRequirements(this.driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timeAtStart = Robot.timer.get();}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.halt();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  //this gets the time we want to wait  and adds it to the time when initialized, then compares it to the updating game clock
  @Override
  public boolean isFinished() { 
    if(timeAtStart+time < Robot.timer.get()){
      return true;
    }else{
      return false;
    }
  }
}
