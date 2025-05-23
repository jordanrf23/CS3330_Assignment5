package model;

import java.util.Comparator;

public class PetBySpecies implements Comparator<Pet>{

	/*
	 * compares two species at a time 
	 */
	@Override
	public int compare(Pet arg0, Pet arg1) {
		return arg0.getspecies().compareToIgnoreCase(arg1.getspecies());
	}

}
