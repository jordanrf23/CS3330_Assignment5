package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.Cat;
import model.Dog;
import model.Pet;
import model.Rabbit;
import model.Shelter;

public class PetView  extends JFrame{
	
	private final DefaultListModel<String> petListModel = new DefaultListModel<>();
	private final JList<String> petJList = new JList<>(petListModel);
	private final JButton addButton = new JButton("Add Pet");
	private final JButton adoptButton = new JButton("Adopt Pet");
	private final JButton removeButton = new JButton("Remove Pet");
	private final JButton saveButton = new JButton("Save Pet");
	private final JComboBox<String> sortComboBox = new JComboBox<>(new String[] {"Name", "Age", "Species"});

	public PetView() {
		setTitle("Adopt Me! - Online Adoption Center");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		getContentPane().setLayout(new BorderLayout());
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel controls = new JPanel();
		controls.add(addButton);
		controls.add(adoptButton);
		controls.add(removeButton);
		controls.add(new JLabel("Sort By"));
		controls.add(sortComboBox);
		controls.add(saveButton);
		add(controls, BorderLayout.SOUTH);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void setAddPetListener(ActionListener listener) {
		addButton.addActionListener(listener);
	}
	
	public void setAdoptPetListener(ActionListener listener) {
		adoptButton.addActionListener(listener);
	}
	
	public void setRemovePetListener(ActionListener listener) {
		removeButton.addActionListener(listener);
	}
	
	public void setSaveListener(ActionListener listener) {
		saveButton.addActionListener(listener);
	}
	
	public void setSortListener(ActionListener listener) {
		sortComboBox.addActionListener(listener);
	}
	
	public void updatePetList(List<Pet> pets) {
		petListModel.clear();
		for(Pet pet : pets) {
			petListModel.addElement(pet.toString());
		}
	}
	
	public int getSelectedPetId() {
		int index = petJList.getSelectedIndex();
		return index >= 0 ? index : -1;
	}
	
	public Pet promptNewPet() {
		JTextField nameField = new JTextField();
	    JTextField ageField = new JTextField();
	    JTextField breedField = new JTextField();
	    String[] speciesOptions = {"Dog", "Cat", "Rabbit"};
	    JComboBox<String> speciesCombo = new JComboBox<>(speciesOptions);

	    JPanel panel = new JPanel(new GridLayout(0, 1));
	    panel.add(new JLabel("Name:"));
	    panel.add(nameField);
	    panel.add(new JLabel("Age:"));
	    panel.add(ageField);
	    panel.add(new JLabel("Breed:"));
	    panel.add(breedField);
	    panel.add(new JLabel("Species:"));
	    panel.add(speciesCombo);

	    int result = JOptionPane.showConfirmDialog(this, panel, "Add New Pet",
	            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

	    if (result == JOptionPane.OK_OPTION) {
	        try {
	            String name = nameField.getText().trim();
	            int age = Integer.parseInt(ageField.getText().trim());
	            String breed = breedField.getText().trim();
	            String species = (String) speciesCombo.getSelectedItem();
	            int id = Shelter.getNextId();

	            switch (species) {
	                case "Dog":
	                    return new Dog(id, name, age, false, breed);
	                case "Cat":
	                    return new Cat(id, name, age, false, breed);
	                case "Rabbit":
	                    return new Rabbit(id, name, age, false, breed);
	                default:
	                    showMessage("Unsupported species.");
	            }
	        } catch (Exception e) {
	            showMessage("Invalid input. Please check age and name fields.");
	        }
	    }
	    return null;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
	}
}
