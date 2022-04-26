package shelter;

import shelter.DogBreed;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;

public class Dog extends Animal {
    private DogBreed breed;
    Dog dog;

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

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return (breed.equals(dog.breed) && (age == dog.age) && (gender.equals(dog.gender)) && (name.equals(dog.name)));
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 31 * hash + (dog == null ? 0 : dog.hashCode());
        return hash;
    }
}