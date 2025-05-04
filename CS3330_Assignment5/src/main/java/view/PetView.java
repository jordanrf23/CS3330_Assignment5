package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Cat;
import model.Dog;
import model.Pet;
import model.Rabbit;
import model.Shelter;

public class PetView  extends JFrame{
	
	private JButton addButton = new JButton("Add Pet");
	private JButton adoptButton = new JButton("Adopt Pet");
	private JButton removeButton = new JButton("Remove Pet");
	private JButton saveButton = new JButton("Save Pet");
	private JComboBox<String> sortComboBox = new JComboBox<>(new String[] {"Name", "Age", "Species"});
	private JTable petTable;
	private DefaultTableModel tableModel;
	
	private Consumer<Pet> adoptPetListener;
	private Consumer<Pet> removePetListener;
	private Consumer<Pet> addPetListener;
	private Consumer<String> sortListener;
	private Runnable saveListener;
	
	public PetView() {
		setTitle("Adopt Me! - Online Adoption Center");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		initComponents();
	}
	
	private void initComponents() {
		tableModel = new DefaultTableModel(new Object[] {"Name", "Age", "Species", "Adopted"}, 0) {
			private static final long serialVersionUID = 1L;
			@Override
	        public boolean isCellEditable(int row, int column) { return false; }
	    };
	    petTable = new JTable(tableModel);
	    JScrollPane tableScroll = new JScrollPane(petTable);
	    
	    addButton = new JButton("Add");
        adoptButton = new JButton("Adopt");
        removeButton = new JButton("Remove");
        saveButton = new JButton("Save");
        
        sortComboBox = new JComboBox<>(new String[] {"Name", "Age", "Species"});
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(adoptButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(new JLabel("Sort by:"));
        buttonPanel.add(sortComboBox);
        
        setLayout(new BorderLayout());
        add(tableScroll, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        addButton.addActionListener(e -> {
            JTextField nameField = new JTextField();
            JTextField ageField = new JTextField();
            JComboBox<String> speciesBox = new JComboBox<>(new String[]{"Dog", "Cat", "Rabbit"});

            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Name:"));
            panel.add(nameField);
            panel.add(new JLabel("Age:"));
            panel.add(ageField);
            panel.add(new JLabel("Species:"));
            panel.add(speciesBox);

            int result = JOptionPane.showConfirmDialog(
                this, panel, "Add Pet", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE
            );

            if (result == JOptionPane.OK_OPTION) {
                String name = nameField.getText().trim();
                String ageText = ageField.getText().trim();
                String species = (String) speciesBox.getSelectedItem();

                // Basic validation
                if (name.isEmpty() || ageText.isEmpty()) {
                    showError("Name and age must not be empty.");
                    return;
                }

                int age;
                try {
                    age = Integer.parseInt(ageText);
                    if (age < 0) throw new NumberFormatException();
                } catch (NumberFormatException ex) {
                    showError("Age must be a positive integer.");
                    return;
                }

                // Create the Pet object according to species
                Pet pet = null;
                if ("Dog".equals(species)) {
                    pet = new model.Dog(age, name, age, rootPaneCheckingEnabled, species);
                } else if ("Cat".equals(species)) {
                    pet = new model.Cat(age, name, age, rootPaneCheckingEnabled, species);
                } else if ("Rabbit".equals(species)) {
                    pet = new model.Rabbit(age, name, age, rootPaneCheckingEnabled, species);
                }
                if (pet != null && addPetListener != null) {
                    addPetListener.accept(pet);
                }
            }
        });
        adoptButton.addActionListener(e -> {
            Pet selected = getSelectedPet();
            if (adoptPetListener != null && selected != null) adoptPetListener.accept(selected);
        });
        removeButton.addActionListener(e -> {
            Pet selected = getSelectedPet();
            if (removePetListener != null && selected != null) removePetListener.accept(selected);
        });
        saveButton.addActionListener(e -> {
            if (saveListener != null) saveListener.run();
        });
        sortComboBox.addActionListener(e -> {
            if (sortListener != null) sortListener.accept((String) sortComboBox.getSelectedItem());
        });

	}

	public void setAddPetListener(Consumer<Pet> listener) {
		this.addPetListener = listener;
	}
	
	public void setAdoptPetListener(Consumer<Pet> listener) {
		this.adoptPetListener = listener;
	}
	
	public void setRemovePetListener(Consumer<Pet> listener) {
		this.removePetListener = listener;
	}
	
	public void setSaveListener(Runnable listener) {
		this.saveListener = listener;
	}
	
	public void setSortListener(Consumer<String> listener) {
		this.sortListener = listener;
	}
	
	public void setPetList(List<Pet> pets) {
	    tableModel.setRowCount(0);
	    for (Pet pet : pets) {
	        tableModel.addRow(new Object[]{
	                pet.getName(),
	                pet.getAge(),
	                pet.getspecies(),
	                pet.isAdopted() ? "Yes" : "No"
	        });
	    }
	}
	public void showPetDetails(Pet pet) {
        String message = String.format(
                "Name: %s\nAge: %d\nSpecies: %s\nAdopted: %s",
                pet.getName(), pet.getAge(), pet.getspecies(), pet.isAdopted() ? "Yes" : "No"
        );
        JOptionPane.showMessageDialog(this, message, "Pet Details", JOptionPane.INFORMATION_MESSAGE);
    }

	public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

	public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }
	
	public Pet getSelectedPet() {
        int row = petTable.getSelectedRow();
        if (row == -1) return null;
        String name = (String) tableModel.getValueAt(row, 0);
        int age = Integer.parseInt(tableModel.getValueAt(row, 1).toString());
        String species = (String) tableModel.getValueAt(row, 2);
        return null;
    }

}
