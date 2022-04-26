package shelter;

import shelter.CatBreed;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;

public class Cat extends Animal{
    private CatBreed breed;
    Cat cat;

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

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return (breed.equals(cat.breed) && (age == cat.age) && (gender.equals(cat.gender)) && (name.equals(cat.name)));
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 31 * hash + (cat == null ? 0 : cat.hashCode());
        return hash;
    }
}