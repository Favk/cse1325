package shelter;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Shelter{
    private String name;
    private Animal animal;
    ArrayList<Animal> animals = new ArrayList<Animal>();

    public Shelter(String name){
        this.name = name;
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public int numAnimals(){
        return animals.size();
    }

    public Animal getAnimal(int index){
        if(index < 0){
            throw new IllegalArgumentException("Index cannot be negative " + index);
        }

        return animals.get(index);
    }

    public Shelter(BufferedReader br) throws IOException{
        for(Animal a : animals){
            animal = Animal(br);
        }
    }

    public void save(BufferedWriter bw) throws IOException{
        bw.write("" + name + '\n');
        bw.write("" + numAnimals() + '\n');

        for(Animal a : animals){
            a.save(bw);
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();

        for(Animal a : animals){
            str.append("\n");
            str.append(a.toString());
        }
        return str.toString();
    }
}