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

import shelter.Animal;
import shelter.Dog;
import shelter.Cat;
import shelter.Rabbit;
import shelter.Shelter;
import shelter.Client;
import shelter.DogBreed;
import shelter.CatBreed;
import shelter.RabbitBreed;
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
    private enum DataView{ANIMALS, CLIENTS, ADOPTIONS};

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
		JMenuItem rabbit = new JMenuItem("New Rabbit");
		JMenuItem listAll = new JMenuItem("List animals");
		JMenuItem listAdopted = new JMenuItem("List adopted animals");

		JMenu client = new JMenu("Client");
		JMenuItem newClient = new JMenuItem("New Client");
		JMenuItem listClient = new JMenuItem("List all clients");
		JMenuItem adoptAnimal = new JMenuItem("Adopt animal");

		JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");

		quit.addActionListener(event -> onQuitClick());
		about.addActionListener(event -> onAboutClick());
		dog.addActionListener(event -> onNewDogClick());
		cat.addActionListener(event -> onNewCatClick());
		rabbit.addActionListener(event -> onNewRabbitClick());
		listAll.addActionListener(event -> updateDisplay(DataView.ANIMALS));
		listAdopted.addActionListener(event -> updateDisplay(DataView.ADOPTIONS));
		newClient.addActionListener(event -> onNewClientCLick());
		listClient.addActionListener(event -> updateDisplay(DataView.CLIENTS));
		newFile.addActionListener(event -> onNewShelterAsClick());
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
		animal.add(rabbit);
		animal.add(listAll);
		animal.add(listAdopted);

		client.add(newClient);
		client.add(listClient);
		client.add(adoptAnimal);

		help.add(about);

		menuBar.add(file);
		menuBar.add(animal);
		menuBar.add(client);
		menuBar.add(help);

		JToolBar toolbar = new JToolBar("Shelter Management");

		JButton anewB  = new JButton(new ImageIcon("new.jpg"));
        anewB.setActionCommand("New Shelter");
        anewB.setToolTipText("Create a new shelter, discarding any in progress");
        anewB.setBorder(null);
        toolbar.add(anewB);
        anewB.addActionListener(event -> onNewShelterAsClick());

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

    	toolbar.addSeparator();
    	toolbar.addSeparator();

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

    	JButton rabbitButton = new JButton(new ImageIcon("rabbit.jpg"));
    	rabbitButton.setActionCommand("Add a new rabbit");
    	rabbitButton.setToolTipText("Add a new rabbit, include name, age, breed and gender");
    	rabbitButton.setBorder(null);
    	toolbar.add(rabbitButton);
    	rabbitButton.addActionListener(event -> onNewRabbitClick());

    	toolbar.addSeparator();
    	toolbar.addSeparator();

    	JButton clientButton = new JButton(new ImageIcon("client.jpg"));
    	clientButton.setActionCommand("Add a new client");
    	clientButton.setToolTipText("Add a new client, include name and phone number");
    	clientButton.setBorder(null);
    	toolbar.add(clientButton);
    	clientButton.addActionListener(event -> onNewClientCLick());
    	
    	toolbar.addSeparator();

    	getContentPane().add(toolbar, BorderLayout.PAGE_START);
    	add(data, BorderLayout.CENTER);

		setJMenuBar(menuBar);
		setVisible(true);
	}

	public void onQuitClick() {
		System.exit(0);
	}
        
    protected void onNewDogClick() { 
        newAnimal(new Dog(),new JComboBox<>(DogBreed.values()));
    }
            
    protected void onNewCatClick() { 
        newAnimal(new Cat(), new JComboBox<>(CatBreed.values()));
    }

	public void onNewRabbitClick() {
        newAnimal(new Rabbit(), new JComboBox<>(RabbitBreed.values()));
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
    	+ "<p>Version 1.2</p>"
    	+ "<p>Copyright 2022 by Kolade Favour</p>"
    	+ "<p>Licensed under Gnu GPL 3.0</p>"
    	+ "<p>Derived from Professor George F.</p>"
    	+ "<p>Rice's MASS Suggested solution per the GPL License</p>"
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

    public void onNewShelterAsClick() {
        String name = JOptionPane.showInputDialog(
            this, 
            "Enter the new shelter's name", 
            "Shelter Name", 
            JOptionPane.QUESTION_MESSAGE);
        if(name != null && name.length() > 0) {
            onNewShelterClick(name);
            setTitle("MASS - " + name);
        }
    }

    public void onNewShelterClick(String name) {
        shelter = new Shelter(name);
        shelter.setFilename("Untitled.mass");
        updateDisplay(DataView.ANIMALS);
    }

    public void onNewClientCLick(){
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 900);

		JTextField clientName;
		JTextField clientNumber;

    	JLabel nameOfClient = new JLabel("<HTML><br/>Name</HTML>");
    	clientName = new JTextField(50);

    	JLabel number = new JLabel("<HTML><br/>Phone Number</HTML>");
    	clientNumber = new JTextField(50);

    	Object[] objects = {nameOfClient, clientName, number, clientNumber};

    	int button = JOptionPane.showConfirmDialog(this, objects, "New Client", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    	if(button == JOptionPane.OK_OPTION){
    		Client aClient = new Client(clientName.getText(), clientNumber.getText());
    		shelter.addClient(aClient);
    		updateDisplay(DataView.CLIENTS);
    	}
    }

    private void updateDisplay(DataView view){
    	String display = "Error: Invalid display option: " + view;

    	if (view == DataView.ANIMALS) {
    		display = shelter.toString();
    	}
    	if (view == DataView.CLIENTS) {
    		display = shelter.clientsToString();
    	}
    	if (view == DataView.ADOPTIONS) {
    		display = shelter.adoptionsToString();
    	}
    	data.setText("<html>" +  display.replaceAll("<", "&lt;")
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
                 updateDisplay(DataView.ANIMALS);
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


    private <T extends Animal> void newAnimal(T animal, JComboBox breeds){
    	JLabel breed = new JLabel("Breed");

		JLabel name = new JLabel("<HTML><br/>Name</HTML>");
	    JTextField names = new JTextField(50);
	        
	    JLabel gender = new JLabel("<HTML><br/>Gender</HTML>");
	    JComboBox genders = new JComboBox(Gender.values());
	        
	    JLabel age = new JLabel("<HTML><br/>Age</HTML>");
	    SpinnerModel range = new SpinnerNumberModel(0, 0, 100, 1);
	    JSpinner ages = new JSpinner(range);

	    Object[] objects = {breed, breeds, name, names, gender, genders, age, ages};
        
        int button = JOptionPane.showConfirmDialog(
            this,
            objects,
            "New Animal",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if(button == JOptionPane.OK_OPTION){
        	animal.create(breeds.getSelectedItem(), names.getText(), (Gender) genders.getSelectedItem(), (int) ages.getValue());
        	shelter.addAnimal(animal);
            updateDisplay(DataView.ANIMALS);
        }
    }

	public static void main(String[] args) {
    	MainWin aWindow = new MainWin("Mavs Animal Shelter");
    }
}