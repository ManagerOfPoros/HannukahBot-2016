
package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends IterativeRobot {
	
	private Joystick kidJoy;
	private Joystick bigJoy;
	private Drive driving;
	private Shooter shooter;
	private boolean ignoreSwitch = false;
	private boolean dontWork = false;
    
	/**
    This function is called when the robot is powered on. It configures the objects.
    @since 1948 Hakamat Medini
    @throws ports may not be right
    Author: Gil Meri and Omer Yakobi
    */
    public void robotInit() 
    {    	
    	driving = new Drive(0, 1);
    	kidJoy = new Joystick(0);
    	bigJoy = new Joystick(1);
    	shooter = new Shooter(4,5,2,3);
    }
    
    /**
    This function works when the robot is enabled to communicate with the robot while in autonomus mode.
    @since 1948 Hakamat Medini
    @param None
    @return void that does nothing.
    @throws None
    Author: None
    */
    public void autonomousInit() {
    }

    /**
    This function works to communicate with the robot while in autonomus mode.
    @since 1948 Hakamat Medini
    @param None
    @return void that does nothing.
    @throws None
    Author: None
    */
    public void autonomousPeriodic() {
    }
    
    /**
    This function works to communicate with the robot while in teleop.
    @since 1948 Hakamat Medini
    @param None
    @return void that does nothing.
    @throws None
    Author: Gil Meri
    */
    public void teleopPeriodic()
    {
    	if(bigJoy.getRawButton(1) && ignoreSwitch == false)
    	{
    		ignoreSwitch = true;
    		
    		if(dontWork == false)
    		{
    			dontWork = true;
    		}
    		else
    		{
    			dontWork = false;
    		}
    	}
    	else if(!bigJoy.getRawButton(1))
    	{
    		ignoreSwitch = false;
    	}
    	
    	
    		
    	if(!dontWork)
    	{
    		driving.Moving(kidJoy.getRawAxis(1), kidJoy.getRawAxis(2), kidJoy.getRawAxis(3));
    	
    		shooter.shoot(kidJoy.getRawButton(1));
    	
    		if(kidJoy.getRawButton(11))
    		{
    			shooter.forward();
    		}
    		else if(kidJoy.getRawButton(9))
    		{
    			shooter.reverse();
    		}
    		else
    		{
    			shooter.stop();
    		}
    	
    	}
    	
    }
    
    /**
    This function works in test mode.
    @since 1948 Hakamat Medini
    @param None
    @return void that does nothing.
    @throws None
    Author: Gil Meri
    */
    public void testPeriodic() { 
    }
    
}
