package shelter;

import shelter.RabbitBreed;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;

public class Rabbit extends Animal{
    private RabbitBreed breed;
    Rabbit rabbit;

    public Rabbit(RabbitBreed breed, String name, Gender gender, int age){
        super(name, gender, age);
        this.breed = breed;
    }

    public Rabbit(BufferedReader br) throws IOException{
        super(br);
        breed = RabbitBreed.valueOf(br.readLine());
    }

    public Rabbit(){
        this(RabbitBreed.Mix, "Default", Gender.Female, 0);
    }

    @Override
    public void create(Object breed, String name, Gender gender, int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.breed = (RabbitBreed)breed;
    }

    @Override
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);
        bw.write(breed.name() + '\n');
    }

    @Override
    public String family() {
        return "rabbit";
    }

    @Override
    public String breed() {
        return breed.name();
    }

    @Override
    public String toString() {
        return super.toString() + " " + breed.name() + " rabbit)";
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        Rabbit rabbit = (Rabbit) o;
        return (breed.equals(rabbit.breed) && (age == rabbit.age) && (gender.equals(rabbit.gender)) && (name.equals(rabbit.name)));
    }

    @Override
    public int hashCode(){
        int hash = 7;
        hash = 31 * hash + (rabbit == null ? 0 : rabbit.hashCode());
        return hash;
    }
}