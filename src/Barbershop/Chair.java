package Barbershop;

public class Chair {
	private Boolean isEmpty;
	private Double earnings = 0.0;
	private HairStyle specialOffer = null;
	private Double cost;

	public Chair() {
		specialOffer = new HairStyle();
		isEmpty = true;
	}

	/**
	 * The hipsters wait if isEmpty is false and the hipster prints a message
	 * indicating their id. If the chair is empty their hair is cut and the cost is
	 * calculated and finally isEmpty is set to true, the other threads are notified
	 * and the thread show the hairstyle he picked and the cost.
	 * 
	 * @param id
	 * @param hs
	 * @return
	 */
	public synchronized Boolean getHairCut(int id, HairStyle hs) {
		while (!isEmpty) {
			try {
				System.out.println("Hipster " + id + ": The barber is busy now, I've to wait");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (hs.equals(specialOffer)) {
			earnings += (hs.getHairPrice() * 0.85);
			cost = hs.getHairPrice() * 0.85;
		} else {
			earnings += hs.getHairPrice();
			cost = hs.getHairPrice();
		}

		isEmpty = true;
		notifyAll();

		System.out.println("Hipster " + id + ": I just had my " 
		+ hs.getHairStyle() + " for " + cost + "€");

		return true;
	}

	/**
	 * If isEmpty is true the barber waits. When Barber is notified sets isEmpty to
	 * false and notifies the rest of the threads.
	 */
	public synchronized void cuttingHair() {
		if (isEmpty)
			System.out.println("Barber: Waiting for next customer");

		while (isEmpty) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		isEmpty = false;
		notifyAll();
	}

	/**
	 * @return Double earnings
	 */
	public Double getEarnings() {
		return earnings;
	}

	/**
	 * @return HairStyle specialOffer
	 */
	public HairStyle getSpecialOffer() {
		return specialOffer;
	}

}
