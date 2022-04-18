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

    public Dog(BufferedReader br) throws IOException{
        super(br);
        breed = DogBreed.valueOf(br.readLine());
    }

    @Override
    public void save(BufferedWriter bw) throws IOException {  
        super.save(bw); 
        bw.write("" + breed.name() + '\n');
    }

    @Override
    public String family(){
        return "dog";
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