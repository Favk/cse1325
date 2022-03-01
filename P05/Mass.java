import shelter.Dog;
import shelter.Cat;
import shelter.Shelter;
import shelter.DogBreed;
import shelter.CatBreed;
import shelter.Gender;

import java.util.Scanner;
import java.util.ArrayList;

public class Mass {
	public static void main(String[] args) {
		String name;
		String breed;
		String gender;
		String ShelterName = "Arlington Loves Animal Companions";
		int age;

		Shelter shelter = new Shelter(ShelterName);

		Scanner in = new Scanner(System.in);

		System.out.print("Enter name of dog: ");
		name = in.nextLine();

		System.out.print("Enter a breed of dog from one of the following: Dalmatian, Greyhound, Chihuahua, Boxer, Husky, Samoyed, Dobermann, Rottweiler, Corgi, Schnauzer: ");
		breed = in.nextLine();
		DogBreed breedOfAnimal = DogBreed.valueOf(breed);

		System.out.print("Enter gender: ");
		gender = in.nextLine();
		Gender genderOfAnimal = Gender.valueOf(gender);

		System.out.print("Enter age of dog: ");
		age = in.nextInt(); in.nextLine();

		Dog aDog = new Dog(breedOfAnimal, name, genderOfAnimal, age);
		aDog.toString();
		System.out.println(aDog);

		System.out.print("\nEnter name of cat: ");
		name = in.nextLine();

		System.out.print("Enter a breed of cat from one of the following: Persian, Bengal, Siamese, Sphynx, Ragamuffin, Toyger, LaPerm, Peterbald, Savannah, Ragdoll: ");
		breed = in.nextLine();
		CatBreed breedOfCat = CatBreed.valueOf(breed);

		System.out.print("Enter gender: ");
		gender = in.nextLine();
		Gender catGender = Gender.valueOf(gender);

		System.out.print("Enter age of cat: ");
		age = in.nextInt(); in.nextLine();

		Cat aCat = new Cat(breedOfCat, name, catGender, age);
		aCat.toString();
		System.out.println(aCat);


	}
}