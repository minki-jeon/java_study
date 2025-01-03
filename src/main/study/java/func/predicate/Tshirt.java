package main.study.java.func.predicate;

//import lombok.Getter;
//import lombok.ToString;

//@Getter
//@ToString
public class Tshirt {

	//* https://github.com/haru-note/tech-interview/blob/main/src/main/java/net/harunote/java8/functional/predicate/Tshirt.java
	private int price;
	private String color;
	
	public Tshirt(int price, String color) {
		this.price = price;
		this.color = color;
	}
	
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
//		return "Tshirt [price=" + price + ", color=" + color + ", toString()=" + super.toString() + "]";

		return "Tshirt [price=" + price + ", color=" + color + "]";
	}

}
