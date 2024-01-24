package testNgPrograms;

import java.util.Random;

public class randmnumber {
	public static void main(String[] args) throws Throwable {	
		Random rnd= new Random();
		int random=rnd.nextInt(10);
		System.out.println(random);
}
}
