package model;

public abstract class Pet implements Comparable<Pet> {
	protected int id;
	protected String name;
	protected String type;
	protected String species;
	protected int age;
	protected boolean adopted;
	
	/*
	 * connects the attributes for Pet 
	 */
	public Pet(int id, String name, String type, String species, int age, boolean adopted) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.species = species;
		this.age = age;
		this.adopted = adopted;
	}

	/*
	 * obtains the Id
	 */
	public int getId() {
		return id;
	}

	/*
	 * assigns the Id
	 */
	public void setId(int id) {
		this.id = id;
	}



	/*
	 * obtains the name 
	 */
	public String getName() {
		return name;
	}



	/*
	 * assigns the animal's name
	 */
	public void setName(String name) {
		this.name = name;
	}



	/*
	 * obtains the category for the animal
	 */
	public String getType() {
		return type;
	}



	/*
	 * assigns the category for the animal
	 */
	public void setType(String type) {
		this.type = type;
	}



	/*
	 * obtains the sub species 
	 */
	public String getspecies() {
		return species;
	}



	/*
	 * assigns the sub species to the animal
	 */
	public void setSpecies(String species) {
		this.species = species;
	}



	/*
	 * obtains the age for the animal
	 */
	public int getAge() {
		return age;
	}



	/*
	 * assigns the age to the animal
	 */
	public void setAge(int age) {
		this.age = age;
	}

	
	/*
	 * returns the adoption method to alert the user of the pets status
	 */
	public boolean isAdopted() {
		return adopted;
	}


	/*
	 * assigns the adoption variable 
	 */
	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}
	
	/*
	 * allows for pet to have the adoption outlook and informs the user when already adopted
	 */
	public void adopt() {
		if(!adopted) {
			adopted = true;
		}else {
			throw new IllegalStateException("This pet has already been adopted!");
		}
	}

	/*
	 * comparing two pet ids 
	 */
	@Override
	public int compareTo(Pet o) {
		return this.name.compareToIgnoreCase(o.name);
	}

	/*
	 * outlines the animal that is on the website
	 */
	@Override
	public String toString() {
		return String.format("%s (ID: %d, Age: %d, Category: %s, SubSpecies: %s, Adopted: %b ", name, id, age, type, species, adopted );
	}
}