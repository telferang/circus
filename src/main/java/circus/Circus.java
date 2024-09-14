package circus;

import circus.animal.*;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

import static circus.animal.Animal.AnimalNameComparator;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("Number of animals in array are: " + animals.length);
        ArrayList<Animal> animalsArrayList = new ArrayList(Arrays.asList(animals));

        printAllAnimals(animalsArrayList);
        printNumberOfAnimalsInCircus(animalsArrayList);

        Elephant strongOne = new Elephant("Strong One");
        animalsArrayList.add(strongOne);
        Duck andy = new Duck("Andy");
        animalsArrayList.add(andy);

        System.out.println("Before sorting: ");
        printAllAnimals(animalsArrayList);
        System.out.println("Size of our animal array list: " + animalsArrayList.size());

        System.out.println("The position of Strong One is : " + (animalsArrayList.indexOf(strongOne) + 1));
        animalsArrayList.sort(AnimalNameComparator);
        System.out.println("After sorting: ");
        printAllAnimals(animalsArrayList);
//        makeAnimalsTalk();
//        System.out.println("Total value of animals " + calculateAssetValue(animals));
//        System.out.println("Total value of equipments " + calculateAssetValue(equipments));
    }

    private static void printNumberOfAnimalsInCircus(ArrayList<Animal> animalsArrayList) {
        System.out.println("Size of our animal array list: " + animalsArrayList.size());
    }

    private static void printAllAnimals(ArrayList<Animal> animalsArrayList) {
        for (Animal a : animalsArrayList) {
            System.out.println(a);
        }
    }
}
