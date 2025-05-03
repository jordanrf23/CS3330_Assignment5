package view;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;

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
		setLayout(new BorderLayout());
		
		
	}


}
