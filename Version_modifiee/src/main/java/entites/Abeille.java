package entites;

/**
 * Cette classe représente une abeille volante avec une capacité de stockage de pollen.
 */
public class Abeille extends Flying {

    /**
     * Capacité de stockage du pollen pour l'abeille.
     */
    public int pollenCapacity;

    /**
     * Constructeur de la classe Abeille.
     *
     * @param mass           La masse de l'abeille.
     * @param speed          La vitesse de l'abeille.
     * @param pollenCapacity La capacité de stockage du pollen pour l'abeille.
     */
    public Abeille(double mass, double speed, int pollenCapacity) {
        super(mass, speed);
        this.pollenCapacity = pollenCapacity;
    }

    /**
     * Renvoie une représentation textuelle de l'abeille.
     *
     * @return Une chaîne de caractères décrivant l'état de l'abeille.
     */
    @Override
    public String toString() {
        if (getMass() == 0) {
            return "I’m dead, but I used to be a bee with a speed of " + getSpeed();
        } else {
            return "I’m a speedy bee with " + getSpeed() + " speed and " + getMass() + " mass.";
        }
    }

    /**
     * Cette méthode permet à l'abeille de collecter du pollen.
     */
    public void collectPollen() {
        System.out.println("The bee is collecting pollen.");
    }

    /**
     * Obtient la capacité de stockage du pollen.
     *
     * @return La capacité de stockage du pollen.
     */
    public int getPollenCapacity() {
        return pollenCapacity;
    }

    /**
     * Définit la capacité de stockage du pollen.
     *
     * @param pollenCapacity La nouvelle capacité de stockage du pollen.
     */
    public void setPollenCapacity(int pollenCapacity) {
        this.pollenCapacity = pollenCapacity;
    }
}
