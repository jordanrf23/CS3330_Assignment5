package model;

public class Dog extends Pet{

	/*
	 * uses the same outline from Pet but updates it to have the breed slot for dogs
	 */
	public Dog(int id, String name, String type, String species, int age, boolean adopted) {
		super(id, name, "Dog", species, age, adopted);
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
