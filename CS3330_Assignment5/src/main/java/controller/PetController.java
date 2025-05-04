package controller;

import java.io.File;

import java.io.IOException;
import java.util.Comparator;

import model.Pet;
import model.Shelter;
import util.JsonUtil;
import view.PetView;

public class PetController {
	
	private final Shelter<Pet> shelter;
    private final PetView view;

    /*
     * recognizing the shelter and view classes
     */
    public PetController(Shelter<Pet> shelter, PetView view) {
        this.shelter = shelter;
        this.view = view;

        setupEventHandlers();
    }

    /*
     * combines the listeners and handle methods
     */
    private void setupEventHandlers() { 
    	
    	view.setPetList(shelter.getAllPets());
        view.setAddPetListener(this::handleAddPet);
        view.setAdoptPetListener(this::handleAdoptPet);
        view.setRemovePetListener(this::handleRemovePet);
        view.setSortListener(this::handleSortPets);
        view.setSaveListener(this::handleSavePets);
    
   }
    
    /*
     * add pet for both methods
     */
    private void handleAddPet(Pet pet) {
        shelter.addPet(pet);
        view.setPetList(shelter.getAllPets());
    }

    /*
     * adopt pet to be shown pre/post adoption
     */
    private void handleAdoptPet(Pet pet) {
        if (pet == null) {
            view.showError("Please select a pet to adopt.");
            return;
        }
        if (pet.isAdopted()) {
            view.showError("This pet has already been adopted!");
            return;
        }
        shelter.adpotPet(pet);
        view.setPetList(shelter.getAllPets());
        view.showMessage("Pet adopted successfully!");
    }

    /*
     * removing the pet 
     */
    private void handleRemovePet(Pet pet) {
        if (pet == null) {
            view.showError("Please select a pet to remove.");
            return;
        }
        shelter.removePet(pet);
        view.setPetList(shelter.getAllPets());
    }
    
    /*
     * sorting the pets and calls the comparator classes
     */
    private void handleSortPets(String sortBy) {
        Comparator<Pet> comparator;
        switch (sortBy) {
            case "Age":
                comparator = new model.PetByAge();
                break;
            case "Species":
                comparator = new model.PetBySpecies();
                break;
            case "Name":
            	comparator = new model.PetByName();
            default:
                comparator = Comparator.naturalOrder();
        }
        shelter.sortPets(comparator);
        view.setPetList(shelter.getAllPets());
    }
    
    /*
     * saves the pet with message and new json 
     */
    private void handleSavePets() {
        String filename = util.DateTimeUtil.getCurrentTimestamp() + " pets.json";
        try {
            JsonUtil.savePets(shelter.getAllPets(), new File(filename));
            view.showMessage("Pets saved to " + filename);
        } catch (IOException e) {
            view.showError("Failed to save pets: " + e.getMessage());
        }
    }
   
}
