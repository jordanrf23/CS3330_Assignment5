package model;

public class ExoticAnimalAdapter extends Pet {
	
	private ExoticAnimal exoticAnimal;

	public ExoticAnimalAdapter(String id, ExoticAnimal exoticAnimal) {
		super(id, exoticAnimal.getAnimalName(), exoticAnimal.getAnimalType(), "Exotic", exoticAnimal.getYearsOld(), exoticAnimal.isAdopted());
		this.exoticAnimal = exoticAnimal;
	}
	
	 @Override
	    public String getId() {
	        return exoticAnimal.getUniqueId();
	    }
	
	@Override
	public String getName() {
		return exoticAnimal.getAnimalName();
	}


	@Override
	 public void adopt() {
	     exoticAnimal.markAsAdopted();
	     this.setAdopted(true);
	}

	 public ExoticAnimal getExoticAnimal() {
		 return exoticAnimal;
	 }

}
