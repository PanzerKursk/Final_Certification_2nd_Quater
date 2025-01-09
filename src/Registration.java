import java.util.ArrayList;

public class Registration {
    private ArrayList<Animals> animals = new ArrayList<>();

    public void initAnimals(ArrayList<Animals> animals){
        this.animals = animals;
    }

    public void listAnimals(){
        System.out.println("Список всех животных:");
        for (Animals a : animals){
            System.out.println(a);
        }
    }

    public Animals getAnimal(String name) {
        for (Animals a : animals){
            if (a.getName().equals(name)) {
                return a;
            }
        }
        return null;
    }

    public void addAnimal(Animals animal){
        animals.add(animal);
        System.out.println("Животное добавлено: " + animal.getName());
    }
}
