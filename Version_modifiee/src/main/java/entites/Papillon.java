package entites;

/**
 * La classe <code>Papillon</code> représente un papillon volant avec une couleur d'ailes spécifique.
 * Elle hérite de la classe <code>Flying</code>.
 */
public class Papillon extends Flying {

    /** La couleur des ailes du papillon. */
    private String wingColor;

    /**
     * Constructeur de la classe <code>Papillon</code> avec une masse, une vitesse et une couleur d'ailes spécifiées.
     *
     * @param mass      La masse du papillon.
     * @param speed     La vitesse du papillon.
     * @param wingColor La couleur des ailes du papillon.
     */
    public Papillon(double mass, double speed, String wingColor) {
        super(mass, speed);
        this.wingColor = wingColor;
    }

    /**
     * Renvoie une représentation textuelle du papillon.
     *
     * @return Une chaîne de caractères décrivant l'état du papillon.
     */
    @Override
    public String toString() {
        if (getMass() == 0) {
            return "I’m dead, but I used to be a butterfly with a speed of " + getSpeed();
        } else {
            return "I’m a speedy butterfly with " + getSpeed() + " speed and " + getMass() + " mass.";
        }
    }

    /**
     * Affiche la couleur des ailes du papillon.
     */
    public void displayWingColor() {
        System.out.println("I am a butterfly with wing color: " + wingColor);
    }
}
