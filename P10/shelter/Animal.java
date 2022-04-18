package shelter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

abstract class Animal{
    protected String name;
    protected Gender gender;
    protected int age = 0;

    public Animal(String name, Gender gender, int age){
        this.name = name;
        this.gender = gender;
        this.age = age;

        if(age <= 0){
            throw new IllegalArgumentException("Age cannot be negative " + age);
        }
    }

    public abstract String family();
    public abstract String breed();
    public abstract create(Object breed, Strign name, Gender gender, int age);

    public Animal(BufferedReader br) throws IOException{
        name = br.readLine();
        gender = Gender.valueOf(br.readLine());
        age = Integer.parseInt(br.readLine());
    }

    public void save(BufferedWriter bw) throws IOException {    
        bw.write("" + name + '\n');
        bw.write("" + gender.name() + '\n');
        bw.write("" + age + '\n');
    }

    @Override
    public String toString(){
        return name + " is a " + gender + " and is " + age + " years old";
    }
}