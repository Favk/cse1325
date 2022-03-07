import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;

import shelter.Dog;
import shelter.Cat;
import shelter.Shelter;
import shelter.DogBreed;
import shelter.CatBreed;
import shelter.Gender;

public class MainWin extends JFrame {// implements ActionListener {
	private Shelter shelter;
    private JLabel data;

	public MainWin(String title){
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1600, 900);

		JMenuBar menuBar = new JMenuBar();

		JMenu file = new JMenu("File");
		JMenuItem quit = new JMenuItem("Quit: Exit Shelter");		
		
		JMenu animal = new JMenu("Animal");
		JMenuItem dog = new JMenuItem("New Dog");
		JMenuItem cat = new JMenuItem("New Cat");
		JMenuItem listAll = new JMenuItem("List available animals");

		JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");

		quit.addActionListener(event -> onQuitClick());
		about.addActionListener(event -> onAboutClick());
		dog.addActionListener(event -> onNewDogClick());
		cat.addActionListener(event -> onNewCatClick());
		listAll.addActionListener(event -> updateDisplay());
		
		file.add(quit);

		animal.add(dog);
		animal.add(cat);
		animal.add(listAll);

		help.add(about);

		menuBar.add(file);
		menuBar.add(animal);
		menuBar.add(help);

		JToolBar toolbar = new JToolBar("Shelter Management");

    	JButton dogButton = new JButton(new ImageIcon("dog.png"));
    	dogButton.setActionCommand("Add a new dog");
    	dogButton.setToolTipText("Add a new dog, include name, age, breed and gender");
    	dogButton.setBorder(null);
    	toolbar.add(dogButton);
    	dogButton.addActionListener(event -> onNewDogClick());

		JButton catButton = new JButton(new ImageIcon("cat.png"));
    	catButton.setActionCommand("Add a new cat");
    	catButton.setToolTipText("Add a new cat, include name, age, breed and gender");
    	catButton.setBorder(null);
    	toolbar.add(catButton);
    	catButton.addActionListener(event -> onNewCatClick());

    	JButton shelterButton = new JButton(new ImageIcon("Animal_Shelter.png"));
    	shelterButton.setActionCommand("List all animals");
    	shelterButton.setToolTipText("List all animals in the shleter entered by the user");
    	shelterButton.setBorder(null);
    	toolbar.add(shelterButton);

    	getContentPane().add(toolbar, BorderLayout.PAGE_START);

		setJMenuBar(menuBar);
		setVisible(true);
	}

	public void onQuitClick() {
		System.exit(0);
	}

	public void onNewDogClick() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 900);

		JComboBox breeds;
		JTextField names;
		JComboBox genders;
		JSpinner ages;

		JLabel breed = new JLabel("Breed");
		String[] dogBreeds = {"Mix", "Labrador", "Shepherd", "Retriever", "Bulldog", "Beagle", "Poodle", "Rottweiler", "Pointer", "Terrier", 
    						"Boxer", "Dachshund", "Dalmatian", "Greyhound", "Chihuahua", "Husky", "Samoyed", "Dobermann", "Corgi", "Schnauzer"
    						};
    	breeds = new JComboBox<String>(dogBreeds);

    	JLabel name = new JLabel("<HTML><br/>Name</HTML>");
    	names = new JTextField(50);

    	JLabel gender = new JLabel("<HTML><br/>Gender</HTML>");
    	String[] genderOfDog = {"Male", "Female"};
    	genders = new JComboBox<String>(genderOfDog);

    	JLabel age = new JLabel("<HTML><br/>Age</HTML>");
    	SpinnerModel ageRange = new SpinnerNumberModel(0, 0, 50, 1);
    	ages = new JSpinner(ageRange);

    	Object[] objects = {breed, breeds, name, names, gender, genders, age, ages};

    	int button = JOptionPane.showConfirmDialog(this, objects, "New Dog", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    	if(button == JOptionPane.OK_OPTION){
    		JOptionPane.showMessageDialog(this, names.getText() + " is a " + genders.getSelectedItem() + " "
    									+ breeds.getSelectedItem() + " age " + ages.getValue()
    									);
    	}

	}

	public void onNewCatClick() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 900);

		JComboBox breeds;
		JTextField names;
		JComboBox genders;
		JSpinner ages;

		JLabel breed = new JLabel("Breed");
		String[] catBreeds = {"Mix", "Abyssinian", "American_Shorthair", "Bengal", "Birman", "British_Shorthair", "Burmese", "Devon_Rex", 
							"Himalayan", "Maine_Coon", "Norwegian_Forest", "Ocicat", "Oriental_Shorthair", "Persian", "Ragdoll", 
							"Russian_Blue", "Scottish_Fold", "Siamese", "Sphynx", "Tonkinese", "Ragamuffin", "Toyger", "LaPerm", 
							"Peterbald", "Savannah"
    						};
    	breeds = new JComboBox<String>(catBreeds);

    	JLabel name = new JLabel("<HTML><br/>Name</HTML>");
    	names = new JTextField(50);

    	JLabel gender = new JLabel("<HTML><br/>Gender</HTML>");
    	String[] genderOfCat = {"Male", "Female"};
    	genders = new JComboBox<String>(genderOfCat);

    	JLabel age = new JLabel("<HTML><br/>Age</HTML>");
    	SpinnerModel ageRange = new SpinnerNumberModel(0, 0, 50, 1);
    	ages = new JSpinner(ageRange);

    	Object[] objects = {breed, breeds, name, names, gender, genders, age, ages};

    	int button = JOptionPane.showConfirmDialog(this, objects, "New Dog", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    	if(button == JOptionPane.OK_OPTION){
    		JOptionPane.showMessageDialog(this, names.getText() + " is a " + genders.getSelectedItem() + " "
    									+ breeds.getSelectedItem() + " age " + ages.getValue()
    									);
    	}

	}

	public void onAboutClick() {                 // Display About dialog
		JDialog about = new JDialog();
    	about.setLayout(new FlowLayout());
    	about.setTitle("Mavs Animal Shelter Software");
        
    	try {
    		BufferedImage myPicture = ImageIO.read(new File("Animal.png"));
    		JLabel logo = new JLabel(new ImageIcon(myPicture));
    		about.add(logo);
    	} catch(IOException e) {
    		}
        
    	JLabel title = new JLabel("<html>"
    	+ "<p><font size=+4>MASS</font></p>"
    	+ "</html>");
    	about.add(title);

    	JLabel artists = new JLabel("<html>"
    	+ "<p><font size=+2>Mavs Animal Shelter Software</font></p>"
    	+ "<p>Version 1.0</p>"
    	+ "<p>Copyright 2022 by Kolade Favour</p>"
    	+ "<p>Licensed under Gnu GPL 3.0</p>");
    	about.add(artists);

    	JButton ok = new JButton("OK");
    	ok.addActionListener(event -> about.setVisible(false));
    	about.add(ok);
        
    	about.setSize(450,400);
    	about.setVisible(true);
    }

	public static void main(String[] args) {
    	MainWin aWindow = new MainWin("Mavs Animal Shelter");
    	aWindow.setVisible(true);
    }
}