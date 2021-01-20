package Barbershop;

import java.util.Random;

public class Util {
	/**
	 * Generates a number between 0 and @param
	 * 
	 * @param max
	 * @return
	 */
	public static int generateInt(int max) {
		Random r = new Random();
		int res = r.nextInt(max);
		return res;
	}
}
