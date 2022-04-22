package shelter;

import shelter.CatBreed;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Cat extends Animal{
    private CatBreed breed;

    public Cat(CatBreed breed, String name, Gender gender, int age){
        super(name, gender, age);
        this.breed = breed;
    }

    public Cat(BufferedReader br) throws IOException{
        super(br);
        breed = CatBreed.valueOf(br.readLine());
    }

    public Cat(){
        this(CatBreed.Mix, "Default", Gender.Female, 0);
    }

    @Override
    public void create(Object breed, String name, Gender gender, int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.breed = (CatBreed)breed;
    }

    @Override
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);
        bw.write(breed.name() + '\n');
    }

    @Override
    public String family() {
        return "cat";
    }

    @Override
    public String breed() {
        return breed.name();
    }

    @Override
    public String toString() {
        return super.toString() + " " + breed.name() + " cat)";
    }
}