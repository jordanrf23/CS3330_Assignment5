package model;

public class Dog extends Pet{

	/*
	 * uses the same outline from Pet but updates it to have the breed slot for dogs
	 */
	public Dog(int id, String name, int age, boolean adopted, String species) {
		super(id, name, "Dog", species, age, adopted);
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	
}
