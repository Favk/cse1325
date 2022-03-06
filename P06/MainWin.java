import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;

public class MainWin extends JFrame {// implements ActionListener {
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
		JMenuItem listAll = new JMenuItem("List available animals");

		JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");

		quit.addActionListener(event -> onQuitClick());
		about.addActionListener(event -> onAboutClick());
		
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

		JButton catButton = new JButton(new ImageIcon("cat.png"));
    	catButton.setActionCommand("Add a new cat");
    	catButton.setToolTipText("Add a new cat, include name, age, breed and gender");
    	catButton.setBorder(null);
    	toolbar.add(catButton);

    	getContentPane().add(toolbar, BorderLayout.PAGE_START);

		setJMenuBar(menuBar);
		setVisible(true);
	}

	protected void onQuitClick() {
		System.exit(0);
	}

	protected void onAboutClick() {                 // Display About dialog
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