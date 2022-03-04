import shelter.Shelter;
import shelter.Animal;
import shelter.Dog;
import shelter.DogBreed;
import shelter.Cat;
import shelter.CatBreed;
import shelter.Gender;

import java.util.Scanner;

import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame{
	public MainWindow(String title){
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1600, 900);

		JMenuBar menuBar = new JMenuBar();

		JMenu file = new JMenu("File");
		JMenuItem adog = new JMenuItem("Add new Dog");
		JMenuItem acat = new JMenuItem("Add new Cat");

		JMenu quit = new JMenu("Quit");
		JMenuItem exit = new JMenuItem("Exit Shelter");
		
		JMenu newFile = new JMenu("New Animal");
		JMenuItem dog = new JMenuItem("New Dog");
		JMenuItem cat = new JMenuItem("New Cat");

		file.add(adog);
		file.add(acat);

		quit.add(exit);
		
		newFile.add(dog);
		newFile.add(cat);

		menuBar.add(file);
		menuBar.add(quit);
		menuBar.add(newFile);

		JToolBar toolbar = new JToolBar("Shelter Management");

		setJMenuBar(menuBar);
		setVisible(true);
	}
	public static void main(String[] args) {
		MainWindow aWindow = new MainWindow("Mavs Animal Shelter");
		aWindow.setVisible(true);
	}
}