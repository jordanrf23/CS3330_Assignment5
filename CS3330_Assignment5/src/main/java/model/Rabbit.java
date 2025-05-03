package model;

public class Rabbit extends Pet{
	

	/*
	 * uses the same outline from Pet but updates it to have the breed slot for Rabbits
	 */
	public Rabbit(int id, String name, int age, boolean adopted, String species) {
		super(id, name, "Rabbit", species, age, adopted);
	}
	

	@Override
	public String toString() {
		return super.toString();
	}

}
