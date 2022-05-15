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

    private static final String cat = (new Cat()).family();
    private static final String dog = (new Dog()).family();
    private static final String rabbit  = (new Rabbit()).family();

    public Shelter(String name) {
        this.name = name;
        this.filename = "Untitled.mass";
        animals = new ArrayList<>();
        clients = new ArrayList<>();
        adoptions = new HashMap<>();
    }
    public String getName() {
        return name;
    }
    
    private Animal readAnimal(BufferedReader br) throws IOException {
        String f = br.readLine();
        if(f.equals(cat)) return new Cat(br);
        else if(f.equals(dog)) return new Dog(br);
        else if(f.equals(rabbit)) return new Rabbit(br);
        else throw new IOException("Invalid family: " + f);
    }
    private void writeAnimal(BufferedWriter bw, Animal a) throws IOException {
        bw.write(a.family() + '\n');
        a.save(bw);
    }

    public Shelter(BufferedReader br) throws IOException{
        this(br.readLine());

        int numAnimals = Integer.parseInt(br.readLine());
        while(numAnimals-- > 0) {
            animals.add(readAnimal(br));
        }

        int numClients = Integer.parseInt(br.readLine());
        while(numClients-- > 0) {
            clients.add(new Client(br));
        }

        int numAdoptions = Integer.parseInt(br.readLine());
        while(numAdoptions-- > 0) {
            Animal a = readAnimal(br);
            int index = Integer.parseInt(br.readLine());
            adoptions.put(a, clients.get(index));
        }
    }

    public void save(BufferedWriter bw) throws IOException{
        bw.write("" + name + '\n');

        bw.write("" + animals.size() + '\n');
        for(Animal a : animals) writeAnimal(bw, a);

        bw.write("" + clients.size() + '\n');
        for(Client c : clients) c.save(bw);

        bw.write("" + adoptions.size() + '\n');
        for(Animal a : adoptions.keySet()) {
            writeAnimal(bw, a);
            int index = clients.indexOf(adoptions.get(a));
            if(index < 0 || index >= clients.size()) 
                throw new ArrayIndexOutOfBoundsException(
                    "Adoptive client not registered");
            bw.write(index + "\n");
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

    public int numClient(){
        return clients.size();
    }

    public ListIterator<Client> clientListIterator(){
        return clients.listIterator();
    }

    public String clientsToString(){
        StringBuilder person = new StringBuilder();

        boolean first = true;
        for(Client c : clients) {
            person.append((first ? "" : "\n") + c);
            first = false;
        }
        return person.toString();
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public ListIterator<Animal> animalListIterator(){
        return animals.listIterator();
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();

        boolean first = true;
        for(Animal a : animals) {
            str.append((first ? "" : "\n") + a);
            first = false;
        }
        return str.toString();
    }

    public void adopt(Animal animal, Client client){
        if(adoptions.containsKey(animal)) 
            throw new IllegalArgumentException("Already adopted: " + animal);
        if(!animals.contains(animal)) 
            throw new IllegalArgumentException("Not available for adoption: " + animal);
        if(!clients.contains(client)) 
            throw new IllegalArgumentException("Not a shelter client: " + client);
        adoptions.put(animal, client);
        animals.remove(animal);
    }

    Iterator<Animal> adoptedAnimalListIterator(){
        return adoptions.keySet().iterator();
    }

    Client getAdoptedClient(Animal animal){
        return adoptions.get(animal);
    }

    public String adoptionsToString(){
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Animal a : adoptions.keySet()) {
            result.append((first ? "" : "\n") + a + " to " + adoptions.get(a));
            first = false;
        }
        return result.toString();
    }
}