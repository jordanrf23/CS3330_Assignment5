package util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.Pet;

public class JsonUtil {
	
	private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	public static List<Pet> loadPets(File file) throws IOException {
		try(Reader reader = new FileReader(file)){
			Type petListType = new TypeToken<List<Pet>>(){}.getType();
			return gson.fromJson(reader, petListType);
		}
	}
	
	public static void savePets(List<Pet> pets, File file) throws IOException{
		try(Writer writer = new FileWriter(file)){
			gson.toJson(pets, writer);
		}
	}
}
