package controller;

import model.Pet;
import model.Shelter;
import view.PetView;

public class PetController {
	
	private final Shelter<Pet> shelter;
	private final PetView view;
	
	public PetController(Shelter<Pet> shelter, PetView view) {
		this.shelter = shelter;
		this.view =view;
		
	}


}
