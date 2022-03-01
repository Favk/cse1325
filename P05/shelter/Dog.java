package shelter;

import shelter.DogBreed;

public class Dog extends Animal{
	private DogBreed breed;

	public Dog(DogBreed breed, String name, Gender gender, int age){
		super(name, gender, age);
		this.breed = breed;
	}

	@Override
	public String family(){
		return "dog";
	}
	
	@Override
	public String breed(){
		return breed.toString();
	}

	@Override
	public String toString(){
		return name + " is a " + gender + " " + family() + " and is " + age + " years old";
	}
	
}