package model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class PetLoader {
	
	private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	/*
	 * loads the pet json when first ran
	 */
	public static List<Pet> loadPets(File file) throws IOException {
        List<Pet> pets = new ArrayList<>();
        try (Reader reader = new FileReader(file)) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            for (JsonElement element : jsonArray) {
                JsonObject obj = element.getAsJsonObject();
                String id = obj.get("id").getAsString();
                String species = obj.get("species").getAsString();
                String type = obj.get("type").getAsString();
                String name = obj.get("name").getAsString();
                int age = obj.get("age").getAsInt();
                boolean adopted = obj.has("adopted") && obj.get("adopted").getAsBoolean();


                switch (type.toLowerCase()) {
                    case "dog":
                        pets.add(new Dog(id, name, "Dog", species, age, adopted));
                        break;
                    case "cat":
                        pets.add(new Cat(id, name, "Cat", species, age, adopted));
                        break;
                    case "rabbit":
                        pets.add(new Rabbit(id, name, "Rabbit", species, age, adopted));
                        break;
                    default:
                        // Unknown species, can log or skip
                        break;
                }
            }
        }
        return pets;
    }
	
	/*
	 * loads in the exotic json file when first ran
	 */
	public static List<Pet> loadExoticPets(File file) throws IOException {
        List<Pet> pets = new ArrayList<>();
        try (Reader reader = new FileReader(file)) {
            Type listType = new TypeToken<List<ExoticAnimal>>(){}.getType();
            List<ExoticAnimal> exoticAnimals = gson.fromJson(reader, listType);
            for (ExoticAnimal exotic : exoticAnimals) {
                pets.add(new ExoticAnimalAdapter(exotic.getUniqueId(), exotic));
            }
        }
        return pets;
    }

}
