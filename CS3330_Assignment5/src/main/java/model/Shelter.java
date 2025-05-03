package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shelter<T extends Pet>{
	private final List<T> pets;
	private static int idCounter = 1;
	
	/*
	 * Aligning pets into a new list
	 */
	public Shelter() {
		this.pets = new ArrayList<>();
	}
	
	/*
	 * add pet to the shelter's list
	 */
	public void addPet(T pet) {
		pets.add(pet);
	}
	
	/*
	 * removes pet by using their id 
	 */
	public boolean removePetById(int id) {
		return pets.removeIf(p-> p.getId() == id);
	}
	
	/*
	 * obtains a pet by their id 
	 */
	public T getPetById(int id) {
		for(T pet: pets) {
			if(pet.getId() == id) {
				return pet;
			}
		}
		return null;
	}
	
	/*
	 * marks pet as adopted if not already
	 */
	public boolean adpotPet(int id) {
		T pet = getPetById(id);
		if(pet != null && !pet.isAdopted()) {
			pet.adopt();
			return true;
		}
		return false;
	}
	
	/*
	 * sorts the pets naturally
	 */
	public void sortByName() {
		Collections.sort(pets);
	}
	
	/*
	 * sorts with comparable 
	 */
	public void sort (Comparator<T> comparator) {
		pets.sort(comparator);
	}
	
	/*
	 * returns a list of all the pets
	 */
	public List<T> getAllPets(){
		return new ArrayList<>(pets);
	}
	
	/*
	 * clears all the pets
	 */
	public void clear() {
		pets.clear();
	}

	public static int getNextId() {
		return idCounter++;
	}

}
