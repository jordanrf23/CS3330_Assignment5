package model;

import java.util.Comparator;

public class PetByAge implements Comparator<Pet>{
	
	/*
	 * takes two pets and will compare based on age
	 */
	@Override
	public int compare(Pet o1, Pet o2) {
		
		return Integer.compare(o1.getAge(), o2.getAge());
	}
	
}
