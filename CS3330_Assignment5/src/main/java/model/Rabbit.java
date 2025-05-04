package model;

public class Rabbit extends Pet{
	

	/*
	 * uses the same outline from Pet but updates it to have the breed slot for Rabbits
	 */
	public Rabbit(int id, String name, String type, String species, int age, boolean adopted) {
		super(id, name, "Rabbit", species, age, adopted);
	}
	

	@Override
	public String toString() {
		return super.toString();
	}

}
