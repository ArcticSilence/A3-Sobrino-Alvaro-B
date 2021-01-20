package Barbershop;

import java.util.ArrayList;

public class Main {
	static final int HIPSTERQUANTITY = 5;

	public static void main(String[] args) {
		Chair chair = new Chair();
		Barber barber = new Barber(chair);
		ArrayList<Hipster> hipstersList = new ArrayList<>();

		// Threads started
		barber.start();
		for (int i = 0; i < HIPSTERQUANTITY; i++) {
			hipstersList.add(new Hipster(i, chair));
			hipstersList.get(i).start();
		}

		// Joined the Hipster's threads
		try {
			for (Hipster h : hipstersList) {
				h.join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Show earnings and today's special
		System.out.println("The barbershop has earned: " + chair.getEarnings() + "€");
		System.out.println("The today's special offer was: " + chair.getSpecialOffer().getHairStyle() + " for "
				+ (chair.getSpecialOffer().getHairPrice() * 0.85)+"€");
		System.exit(0);
	}
}
