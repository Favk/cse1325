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

    @Override
    public String family(){
        return "cat";
    }
    
    @Override
    public String breed(){
        return breed.toString();
    }

    public Cat(BufferedReader br) throws IOException{
        super(br);
        breed = CatBreed.valueOf(br.readLine());
    }

    @Override
    public String toString(){
        return name + " is a " + gender + " " + family() + " and is " + age + " years old";
    }
}