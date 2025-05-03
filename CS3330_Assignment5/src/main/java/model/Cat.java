package model;

public class Cat extends Pet{

	/*
	 * uses the same outline from Pet but updates it to have the breed slot for cats
	 */
	public Cat(int id, String name, int age, boolean adopted, String species) {
		super(id, name, "Cat", species, age, adopted);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
