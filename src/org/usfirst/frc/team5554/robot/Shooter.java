package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Victor;

public class Shooter {

	private DoubleSolenoid feeder;
	private Victor leftShooter;
	private Victor rightShooter;
	private double shootPower = 0.0;
	
	/**
    This function configures the objects of piston and shooting wheels.
    @since 1948 Hakamat Medini
    @param forwardChannel port of piston that's responsible for getting air inside the piston.
    @param reverseChannel port of piston that's responsible for getting air out of the piston.
    @param leftShooterPort port of the left wheel.
    @param rightShooterPort port of the right wheel.
    @throws port may not be the right port.
    Author: Gil Meri and Omer Yakobi
    */
	public Shooter(int forwardChannel , int reverseChannel, int leftShooterPort, int rightShooterPort)
	{
		feeder = new DoubleSolenoid(forwardChannel, reverseChannel);
		leftShooter = new Victor(leftShooterPort);
		rightShooter = new Victor(rightShooterPort);
	}
	
	/**
    This function activates the wheels for shooting.
    @since 1948 Hakamat Medini
    @param toShoot determines if the shooting is activated.
    @throws None
    Author: Gil Meri and Omer Yakobi
    */
	public void shoot(boolean toShoot)
	{
		if(toShoot)
		{
			if(shootPower < 0.6)
			{
				shootPower = shootPower+0.1;
			}
			
			leftShooter.set(-shootPower);
			rightShooter.set((shootPower));
		}
		else
		{
			shootPower = 0;
			leftShooter.set(shootPower);
			rightShooter.set(shootPower);
		}
	}
	
	/**
    This function is filling the piston with air
    @since 1948 Hakamat Medini
    @throws piston's not connected
    Author: Gil Meri and Omer Yakobi
    */
	public void forward( )
	{
		feeder.set(DoubleSolenoid.Value.kForward);
	}
	
	/**
    This function is sucking air from the piston
    @since 1948 Hakamat Medini
    @throws piston's not connected
    Author: Gil Meri and Omer Yakobi
    */
	public void reverse( )
	{
		feeder.set(DoubleSolenoid.Value.kReverse);	
	}
	
	/**
    This function stops the piston activity (not needed)
    @since 1948 Hakamat Medini
    @throws piston's not connected
    Author: Gil Meri and Omer Yakobi
    */
	public void stop()
	{
		feeder.set(DoubleSolenoid.Value.kOff);
	}
}
