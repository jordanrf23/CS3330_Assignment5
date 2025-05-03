package model;

import java.util.Comparator;

public class PetByName implements Comparator<Pet>{

	@Override
	public int compare(Pet p1, Pet p2) {
		return p1.getName().compareToIgnoreCase(p2.getName());
	}
}
