package entites;

/**
 * La classe <code>Moustique</code> représente un moustique volant avec la capacité de piquer.
 * Elle hérite de la classe <code>Flying</code>.
 */
public class Moustique extends Flying {

    /** Indique si le moustique pique ou non. */
    public boolean bites;

    /**
     * Constructeur de la classe <code>Moustique</code> avec une masse, une vitesse et l'information de piqûre spécifiées.
     *
     * @param mass  La masse du moustique.
     * @param speed La vitesse du moustique.
     * @param bites Indique si le moustique pique.
     */
    public Moustique(double mass, double speed, boolean bites) {
        super(mass, speed);
        this.bites = bites;
    }

    /**
     * Renvoie une représentation textuelle du moustique.
     *
     * @return Une chaîne de caractères décrivant l'état du moustique.
     */
    @Override
    public String toString() {
        if (getMass() == 0) {
            return "I’m dead, but I used to be a mosquito with a speed of " + getSpeed();
        } else {
            return "I’m a speedy mosquito with " + getSpeed() + " speed and " + getMass() + " mass.";
        }
    }

    /**
     * Effectue une piqûre si le moustique est capable de piquer.
     */
    public void doBite() {
        if (bites) {
            System.out.println("Ouch! The mosquito is biting.");
        } else {
            System.out.println("The mosquito does not bite.");
        }
    }

}
