package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Shelter<T extends Pet>{
	private final List<T> pets;
	
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
	
	 public void removePet(T pet) {
	        pets.remove(pet);
	    }
	
	/*
	 * removes pet by using their id 
	 */
	public boolean removePetById(String id) {
		return pets.removeIf(p-> p.getId() == id);
	}
	
	/*
	 * obtains a pet by their id 
	 */
	public T getPetById(String id) {
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
	public boolean adpotPet(Pet pet) {
		if (pet.isAdopted()) {
            JOptionPane.showInputDialog("Already adopted!");
        } else {
            pet.setAdopted(true);
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
	public void sortPets(Comparator<T> comparator) {
		pets.sort(comparator);
	}
	
	/*
	 * sort the pet on collections
	 */
	public void sortPets() {
		Collections.sort(pets);
	}
	
	/*
	 * returns a list of all the pets
	 */
	public List<T> getAllPets(){
		return new ArrayList<>(pets);
	}
	
	/*
	 * list of pets left
	 */
	public List<T> getAvailablePets(){
		return pets.stream().filter(p-> !p.isAdopted()).collect(Collectors.toList());
	}
	
	/*
	 * clears all the pets
	 */
	public void clear() {
		pets.clear();
	}
	
	/*
	 * next id given both exotic and pet
	 */
	public String generateNextId() {
		int maxId = 0;
	    for (Pet pet : pets) {
	        try {
	            int id = Integer.parseInt(pet.getId());
	            if (id > maxId) {
	                maxId = id;
	            }
	        } catch (NumberFormatException e) {
	            // Skip non-numeric IDs
	        }
	    }
	    return String.valueOf(maxId + 1);
	}
}
