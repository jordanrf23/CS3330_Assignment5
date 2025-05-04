package model;

public class ExoticAnimalAdapter extends Pet {
	
	private ExoticAnimal exoticAnimal;

	/*
	 * uses the pet method and makes in comparable with exotic
	 */
	public ExoticAnimalAdapter(String id, ExoticAnimal exoticAnimal) {
		super(id, exoticAnimal.getAnimalName(), exoticAnimal.getAnimalType(), "Exotic", exoticAnimal.getYearsOld(), exoticAnimal.isAdopted());
		this.exoticAnimal = exoticAnimal;
	}
	
	/*
	 * obtains id from exotic
	 */
	 @Override
	    public String getId() {
	        return exoticAnimal.getUniqueId();
	    }
	
	 /*
	  * obtains the name from exotic
	  */
	@Override
	public String getName() {
		return exoticAnimal.getAnimalName();
	}

	/*
	 * changes the adopted mark
	 */
	@Override
	 public void adopt() {
	     exoticAnimal.markAsAdopted();
	     this.setAdopted(true);
	}
	
	/*
	 * returns the exotic animal given it all
	 */
	 public ExoticAnimal getExoticAnimal() {
		 return exoticAnimal;
	 }

}
