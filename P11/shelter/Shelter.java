package shelter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Iterator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Shelter{
    private String name;
    private String filename;
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private ArrayList<Client> clients = new ArrayList<Client>();
    private HashMap<Animal, Client> adoptions = new HashMap<Animal, Client>();

    Animal animal;
    Client client;

    public Shelter(String name){
        this.name = name;
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

    public String getFilename(){
        return filename;
    }

    public void setFilename(String filename){
        this.filename = filename;
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public ListIterator<Client> clientListIterator(){
        return clients.listIterator();
    }

    public String clientsToString(){
        StringBuilder person = new StringBuilder();

        for(Client c : clients){
            person.append("\n");
            person.append(c.toString());
        }
        return person.toString();
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public ListIterator<Animal> AnimalListIterator(){
        return animals.listIterator();
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

    public int numAnimals(){
        return animals.size();
    }

    public Animal getAnimal(int index){
        if(index < 0){
            throw new IllegalArgumentException("Index cannot be negative " + index);
        }

        return animals.get(index);
    }

    public void adopt(Animal animal, Client client){
        animals.remove(animal.getAnimal(index));
    }

    public Iterator<Animal> adoptedAnimalListIterator(){
        return adoptions.keySet().iterator();
    }

    public String adoptionsToString(){
        return animal.toString() + " to " + client.clientsToString();
    }


}