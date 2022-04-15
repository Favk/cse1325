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

    @Override
    public String family(){
        return "Rabbit";
    }
    
    @Override
    public String breed(){
        return breed.toString();
    }

    public Rabbit(BufferedReader br) throws IOException{
        super(br);
        rabbitFamily = br.readLine();
        breed = RabbitBreed.valueOf(br.readLine());
    }

    public void save(BufferedWriter bw) throws IOException {  
        bw.write("" + rabbitFamily + '\n');  
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