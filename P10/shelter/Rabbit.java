package shelter;

import shelter.RabbitBreed;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Rabbit extends Animal{
    private RabbitBreed breed;

    public Rabbit(RabbitBreed breed, String name, Gender gender, int age){
        super(name, gender, age);
        this.breed = breed;
    }

    public Rabbit(BufferedReader br) throws IOException{
        super(br);
        breed = RabbitBreed.valueOf(br.readLine());
    }

    public Rabbit() {}

    @Override
    public void save(BufferedWriter bw) throws IOException {  
        super.save(bw);
        bw.write("" + breed.name() + '\n');
    }

    @Override
    public void create(Object breed, String name, Gender gender, int age){
        super.create(breed, name, gender, age);
        this.breed = (RabbitBreed)breed;
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