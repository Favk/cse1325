import shelter.Shelter;
import shelter.Animal;
import shelter.Dog;
import shelter.DogBreed;
import shelter.Cat;
import shelter.CatBreed;
import shelter.Gender;

import java.util.Scanner;

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
		setSize(1200, 900);

		JMenuBar menuBar = new JMenuBar();

		JMenu file = new JMenu("File");
		JMenuItem quit = new JMenuItem("Quit: Exit Shelter");		
		
		JMenu newFile = new JMenu("New Animal");
		JMenuItem dog = new JMenuItem("New Dog");
		JMenuItem cat = new JMenuItem("New Cat");

		JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");

		quit .addActionListener(event -> onQuitClick());
		about.addActionListener(event -> onAboutClick());

		file.add(quit);

		newFile.add(dog);
		newFile.add(cat);

		help.add(about);

		menuBar.add(file);
		menuBar.add(newFile);
		menuBar.add(help);

		JToolBar toolbar = new JToolBar("Shelter Management");

		toolbar.add(Box.createHorizontalStrut(25));

		JButton button1 = new JButton(new ImageIcon("Dog.png"));
		button1.setActionCommand("New Dog");
		button1.setToolTipText("Enter a new dog");
		toolbar.add(button1);
		button1.addActionListener(event -> onNewDogClick());

		JButton button2 = new JButton(new ImageIcon("Cat.png"));
		button2.setActionCommand("New Cat");
		button2.setToolTipText("Enter a new cat");
		toolbar.add(button2);
		//button2.addActionListener(event -> onNewCatClick());

		toolbar.add(Box.createHorizontalStrut(25));
		
		setJMenuBar(menuBar);
		setVisible(true);
	}

	protected void onQuitClick() {
		System.exit(0);
	} 

	protected void onNewDogClick() {
        try {
            for(DogBreed b : DogBreed.values())
            	System.out.println(b.name());
                getAnimals("dog");

                shelter.addAnimal(
                	new Dog(DogBreed.valueOf(breed), name, gender, age)
                );
        } catch(Exception e) {
            System.err.println("Invalid input: " + e.getMessage());
        }
    }

    Shelter shelter = new Shelter("Mavs Animal Shelter");

    protected String breed;
    protected String name;
    protected Gender gender;
    protected int age;

    Scanner in = new Scanner(System.in);
    protected void getAnimals(String family) {
        System.out.print("Select " + family + " breed: ");
        breed = in.nextLine();
        System.out.print(breed + "'s name? ");
        name = in.nextLine();
        for(Gender g : Gender.values())
            System.out.println(g.name());
        System.out.print("Select gender: ");
        gender = Gender.valueOf(in.nextLine());
        System.out.print("Age? ");
        age = in.nextInt(); in.nextLine();
    }


        protected void onAboutClick() {                 // Display About dialog
        JDialog about = new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("Mavs Animal Shelter");
        
        try {
            BufferedImage myPicture = ImageIO.read(new File("Animal_shelter.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            about.add(logo);
        } catch(IOException e) {
        }
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>Nim</font></p>"
          + "</html>");
        about.add(title);

        JLabel artists = new JLabel("<html>"
          + "<p>Version 1.3J</p>"
          + "<p>Copyright 2017-2020 by George F. Rice</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "<p>Logo by M0tty, licensed under CC BY-SA 3.0</p>"
          + "<p><font size=-2>https://commons.wikimedia.org/wiki/File:Pyramidal_matches.svg</font></p>"
          + "<p>Robot by FreePik.com, licensed for personal</p><p>and commercial purposes with attribution</p>"
          + "<p><font size=-2>https://www.freepik.com/free-vector/grey-robot-silhouettes_714902.htm</font></p>"
          + "</html>");
        about.add(artists);

        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);
        
        about.setSize(450,400);
        about.setVisible(true);
     }



}