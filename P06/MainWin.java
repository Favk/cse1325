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

		quit .addActionListener(event -> onQuitClick());

		file.add(quit);

		animal.add(dog);
		animal.add(cat);
		animal.add(listAll);

		help.add(about);

		menuBar.add(file);
		menuBar.add(animal);
		menuBar.add(help);

        JToolBar toolbar = new JToolBar("Shelter Management");

        JButton anewB  = new JButton(new ImageIcon("Animal_Shelter.png"));
        anewB.setActionCommand("Add a new animal");
        anewB.setToolTipText("Add a new animal, discarding any in progress");
        anewB.setBorder(null);
        toolbar.add(anewB);
        //anewB.addActionListener(event -> onNewGameClick());

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

	public static void main(String[] args) {
    	MainWin aWindow = new MainWin("Mavs Animal Shelter");
    	aWindow.setVisible(true);
    }
}