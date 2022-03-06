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

import java.util.Scanner;


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
            BufferedImage myPicture = ImageIO.read(new File("Animal_Shelter.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            about.add(logo);
        } catch(IOException e) {
        }
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>MASS</font></p>"
          + "</html>");
        about.add(title);

        JLabel artists = new JLabel("<html>"
          + "<p>Version 1.0J</p>"
          + "<p>Copyright 2022 by Kolade Favour</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "<p><font size=-2>https://www.google.com/imgres?imgurl=https%3A%2F%2Fpost.medicalnewstoday.com%2Fwp-content%2Fuploads%2Fsites%2F3%2F2020%2F02%2F322868_1100-800x825.jpg&imgrefurl=https%3A%2F%2Fwww.medicalnewstoday.com%2Farticles%2F322868&tbnid=SMMlmWDadP14fM&vet=12ahUKEwi245j6z7D2AhVHJM0KHRJ9Cp4QMygGegUIARDeAQ..i&docid=_RVRngRfeprTTM&w=800&h=825&q=dogs&client=ubuntu&ved=2ahUKEwi245j6z7D2AhVHJM0KHRJ9Cp4QMygGegUIARDeAQ</font></p>"
          + "<p>https://en.wikipedia.org/wiki/Van_cat</p>"
          + "<p><font size=-2>https://www.google.com/imgres?imgurl=https%3A%2F%2Fd.newsweek.com%2Fen%2Ffull%2F1840973%2Ffile-photo-dog-cat.jpg%3Fw%3D790%26f%3Df6bc3d7ae7ee9ed13dc05b42ecf15fe3&imgrefurl=https%3A%2F%2Fwww.newsweek.com%2Fdogs-cats-living-together-how-introduce-pets-1607979&tbnid=m420tMU_KvHB9M&vet=12ahUKEwiB9fnx0LD2AhWWm2oFHaiPA7QQMygNegUIARDaAQ..i&docid=Rut0II36c6XNlM&w=790&h=527&q=dogs%20and%20cats%20living%20together&client=ubuntu&ved=2ahUKEwiB9fnx0LD2AhWWm2oFHaiPA7QQMygNegUIARDaAQ</font></p>"
          + "</html>");
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