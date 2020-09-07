package com.hrm.orange.generic;

public class Utilities
{
	public static void sleepInSeconds(long seconds)
	{
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
