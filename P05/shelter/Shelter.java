package shelter;

import java.util.ArrayList;

public class Shelter extends Animal{
	private String name;
	ArrayList<Animal> animals = new ArrayList<Animal>();

	public Shelter(String name){
		name = "Arlington Loves Animal Companions";
	}

	public void addAnimal(Animal animal){
		animals.add(animal);
	}

	@Override
	public String toString(){
		return aCat.toString() + "\n" + aDog.toString();
	}
}