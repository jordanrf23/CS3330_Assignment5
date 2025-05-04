package model;

public class ExoticAnimal {
	private String uniqueId;
	private String animalName;
	private int yearsOld;
	private String animalType;
	private boolean isAdopted;
	
	/*
	 * based on the json file each attribute
	 */
	public ExoticAnimal(String animalName, int yearsOld, String animalType, boolean isAdopted) {
		super();
		this.animalName = animalName;
		this.yearsOld = yearsOld;
		this.animalType = animalType;
		this.isAdopted = isAdopted;
	}
	
	/*
	 * obtains the id
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/*
	 * obtains the name
	 */
	public String getAnimalName() {
		return animalName;
	}

	/*
	 * obtains the age
	 */
	public int getYearsOld() {
		return yearsOld;
	}
	
	/*
	 * obtains the type
	 */
	public String getAnimalType() {
		return animalType;
	}

	/*
	 * updates the adoption
	 */
	public boolean isAdopted() {
		return isAdopted;
	}
	
	/*
	 * changes the adoption attribute
	 */
	public void markAsAdopted() {
		this.isAdopted = true;
	}


}
