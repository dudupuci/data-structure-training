package io.github.com.dudupuci.structure.data;

import io.github.com.dudupuci.structure.data.entities.Child;
import io.github.com.dudupuci.structure.data.utils.NameGenerator;

import java.util.*;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        LinkedList<Child> children = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantas criancas vão brincar?");
        int childrenSize = scanner.nextInt();

        for (int i = 0; i <= childrenSize; i++) {
            children.add(new Child(NameGenerator.generate()));
        }


        var chosenChild = chooseChildToSpeak(children);
        System.out.println("A crianca que vai gritar é a " + chosenChild.getName() + ", ele não vai brincar, só gritar!");
        children.remove(chosenChild);

        var playing = children.stream().map(Child::getName).toList();
        System.out.println("Quem está jogando é " + playing);

        Iterator<Child> iterator = children.iterator();

        while (children.size() > 1) {
            while (iterator.hasNext()) {
                Child currentChild = iterator.next();
                System.out.println(chosenChild.getName() + " diz " + chosenChild.talkHotPotato());
                Thread.sleep(500);

                if (isHotPotatoBurned()) {
                    System.out.println(chosenChild.burn(currentChild));
                    iterator.remove();
                }
            }
            iterator = children.iterator();
        }

        System.out.println("---------------------");
        System.out.println("Winner: " + children.getFirst());
        System.out.println("---------------------");
    }

    private static Child chooseChildToSpeak(LinkedList<Child> children) {
        var random = new Random();
        var index = random.nextInt(children.size());
        return children.get(index);
    }

    private static boolean isHotPotatoBurned() {
        return Math.random() < 0.5;
    }
}
