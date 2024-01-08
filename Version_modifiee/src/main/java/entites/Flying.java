package entites;

/**
 * La classe <code>Flying</code> représente un insecte volant.
 * Elle hérite de la classe abstraite <code>Insect</code>.
 */
public class Flying extends Insect {

    /**
     * Constructeur de la classe <code>Flying</code> avec une masse et une vitesse spécifiées.
     *
     * @param mass  La masse de l'insecte volant.
     * @param speed La vitesse de l'insecte volant.
     */
    public Flying(double mass, double speed) {
        super(mass, speed);
    }

    /**
     * Renvoie une représentation textuelle de l'insecte volant.
     *
     * @return Une chaîne de caractères décrivant l'état de l'insecte volant.
     */
    @Override
    public String toString() {
        if (getMass() == 0) {
            return "I’m dead, but I used to be a flying insect with a speed of " + getSpeed();
        } else {
            return "I’m a speedy flying insect with " + getSpeed() + " speed and " + getMass() + " mass.";
        }
    }

    /**
     * Fait croître l'insecte volant en ajoutant de la masse. La vitesse augmente avec la masse ajoutée,
     * mais diminue une fois que la masse atteint 20.
     *
     * @param addedMass La masse à ajouter à l'insecte volant.
     */
    public void grow(int addedMass) {
        setMass(getMass() + addedMass);
        if (getMass() < 20) {
            setSpeed(getSpeed() + addedMass);
        } else {
            setSpeed(getSpeed() - 0.5 * (getMass() - 20));
        }
    }
}
