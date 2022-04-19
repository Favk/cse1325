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

    public Cat(){}

    @Override
    public void create(Object breed, String name, Gender gender, int age){
        super.create(breed, name, gender, age);
        this.breed = (CatBreed)breed;
    }

    @Override
    public void save(BufferedWriter bw) throws IOException {  
        super.save(bw);
        bw.write("" + breed.name() + '\n');
    }

    @Override
    public String family(){
        return "cat";
    }
    
    @Override
    public String breed(){
        return breed.toString();
    }

    @Override
    public String toString(){
        return name + " is a " + gender + " " + breed() + " " + family() + " and is " + age + " years old";
    }
}