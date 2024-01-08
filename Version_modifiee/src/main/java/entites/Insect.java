package entites;

/**
 * La classe <code>Insect</code> représente un insecte avec une masse et une vitesse.
 * Elle implémente l'interface <code>Growing</code>.
 */
public class Insect implements Growing {

    /** La masse de l'insecte. */
    private double mass;

    /** La vitesse de l'insecte. */
    private double speed;

    /**
     * Constructeur de la classe <code>Insect</code> avec une masse et une vitesse spécifiées.
     *
     * @param mass  La masse de l'insecte.
     * @param speed La vitesse de l'insecte.
     */
    public Insect(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    /**
     * Constructeur de la classe <code>Insect</code> avec une masse spécifiée et une vitesse par défaut.
     *
     * @param mass La masse de l'insecte.
     */
    public Insect(double mass) {
        this.mass = mass;
        this.speed = 10; // Vitesse par défaut de 10.
    }

    /**
     * Constructeur par défaut de la classe <code>Insect</code> avec une masse par défaut et une vitesse par défaut.
     */
    public Insect() {
        this.mass = 5; // Masse par défaut de 5.
        this.speed = 10; // Vitesse par défaut de 10.
    }

    /**
     * Obtient la masse de l'insecte.
     *
     * @return La masse de l'insecte.
     */
    public double getMass() {
        return mass;
    }

    /**
     * Définit la masse de l'insecte.
     *
     * @param mass La nouvelle masse de l'insecte.
     */
    public void setMass(double mass) {
        this.mass = mass;
    }

    /**
     * Obtient la vitesse de l'insecte.
     *
     * @return La vitesse de l'insecte.
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Définit la vitesse de l'insecte.
     *
     * @param speed La nouvelle vitesse de l'insecte.
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Fait croître l'insecte en ajoutant de la masse.
     *
     * @param addedMass La masse à ajouter à l'insecte.
     */
    public void grow(int addedMass) {
        setMass(getMass() + addedMass);
    }

    /**
     * Vérifie si l'insecte est mort (sa masse est égale à zéro).
     *
     * @return true si l'insecte est mort, sinon false.
     */
    public boolean isDead() {
        return getMass() == 0;
    }
}
