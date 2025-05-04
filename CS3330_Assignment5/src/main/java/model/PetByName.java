package model;

import java.util.Comparator;

public class PetByName implements Comparator<Pet>{

	/*
	 * comparing two names at a time 
	 */
	@Override
	public int compare(Pet p1, Pet p2) {
		return p1.getName().compareToIgnoreCase(p2.getName());
	}
}
