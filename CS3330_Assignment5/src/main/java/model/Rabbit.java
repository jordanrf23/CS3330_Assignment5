package model;

public class Rabbit extends Pet{
	
	private String breed;

	/*
	 * uses the same outline from Pet but updates it to have the breed slot for Rabbits
	 */
	public Rabbit(int id, String name, int age, boolean adopted, String breed) {
		super(id, name, "Rabbit", breed, age, adopted);
		// TODO Auto-generated constructor stub
		this.breed = breed;
	}
	
	/*
	 * obtains the breed
	 */
	public String getBreed() {
		return breed;
	}
	
	/*
	 * assigns the breed
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(", Breed: %s", breed);
	}

}
