import shelter.Dog;
import shelter.Cat;
import shelter.Shelter;
import shelter.DogBreed;
import shelter.CatBreed;
import shelter.Gender;

import java.util.Scanner;

public class Mass {
    public static void main(String[] args) {
        new MainWin("Mavs Animal Shelter");
        String name;
        String breed;
        String gender;
        String ShelterName = "Mavs Animal Shelter";

        int age = 0;
        int entries = 0;

        Shelter shelter = new Shelter(ShelterName);

        Scanner in = new Scanner(System.in);
        do{
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
            entries++;
            aDog.toString();

            System.out.printf("\n");
            System.out.print("Enter name of cat: ");
            name = in.nextLine();

            System.out.print("Enter a breed of cat from one of the following: Persian, Bengal, Siamese, Sphynx, Ragamuffin, Toyger, LaPerm, Peterbald, Savannah, Ragdoll: ");
            breed = in.nextLine();
            CatBreed breedOfCat = CatBreed.valueOf(breed);

            System.out.print("Enter gender: ");
            gender = in.nextLine();
            Gender catGender = Gender.valueOf(gender);

            System.out.print("Enter age of cat: ");
            age = in.nextInt(); in.nextLine();

            System.out.printf("\n");
            
            Cat aCat = new Cat(breedOfCat, name, catGender, age);
            entries++;
            aCat.toString();

            shelter.addAnimal(aDog);
            shelter.addAnimal(aCat);

            shelter.toString();
        }
        while (entries < 4);

        System.out.println(shelter);
    }
}