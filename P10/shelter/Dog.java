package shelter;

import shelter.DogBreed;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Dog extends Animal{
    private DogBreed breed;
    private String dogFamily = "Dog";

    public Dog(DogBreed breed, String name, Gender gender, int age){
        super(name, gender, age);
        this.breed = breed;
    }

    @Override
    public String family(){
        return "dog";
    }
    
    @Override
    public String breed(){
        return breed.toString();
    }

    public Dog(BufferedReader br) throws IOException{
        super(br);
        dogFamily = br.readLine();
        breed = DogBreed.valueOf(br.readLine());
    }

    public void save(BufferedWriter bw) throws IOException {  
        bw.write("" + dogFamily + '\n');  
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