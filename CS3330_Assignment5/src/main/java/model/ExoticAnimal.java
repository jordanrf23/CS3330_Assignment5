package model;

public class ExoticAnimal {
	private String animalName;
	private int yearsOld;
	private String animalType;
	private boolean isAdopted;
	
	public ExoticAnimal(String animalName, int yearsOld, String animalType, boolean isAdopted) {
		super();
		this.animalName = animalName;
		this.yearsOld = yearsOld;
		this.animalType = animalType;
		this.isAdopted = isAdopted;
	}

	public String getAnimalName() {
		return animalName;
	}

	public int getYearsOld() {
		return yearsOld;
	}

	public String getAnimalType() {
		return animalType;
	}

	public boolean isAdopted() {
		return isAdopted;
	}
	
	public void markAsAdopted() {
		this.isAdopted = true;
	}

}
