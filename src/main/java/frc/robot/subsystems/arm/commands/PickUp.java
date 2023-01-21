package frc.robot.subsystems.arm.commands;

import java.time.chrono.ThaiBuddhistChronology;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import frc.robot.Constants;

// TODO: THINK ABOUT THE BUTTONS ASK DANIEL
public class PickUp extends CommandBase{
    private Arm arm;
    private LiftHeight desiredHeight;

    enum LiftHeight {
        FLOOR,
        SHELF
    }

    public PickUp(LiftHeight desiredHeight, Arm arm) {
        this.arm = arm;
        this.desiredHeight = desiredHeight;
        addRequirements(this.arm);
    }

    @Override
    public void initialize(){
        // Check to make sure arm is in good position else reset arm to contracted position
    }

    @Override
    public void execute(){
        double desiredY = Constants.Arm.Positions.kLowY;
        double desiredZ = Constants.Arm.Positions.kLowZ;

        switch(this.desiredHeight) {
            case FLOOR:
            break;
            case SHELF:
            desiredY = Constants.Arm.Positions.kIntakeShelfY;
            desiredZ= Constants.Arm.Positions.kIntakeShelfZ;
            break;
        }
        // set y and z of to target via presets 

        //Calcuate desired angles 
        double[] desiredAngles = arm.calculateAngles(Constants.Arm.Positions.kLowY, Constants.Arm.Positions.kLowZ)
        //Set power to motors until encoders get to the right values

        //Move to desired angles
        MoveToAngle movePlease = new MoveToAngle(desiredAngles[0], desiredAngles[1]);
        //Grab

        
    }

    @Override
    public void end(){
        
    }

    @Override
    public boolean isFinished(){
        //TO DO ASK GRABBER GROUP TO MAKE A ISGRABBED VAR
    }
}