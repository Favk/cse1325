import shelter.Dog;
import shelter.Cat;
import shelter.Shelter;

import java.util.Scanner;

public class Mass {
	public static void main(String[] args) {
		String name;
		String breed;
		String gender;
		int age;

		Scanner in = new Scanner(System.in);

		name = in.nextLine();
		System.out.println(name);

		breed = in.nextLine();
		DogBreed breed = DogBreed.valueOf(breed);

		gender = in.nextLine();
		Gender gender = Gender.valueOf(gender);

		age = in.nextInt(); in.nextLine();

		Dog aDog = new Dog(breed, name, gender, age);
		aDog.toString();

	}
}