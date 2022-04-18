package shelter;

import shelter.RabbitBreed;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Rabbit extends Animal{
    private RabbitBreed breed;
    private String rabbitFamily = "Rabbit";

    public Rabbit(RabbitBreed breed, String name, Gender gender, int age){
        super(name, gender, age);
        this.breed = breed;
    }

    public Rabbit(BufferedReader br) throws IOException{
        super(br);
        breed = RabbitBreed.valueOf(br.readLine());
    }

    @Override
    public void save(BufferedWriter bw) throws IOException {  
        super.save(bw);
        bw.write("" + breed.name() + '\n');
    }

    @Override
    public String family(){
        return "Rabbit";
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