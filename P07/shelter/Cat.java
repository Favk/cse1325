package shelter;

import shelter.CatBreed;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Cat extends Animal{
    private CatBreed breed;
    private String catFamily = "Cat";

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
        catFamily = br.readLine();
        breed = CatBreed.valueOf(br.readLine());
    }

    public void save(BufferedWriter bw) throws IOException {  
        bw.write("" + catFamily + '\n');  
        bw.write("" + name + '\n');
        bw.write("" + gender.name() + '\n');
        bw.write("" + age + '\n');
        bw.write("" + breed.name() + '\n');
    }

    @Override
    public String toString(){
        return name + " is a " + gender + " " + breed() + " " + family() + " and is " + age + " years old";
    }
}