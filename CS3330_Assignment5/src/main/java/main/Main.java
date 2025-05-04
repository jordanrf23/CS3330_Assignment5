package main;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.PetController;
import model.Pet;
import model.PetLoader;
import model.Shelter;
import view.PetView;

public class Main {

	public static void main(String[] args) {
		        SwingUtilities.invokeLater(() -> {
		            try {
		                // Load pets from JSON files
		            	List<Pet> pets = new ArrayList<>();
		            	URL petsUrl = Main.class.getResource("/pets.json");
		            	URL exoticUrl = Main.class.getResource("/exotic_animals.json");
		            	if (petsUrl == null) {
		            	    JOptionPane.showMessageDialog(null, "Could not find pets.json in resources!", "Startup Error", JOptionPane.ERROR_MESSAGE);
		            	    return;
		            	}
		            	File petsFile = new File(petsUrl.getFile());
		            	pets.addAll(PetLoader.loadPets(petsFile));
		            	File exoticFile = new File(exoticUrl.getFile());
		            	pets.addAll(PetLoader.loadExoticPets(exoticFile));
		                
		                
		               //pets.addAll(PetLoader.loadExoticPets(new File(Main.class.getResource("/exotic_animals.json").getFile())));

		                // Create model, view, and controller
		                Shelter<Pet> shelter = new Shelter<>();
		                pets.forEach(shelter::addPet);

		                PetView view = new PetView();
		                PetController controller = new PetController(shelter, view);

		                // Show the GUI
		                view.setVisible(true);
		            } catch (Exception e) {
		                JOptionPane.showMessageDialog(null,
		                        "Failed to start application: " + e.getMessage(),
		                        "Startup Error", JOptionPane.ERROR_MESSAGE);
		                e.printStackTrace();
		            }
		        });
		    }

	}

