import models.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Parrot parrot = new Parrot("parrot", 10, "beautiful", 10);
        Eagle eagle = new Eagle("eagle", 100, "alone", 1000);        
        Girafe girafe = new Girafe("griafe", 20, "long",20);
        Cheetah cheetah = new Cheetah("cheetah", 5, "fastest",80);

        ArrayList<Animal> animals = new ArrayList<Animal>();

        animals.add(parrot);
        animals.add(eagle);
        animals.add(girafe);
        animals.add(cheetah);

        for (Animal animal: animals) {
            animal.show();
        }

	System.out.println();

        eagle.hunt(parrot);
        cheetah.hunt(girafe);
    }
}
