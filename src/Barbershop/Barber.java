package Barbershop;

public class Barber extends Thread {
	private Chair chair;

	public Barber(Chair chair) {
		this.chair = chair;
	}

	/**
	 * Starts the thread and waits between 3 and 6 seconds between each call to
	 * chair.cuttingHair()
	 */
	@Override
	public void run() {
		while (true) {
			try {
				int waiting = Util.generateInt(3000) + 3000;
				sleep(waiting);
				chair.cuttingHair();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
