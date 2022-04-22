package shelter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Dog extends Animal {
    private DogBreed breed;

    public Dog() {
        this(DogBreed.Mix, "Default", Gender.Female, 0);
    }

    public Dog(DogBreed breed, String name, Gender gender, int age) {
        super(name, gender, age);
        this.breed = breed;
    }

    public Dog(BufferedReader br) throws IOException {
        super(br);
        breed = DogBreed.valueOf(br.readLine());
    }

    @Override
    public void create(Object breeds, String name, Gender gender, int age){        
        this.breed = (DogBreed) breeds; 
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);
        bw.write(breed.name() + '\n');
    }

    @Override
    public String family() {
        return "dog";
    }

    @Override
    public String breed() {
        return breed.toString();
    }

    @Override
    public String toString() {
        return super.toString() + " " + breed() + " dog)";
    }
}