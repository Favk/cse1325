package shelter;

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

    @Override
    public String toString(){
        return name + " is a " + gender + " and is " + age + " years old";
    }
}