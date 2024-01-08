package entites;

/**
 * La classe <code>Fly</code> représente une mouche volante.
 * Elle hérite de la classe abstraite <code>Flying</code>.
 */
public class Fly extends Flying {

    /**
     * Constructeur de la classe <code>Fly</code> avec une masse et une vitesse spécifiées.
     *
     * @param mass  La masse de la mouche.
     * @param speed La vitesse de la mouche.
     */
    public Fly(double mass, double speed) {
        super(mass, speed);
    }

    /**
     * Constructeur de la classe <code>Fly</code> avec une masse spécifiée et une vitesse par défaut.
     *
     * @param mass La masse de la mouche.
     */
    public Fly(double mass) {
        super(mass, 10); // Vitesse par défaut de 10.
    }

    /**
     * Constructeur par défaut de la classe <code>Fly</code> avec une masse par défaut et une vitesse par défaut.
     */
    public Fly() {
        super(5, 10); // Masse par défaut de 5, vitesse par défaut de 10.
    }

    /**
     * Renvoie une représentation textuelle de la mouche.
     *
     * @return Une chaîne de caractères décrivant l'état de la mouche.
     */
    @Override
    public String toString() {
        if (getMass() == 0) {
            return "I’m dead, but I used to be a fly with a speed of " + getSpeed();
        } else {
            return "I’m a speedy fly with " + getSpeed() + " speed and " + getMass() + " mass.";
        }
    }
}
