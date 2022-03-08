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

public class MainWin extends JFrame {
	private Shelter shelter = new Shelter("Mavs Animal Shelter");
    private JLabel data = new JLabel("List animals");

	public MainWin(String title){
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 900);

		JMenuBar menuBar = new JMenuBar();

		JMenu file = new JMenu("File");
		JMenuItem quit = new JMenuItem("Quit: Exit Shelter");		
		
		JMenu animal = new JMenu("Animal");
		JMenuItem dog = new JMenuItem("New Dog");
		JMenuItem cat = new JMenuItem("New Cat");
		JMenuItem listAll = new JMenuItem("List animals");

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
    	add(data, BorderLayout.CENTER);

		JButton catButton = new JButton(new ImageIcon("cat.png"));
    	catButton.setActionCommand("Add a new cat");
    	catButton.setToolTipText("Add a new cat, include name, age, breed and gender");
    	catButton.setBorder(null);
    	toolbar.add(catButton);
    	catButton.addActionListener(event -> onNewCatClick());
    	add(data, BorderLayout.CENTER);

    	JButton shelterButton = new JButton(new ImageIcon("Animal_Shelter.png"));
    	shelterButton.setActionCommand("List all animals");
    	shelterButton.setToolTipText("List all animals in the shleter entered by the user");
    	shelterButton.setBorder(null);
    	toolbar.add(shelterButton);
    	shelterButton.addActionListener(event -> updateDisplay());
    	
    	getContentPane().add(toolbar, BorderLayout.PAGE_START);
    	add(data, BorderLayout.CENTER);

		setJMenuBar(menuBar);
		setVisible(true);
	}

	public void onQuitClick() {
		System.exit(0);
	}

	public void onNewDogClick() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 900);

		JComboBox breedsOfDog;
		JTextField dogNames;
		JComboBox dogGenders;
		JSpinner agesOfDog;

		JLabel breedOfDog = new JLabel("Breed");
		String[] dogBreeds = {"Mix", "Labrador", "Shepherd", "Retriever", "Bulldog", "Beagle", "Poodle", "Rottweiler", "Pointer", "Terrier", 
    						"Boxer", "Dachshund", "Dalmatian", "Greyhound", "Chihuahua", "Husky", "Samoyed", "Dobermann", "Corgi", "Schnauzer"
    						};
    	breedsOfDog = new JComboBox<String>(dogBreeds);

    	JLabel nameOfDog = new JLabel("<HTML><br/>Name</HTML>");
    	dogNames = new JTextField(50);

    	JLabel gender = new JLabel("<HTML><br/>Gender</HTML>");
    	String[] genderOfDog = {"Male", "Female"};
    	dogGenders = new JComboBox<String>(genderOfDog);

    	JLabel dogAge = new JLabel("<HTML><br/>Age</HTML>");
    	SpinnerModel ageRange = new SpinnerNumberModel(0, 0, 50, 1);
    	agesOfDog = new JSpinner(ageRange);

    	Object[] objects = {breedOfDog, breedsOfDog, nameOfDog, dogNames, gender, dogGenders, dogAge, agesOfDog};

    	int button = JOptionPane.showConfirmDialog(this, objects, "New Dog", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    	if(button == JOptionPane.OK_OPTION){
    		JOptionPane.showMessageDialog(this, dogNames.getText() + " is a " + dogGenders.getSelectedItem() + " "
    									+ breedsOfDog.getSelectedItem() + " age " + agesOfDog.getValue()
    									);
    	}

	}

	public void onNewCatClick() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 900);

		JComboBox breedsOfCat;
		JTextField catNames;
		JComboBox catGenders;
		JSpinner agesOfCat;

		JLabel breed = new JLabel("Breed");
		String[] catBreeds = {"Mix", "Abyssinian", "American_Shorthair", "Bengal", "Birman", "British_Shorthair", "Burmese", "Devon_Rex", 
							"Himalayan", "Maine_Coon", "Norwegian_Forest", "Ocicat", "Oriental_Shorthair", "Persian", "Ragdoll", 
							"Russian_Blue", "Scottish_Fold", "Siamese", "Sphynx", "Tonkinese", "Ragamuffin", "Toyger", "LaPerm", 
							"Peterbald", "Savannah"
    						};
    	breedsOfCat = new JComboBox<String>(catBreeds);

    	JLabel name = new JLabel("<HTML><br/>Name</HTML>");
    	catNames = new JTextField(50);

    	JLabel gender = new JLabel("<HTML><br/>Gender</HTML>");
    	String[] genderOfCat = {"Male", "Female"};
    	catGenders = new JComboBox<String>(genderOfCat);

    	JLabel age = new JLabel("<HTML><br/>Age</HTML>");
    	SpinnerModel ageRange = new SpinnerNumberModel(0, 0, 50, 1);
    	agesOfCat = new JSpinner(ageRange);

    	Object[] objects = {breed, breedsOfCat, name, catNames, gender, catGenders, age, agesOfCat};

    	int button = JOptionPane.showConfirmDialog(this, objects, "New Cat", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    	if(button == JOptionPane.OK_OPTION){
    		JOptionPane.showMessageDialog(this, catNames.getText() + " is a " + catGenders.getSelectedItem() + " "
    									+ breedsOfCat.getSelectedItem() + " age " + agesOfCat.getValue()
    									);
    	}

	}

	public void onAboutClick() {
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
    	+ "<p>Licensed under Gnu GPL 3.0</p>"
    	+ "<p>https://cdn-prod.medicalnewstoday.com</p><p>/content/images/articles/322/322868/golden-retriever-puppy.jpg</p>"
    	+ "<p>https://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/</p><p>VAN_CAT.png/220px-VAN_CAT.png</p>"
    	);

    	about.add(artists);

    	JButton ok = new JButton("OK");
    	ok.addActionListener(event -> about.setVisible(false));
    	about.add(ok);
        
    	about.setSize(700,500);
    	about.setVisible(true);
    }

    private void updateDisplay(){
    	data.setText("<html>" + shelter.toString()
    									.replaceAll("<", "&lt;")
    									.replaceAll(">", "&gt;")
    									.replaceAll("\n", "<br/>")
    							+ "</html>");
    }

	public static void main(String[] args) {
    	MainWin aWindow = new MainWin("Mavs Animal Shelter");
    	aWindow.setVisible(true);
    }
}