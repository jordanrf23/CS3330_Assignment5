package model;

public class Cat extends Pet{

	/*
	 * uses the same outline from Pet but updates it to have the breed slot for cats
	 */
	public Cat(int id, String name, String type, String species, int age, boolean adopted) {
		super(id, name, "Cat", species, age, adopted);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
