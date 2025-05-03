package model;

public class ExoticAnimal {
	private String uniqueName;
	private int yearsOld;
	private String animalType;
	private boolean isAdopted;
	
	public ExoticAnimal(String uniqueName, int yearsOld, String animalType, boolean isAdopted) {
		super();
		this.uniqueName = uniqueName;
		this.yearsOld = yearsOld;
		this.animalType = animalType;
		this.isAdopted = isAdopted;
	}

	public String getUniqueName() {
		return uniqueName;
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
