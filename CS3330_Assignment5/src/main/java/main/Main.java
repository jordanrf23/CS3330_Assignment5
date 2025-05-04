package main;

import java.io.File;
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
		                pets.addAll(PetLoader.loadPets(new File(Main.class.getResource("/pets.json").getFile())));
		                pets.addAll(PetLoader.loadExoticPets(new File(Main.class.getResource("/exotic_pets.json").getFile())));

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

