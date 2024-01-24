package com.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Javautils {
/**
 * this methos returns random number
 * @return
 */
	public int getRandomNo() {
		Random ran = new Random();
		int random = ran.nextInt(100);
		return random;
	}
/**
 * This methos is used to get system date
 * @return
 */
public String getSystemDate()
{
	Date dt = new Date(); 
	String date = dt.toString();
	return date;
	}
/**
 * This methos is used to get System date In Format
 * @return
 */
public String getSystemdateInFormat()
{
SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH-mm-ss");
Date dt = new Date();
String SystemDateInFormat = dateformat.format(dt);
return SystemDateInFormat;
}
}


















