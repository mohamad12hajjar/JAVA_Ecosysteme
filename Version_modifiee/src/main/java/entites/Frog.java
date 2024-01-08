package entites;

/**
 * La classe <code>Frog</code> représente une grenouille qui peut manger des insectes, grandir et évoluer.
 * Elle hérite de la classe <code>Eaters</code> et implémente les interfaces <code>Growing</code> et <code>Eating</code>.
 */
public class Frog extends Eaters implements Growing, Eating {

    /** Indique si la grenouille est une grenouillette (âge entre 1 et 7 mois). */
    private boolean isFroglet;

    /** Le score de la grenouille. */
    public int Score;

    /** L'espèce de la grenouille (statique partagé par toutes les instances de la classe). */
    private static String species = "Rare Pepe";

    /** Indique si la grenouille est morte. */
    private boolean dead;

    /**
     * Constructeur de la classe <code>Frog</code> avec le nom, l'âge et la vitesse de la langue spécifiés.
     *
     * @param name        Le nom de la grenouille.
     * @param age         L'âge de la grenouille en mois.
     * @param tongueSpeed La vitesse de la langue de la grenouille.
     */
    public Frog(String name, int age, double tongueSpeed) {
        super(name, age, tongueSpeed);
        this.dead = false;
        FrogletStatus();
    }

    /**
     * Constructeur de la classe <code>Frog</code> avec le nom, l'âge en années et la vitesse de la langue spécifiés.
     *
     * @param name        Le nom de la grenouille.
     * @param ageInYears  L'âge de la grenouille en années.
     * @param tongueSpeed La vitesse de la langue de la grenouille.
     */
    public Frog(String name, double ageInYears, double tongueSpeed) {
        super(name, ageInYears, tongueSpeed);
        FrogletStatus();
    }

    /**
     * Constructeur de la classe <code>Frog</code> avec seulement le nom.
     *
     * @param name Le nom de la grenouille.
     */
    public Frog(String name) {
        super(name);
        FrogletStatus();
    }

    /**
     * Met à jour le statut de grenouillette en fonction de l'âge de la grenouille.
     */
    private void FrogletStatus() {
        isFroglet = getAge() > 1 && getAge() < 7;
    }

    /**
     * Fait grandir la grenouille en ajoutant des mois à son âge.
     * La vitesse de la langue augmente en fonction de l'âge.
     */
    public void grow(int months) {
        int old = getAge();
        setAge(getAge() + months);

        if (getAge() <= 12) {
            setTongueSpeed(getTongueSpeed() + months);
        } else if (getAge() < 30) {
            if (old < 12) {
                setTongueSpeed(getTongueSpeed() + (12 - old));
            }
        } else {
            setTongueSpeed(getTongueSpeed() - (getAge() - 30));
            if (getTongueSpeed() < 5) {
                setTongueSpeed(5);
            }
        }

        FrogletStatus();
    }

    /**
     * Fait grandir la grenouille en ajoutant un mois à son âge (méthode équivalente à grow(1)).
     */
    public void grow() {
        grow(1);
    }

    /**
     * Méthode de l'interface <code>Eating</code> qui permet à la grenouille de manger un insecte.
     * Les règles spécifiques à la grenouille pour manger différents types d'insectes sont définies ici.
     *
     * @param insect L'insecte à manger.
     */
    public void eat(Insect insect) {
        if (!insect.isDead()) {
            if (getTongueSpeed() > insect.getSpeed() && insect.getMass() >= 0.5 * getAge()) {
                this.grow();
                insect.setMass(0);

                if (insect instanceof Abeille) {
                    System.out.println("Game Over: Une abeille a piqué la grenouille. Elle est morte");
                    System.out.println("your score is:" + this.Score);
                    System.exit(0);
                    //this.dead = true;
                } else if (insect instanceof Moustique) {
                    if (((Moustique) insect).bites) {
                        System.out.println("Game Over: Une moustique piquante a piqué la grenouille. Elle est morte");
                        System.out.println("your score is:" + this.Score);
                        System.exit(0);
                        //this.dead = true;
                    } else {
                        this.Score += 10;
                    }
                } else if (insect instanceof Papillon) {
                    this.Score -= 5;
                    System.out.println("Oups! J'ai mangé un papillon");
                    System.out.println("your score now is:" + this.Score);
                } else if (insect instanceof Fly) {
                    this.Score += 10;
                    System.out.println("your score now is:" + this.Score);
                } else if (insect instanceof Moustique) {
                    if (!((Moustique) insect).bites) {
                        this.Score += 10;
                        System.out.println("your score now is:" + this.Score);
                    }
                }
            } else {
                insect.grow(1);
            }
        }
    }

    /**
     * Renvoie une représentation textuelle de la grenouille.
     *
     * @return Une chaîne de caractères décrivant l'état de la grenouille.
     */
    public String toString() {
        if (isFroglet) {
            return "My name is " + getName() + " and I'm a rare froglet! I'm " + getAge() + " months old, and my tongue has a speed of " + getTongueSpeed();
        } else {
            return "My name is " + getName() + " and I'm a rare frog. I'm " + getAge() + " months old, and my tongue has a speed of " + getTongueSpeed();
        }
    }

    /**
     * Définit la nouvelle espèce de grenouille.
     *
     * @param newSpecies La nouvelle espèce de grenouille.
     */
    public static void setSpecies(String newSpecies) {
        species = newSpecies;
    }

    /**
     * Obtient l'espèce de grenouille.
     *
     * @return L'espèce de grenouille.
     */
    public static String getSpecies() {
        return species;
    }
}
