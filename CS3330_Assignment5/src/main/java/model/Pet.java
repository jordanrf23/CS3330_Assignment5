package model;

public abstract class Pet implements Comparable<Pet> {
	protected int uniqueId;
	protected String animalName;
	protected String category;
	protected String subSpecies;
	protected int yearsOld;
	protected boolean adopted;
	
	/*
	 * connects the attributes for Pet 
	 */
	public Pet(int uniqueId, String animalName, String category, String subSpecies, int yearsOld, boolean adopted) {
		super();
		this.uniqueId = uniqueId;
		this.animalName = animalName;
		this.category = category;
		this.subSpecies = subSpecies;
		this.yearsOld = yearsOld;
		this.adopted = adopted;
	}

	/*
	 * obtains the Id
	 */
	public int getUniqueId() {
		return uniqueId;
	}

	/*
	 * assigns the Id
	 */
	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}



	/*
	 * obtains the name 
	 */
	public String getAnimalName() {
		return animalName;
	}



	/*
	 * assigns the animal's name
	 */
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}



	/*
	 * obtains the category for the animal
	 */
	public String getCategory() {
		return category;
	}



	/*
	 * assigns the category for the animal
	 */
	public void setCategory(String category) {
		this.category = category;
	}



	/*
	 * obtains the sub species 
	 */
	public String getSubSpecies() {
		return subSpecies;
	}



	/*
	 * assigns the sub species to the animal
	 */
	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}



	/*
	 * obtains the age for the animal
	 */
	public int getYearsOld() {
		return yearsOld;
	}



	/*
	 * assigns the age to the animal
	 */
	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
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
		return this.animalName.compareToIgnoreCase(o.animalName);
	}

	/*
	 * outlines the animal that is on the website
	 */
	@Override
	public String toString() {
		return String.format("%s (ID: %d, Age: %d, Category: %s, SubSpecies: %s, Adopted: %b ", animalName, uniqueId, yearsOld, category, subSpecies, adopted );
	}
}