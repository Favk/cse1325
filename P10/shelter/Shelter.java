package shelter;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Shelter{
    private String name;
    private String filename;
    ArrayList<Animal> animals = new ArrayList<Animal>();
    ArrayList<Client> clients = new ArrayList<Client>();

    public Shelter(String name){
        this.name = name;
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public void addClient(Client client){
        clients.add(client);
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
        this(br.readLine());

        String familyName;
        filename = br.readLine();
        for(Animal a : animals){
            familyName = br.readLine();
            if(familyName == "dog"){
                addAnimal(new Dog(br));
            }
            if(familyName == "cat"){
                addAnimal(new Cat(br));
            }
            if(familyName == "rabbit"){
                addAnimal(new Rabbit(br));
            }
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

    public String clientsToString(){
        StringBuilder person = new StringBuilder();

        for(Client c : clients){
            person.append("\n");
            person.append(c.toString());
        }
        return person.toString();
    }

    public String getFilename(){
        return filename;
    }

    public void setFilename(String filename){
        this.filename = filename;
    }
}