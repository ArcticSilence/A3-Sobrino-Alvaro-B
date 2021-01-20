package Barbershop;

public class Hipster extends Thread {
	private int id;
	private HairStyle hairStyle = null;
	private Boolean hairIsCut;
	Chair chair = null;

	public Hipster(int id, Chair chair) {
		this.id = id;
		hairIsCut = false;
		this.chair = chair;
	}

	/**
	 * Starts the Thread, wait between 5 and 20 seconds to generate the hairStyle
	 * that we'll be sent to the Chair and stops once chair.getHairCut() returns
	 * true
	 */
	@Override
	public void run() {
		int choose = Util.generateInt(15000) + 5000;

		try {
			sleep(choose);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		hairStyle = new HairStyle();

		while (!hairIsCut) {
			hairIsCut = chair.getHairCut(id, hairStyle);
		}
	}
}
