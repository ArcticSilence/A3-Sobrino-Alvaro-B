package Barbershop;

public class HairStyle {
	private String[] hairStyles = { "GenericHipster", "Hipstache", "Beardstache", "Bald as hell",
			"Raccoon over your head", "Woodchopper", "American Trucker" };
	private Double[] hairStylePrices = { 5.0, 7.5, 10.0, 15.0, 17.5, 20.0, 25.0 };
	private String hairStyle = null;
	private Double hairPrice;

	/**
	 * sel is a randomly generated int and it's used to select the hairStyle and the
	 * hairPrice
	 */
	public HairStyle() {
		int sel = Util.generateInt(hairStyles.length);
		hairStyle = hairStyles[sel];
		hairPrice = hairStylePrices[sel];
	}

	/**
	 * @return String hairStyle
	 */
	public String getHairStyle() {
		return hairStyle;
	}

	/**
	 * Sets @param to hairStyle
	 * 
	 * @param hairStyle
	 */
	public void setHairStyle(String hairStyle) {
		this.hairStyle = hairStyle;
	}

	/**
	 * @return Double hairPrice
	 */
	public Double getHairPrice() {
		return hairPrice;
	}

	/**
	 * Sets @param to hairPrice
	 * 
	 * @param hairPrice
	 */
	public void setHairPrice(Double hairPrice) {
		this.hairPrice = hairPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hairStyle == null) ? 0 : hairStyle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HairStyle other = (HairStyle) obj;
		if (hairStyle == null) {
			if (other.hairStyle != null)
				return false;
		} else if (!hairStyle.equals(other.hairStyle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HairStyle [hairStyle=" + hairStyle + ", hairPrice=" + hairPrice + "]";
	}

}
