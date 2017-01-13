package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.Victor;

public class Drive {

	private Victor left;
	private Victor right;
	
	/**
    This function configures ports for Victors
    @since 1948 Hakamat Medini
    @param MOTOR_RIGHT port for right Victor
    @param MOTOR_LEFT port for left Victor
    @throws port may not be the right port/engines are opposite
    Author: Gil Meri and Omer Yakobi
    */
	public Drive(int MOTOR_RIGHT, int MOTOR_LEFT)
	{
		
		left = new Victor(MOTOR_LEFT);
		right = new Victor(MOTOR_RIGHT);
		
	}
	
	/**
    Drive the robot EZEZEZ
    @since 1948 Hakamat Medini
    @param y value of the y axis in joystick
    @param x value of the x axis in joystick
    @param z value of the z axis in joystick
    @throws None
    Author: Gil Meri and Omer Yakobi
    */
	public void Moving (double y, double z, double slider)
	{
		slider = ((-slider) / 2 + 0.5)/1.75;
		
		double powerLeft = (y-z) * slider;
		double powerRight = (y+z) * slider;
		
		if (powerLeft > 1)powerLeft=1;
		if (powerLeft < -1)powerLeft=-1;
		if (powerRight > 1)powerRight=1;
		if (powerRight < -1)powerRight=-1;
		
		this.left.set(-powerLeft);
		this.right.set(powerRight);
		
	}
}
