import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.UIManager;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;

import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import java.awt.FlowLayout;

import java.awt.Font;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import shelter.Dog;
import shelter.Cat;
import shelter.Shelter;
import shelter.DogBreed;
import shelter.CatBreed;
import shelter.Gender;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.UIManager;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;

import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import java.awt.FlowLayout;

import java.awt.Font;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class MainWin extends JFrame {
	private Shelter shelter = new Shelter("Mavs Animal Shelter");
    private JLabel data;
    private File filename;

    private String NAME = "Mass";
    private String VERSION = "1.4J";
    private String FILE_VERSION = "1.0";
    private String MAGIC_COOKIE = "Mass🐾🐾";

	public MainWin(String title){
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 900);
		data = new JLabel();
		data.setVerticalAlignment(JLabel.TOP);
		filename = new File("untitled.mass");

		JMenuBar menuBar = new JMenuBar();

		JMenu file = new JMenu("File");
		JMenuItem newFile = new JMenuItem("New Shelter");
		JMenuItem openFile = new JMenuItem("Open Shelter");
		JMenuItem saveShelter = new JMenuItem("Save Shelter");
		JMenuItem saveShelterAs = new JMenuItem("Save Shelter As");
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
		newFile.addActionListener(event -> onNewShelterClick());
		openFile.addActionListener(event -> onOpenShelterClick());
		saveShelter.addActionListener(event -> onSaveShelterClick());
		saveShelterAs.addActionListener(event -> onSaveShelterAsClick());
		
		file.add(newFile);
		file.add(openFile);
		file.add(saveShelter);
		file.add(saveShelterAs);
		file.add(quit);

		animal.add(dog);
		animal.add(cat);
		animal.add(listAll);

		help.add(about);

		menuBar.add(file);
		menuBar.add(animal);
		menuBar.add(help);

		JToolBar toolbar = new JToolBar("Shelter Management");

		JButton anewB  = new JButton(new ImageIcon("new.jpg"));
        anewB.setActionCommand("New Shelter");
        anewB.setToolTipText("Create a new shelter, discarding any in progress");
        anewB.setBorder(null);
        toolbar.add(anewB);
        anewB.addActionListener(event -> onNewShelterClick());

        JButton openShelterButton = new JButton(new ImageIcon("home.jpg"));
    	openShelterButton.setActionCommand("Open shelter");
    	openShelterButton.setToolTipText("Open shelter and see animals");
    	openShelterButton.setBorder(null);
    	toolbar.add(openShelterButton);
    	openShelterButton.addActionListener(event -> onOpenShelterClick());

        JButton saveButton = new JButton(new ImageIcon("save.jpg"));
    	saveButton.setActionCommand("Save animals in a shelter");
    	saveButton.setToolTipText("Save all new animals");
    	saveButton.setBorder(null);
    	toolbar.add(saveButton);
    	saveButton.addActionListener(event -> onSaveShelterClick());

    	JButton saveAsButton = new JButton(new ImageIcon("saveas.png"));
    	saveAsButton.setActionCommand("Save animals in a different file name");
    	saveAsButton.setToolTipText("Save all new animals in different file name");
    	saveAsButton.setBorder(null);
    	toolbar.add(saveAsButton);
    	saveAsButton.addActionListener(event -> onSaveShelterAsClick());

    	JButton dogButton = new JButton(new ImageIcon("dog.png"));
    	dogButton.setActionCommand("Add a new dog");
    	dogButton.setToolTipText("Add a new dog, include name, age, breed and gender");
    	dogButton.setBorder(null);
    	toolbar.add(dogButton);
    	dogButton.addActionListener(event -> onNewDogClick());

    	toolbar.add(Box.createHorizontalStrut(1));

		JButton catButton = new JButton(new ImageIcon("cat.png"));
    	catButton.setActionCommand("Add a new cat");
    	catButton.setToolTipText("Add a new cat, include name, age, breed and gender");
    	catButton.setBorder(null);
    	toolbar.add(catButton);
    	catButton.addActionListener(event -> onNewCatClick());
    	
    	toolbar.addSeparator();

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
    	breedsOfDog = new JComboBox<>(DogBreed.values());

    	JLabel nameOfDog = new JLabel("<HTML><br/>Name</HTML>");
    	dogNames = new JTextField(50);

    	JLabel gender = new JLabel("<HTML><br/>Gender</HTML>");
    	dogGenders = new JComboBox<>(Gender.values());

    	JLabel dogAge = new JLabel("<HTML><br/>Age</HTML>");
    	SpinnerModel ageRange = new SpinnerNumberModel(0, 0, 50, 1);
    	agesOfDog = new JSpinner(ageRange);

    	Object[] objects = {breedOfDog, breedsOfDog, nameOfDog, dogNames, gender, dogGenders, dogAge, agesOfDog};

    	int button = JOptionPane.showConfirmDialog(this, objects, "New Dog", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    	if(button == JOptionPane.OK_OPTION){
    		Dog aDog = new Dog((DogBreed)breedsOfDog.getSelectedItem(), dogNames.getText(), 
    					(Gender)dogGenders.getSelectedItem(), (Integer)agesOfDog.getValue());
    		shelter.addAnimal(aDog);
    		updateDisplay();
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
    	breedsOfCat = new JComboBox<>(CatBreed.values());

    	JLabel name = new JLabel("<HTML><br/>Name</HTML>");
    	catNames = new JTextField(50);

    	JLabel gender = new JLabel("<HTML><br/>Gender</HTML>");
    	catGenders = new JComboBox<>(Gender.values());

    	JLabel age = new JLabel("<HTML><br/>Age</HTML>");
    	SpinnerModel ageRange = new SpinnerNumberModel(0, 0, 50, 1);
    	agesOfCat = new JSpinner(ageRange);

    	Object[] objects = {breed, breedsOfCat, name, catNames, gender, catGenders, age, agesOfCat};

    	int button = JOptionPane.showConfirmDialog(this, objects, "New Cat", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    	if(button == JOptionPane.OK_OPTION){
    		Cat aCat = new Cat((CatBreed)breedsOfCat.getSelectedItem(), catNames.getText(), 
    					(Gender)catGenders.getSelectedItem(), (Integer)agesOfCat.getValue());
    		shelter.addAnimal(aCat);
    		updateDisplay();
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
    	+ "<p>https://images.ctfassets.net/82d3r48zq721/45liwTLsDMSJt4N22RqrHX/</p><p>"
    	+ "cd992f88ca8737f95b085212906d6d86/Can-cats-and-dogs-get-</p><p>coronavirus_resized.jpg?w=800&h=542&q=50&fm=webp</p>"
    	+ "<p>https://encrypted-tbn0.gstatic.com/images?q=tbn</p><p>:ANd9GcR4rOgZhbSxMluMDlzbgxfuss7FloRKP1N3fQ&usqp=CAU</p>"
    	);

    	about.add(artists);

    	JButton ok = new JButton("OK");
    	ok.addActionListener(event -> about.setVisible(false));
    	about.add(ok);
        
    	about.setSize(700,500);
    	about.setVisible(true);
    }

    public void onNewShelterClick(){
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 200);

    	JTextField shelterName;
    	JLabel name = new JLabel("<HTML><br/>Name</HTML>");
    	shelterName = new JTextField(50);

    	Object[] objects = {name, shelterName};

    	int button = JOptionPane.showConfirmDialog(this, objects, "New Shelter", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    	shelter = new Shelter(shelterName.getText());
    }

    private void updateDisplay(){
    	data.setText("<html>" + shelter.toString()
    									.replaceAll("<", "&lt;")
    									.replaceAll(">", "&gt;")
    									.replaceAll("\n", "<br/>")
    							+ "</html>");
    }

    public void onSaveShelterClick() {
    	try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(MAGIC_COOKIE + '\n');
            bw.write(FILE_VERSION + '\n');

            shelter.save(bw);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to open " + filename + '\n' + e,
                "Failed", JOptionPane.ERROR_MESSAGE); 
        }
    }

	public void onOpenShelterClick() {
        final JFileChooser fc = new JFileChooser(filename);
        FileFilter massFiles = new FileNameExtensionFilter("Mass files", "mass");
        fc.addChoosableFileFilter(massFiles);         
        fc.setFileFilter(massFiles);
        
        int result = fc.showOpenDialog(this);        
        if (result == JFileChooser.APPROVE_OPTION) {
            filename = fc.getSelectedFile();        
            
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String magicCookie = br.readLine();
                if(!magicCookie.equals(MAGIC_COOKIE)) throw new RuntimeException("Not a Mass file");
                String fileVersion = br.readLine();
                if(!fileVersion.equals(FILE_VERSION)) throw new RuntimeException("Incompatible Mass file format");
                
                shelter = new Shelter(br);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Unable to open " + filename + '\n' + e, 
                    "Failed", JOptionPane.ERROR_MESSAGE); 
             }
        }
    }

    public void onSaveShelterAsClick() {         
        final JFileChooser fc = new JFileChooser(filename); 
        FileFilter massFiles = new FileNameExtensionFilter("Mass files", "mass");
        fc.addChoosableFileFilter(massFiles);
        fc.setFileFilter(massFiles);       
        
        int result = fc.showSaveDialog(this);        
        if (result == JFileChooser.APPROVE_OPTION) { 
            filename = fc.getSelectedFile();
            if(!filename.getAbsolutePath().endsWith(".mass"))
                filename = new File(filename.getAbsolutePath() + ".mass");
            onSaveShelterClick();
        }
    }

	public static void main(String[] args) {
    	MainWin aWindow = new MainWin("Mavs Animal Shelter");
    }
}