package Jeu;

import entites.*;

public class Pond {
    public static void main(String[] args) {
        Frog frog = new Frog("freddy", 5, 10);
        Fly fly1 = new Fly(10, 10);
        Fly fly2 = new Fly(6, 4);
        Fly fly3 = new Fly(10, 3);
        Abeille abeille = new Abeille(6, 1, 1);
        Abeille abeille2 = new Abeille(10, 1, 1);
        Moustique moustique = new Moustique(3, 1, true);
        Papillon papillon = new Papillon(6, 1, "red");
        Papillon papillon2 = new Papillon(10, 1, "kk");
        frog.setSpecies("331 Frogs");
        System.out.println(frog.getSpecies());
        System.out.println(frog.toString());
        frog.eat(fly1);
        frog.eat(papillon2);

        frog.eat(fly2);
        frog.eat(fly3);
        System.out.println(fly1.toString());
        System.out.println(fly2.toString());
        System.out.println(fly3.toString());
        frog.eat(papillon);
        frog.eat(moustique);
        frog.grow(8);
        System.out.println(frog.toString());
        frog.eat(abeille2);

    }}