package entites;

/**
 * La classe <code>Eaters</code> représente des mangeurs avec diverses caractéristiques telles que le nom, l'âge
 * et la vitesse de la langue.
 */
public class Eaters {

    /** Le nom du mangeur. */
    private String name;

    /** L'âge du mangeur, mesuré en mois. */
    private int age;

    /** La vitesse de la langue du mangeur. */
    private double tongueSpeed;

    /**
     * Constructeur de la classe <code>Eaters</code> avec toutes les informations nécessaires.
     *
     * @param name        Le nom du mangeur.
     * @param age         L'âge du mangeur en mois.
     * @param tongueSpeed La vitesse de la langue du mangeur.
     */
    public Eaters(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
    }

    /**
     * Constructeur de la classe <code>Eaters</code> avec l'âge spécifié en années.
     *
     * @param name        Le nom du mangeur.
     * @param ageInYears  L'âge du mangeur en années.
     * @param tongueSpeed La vitesse de la langue du mangeur.
     */
    public Eaters(String name, double ageInYears, double tongueSpeed){
        this.name = name;
        this.age = (int) ageInYears * 12; // Conversion de l'âge en mois.
        this.tongueSpeed = tongueSpeed;
    }

    /**
     * Constructeur de la classe <code>Eaters</code> avec seulement le nom, en utilisant des valeurs par défaut pour l'âge
     * et la vitesse de la langue.
     *
     * @param name Le nom du mangeur.
     */
    public Eaters(String name){
        this.name = name;
        this.age = 5; // Valeur par défaut pour l'âge.
        this.tongueSpeed = 5; // Valeur par défaut pour la vitesse de la langue.
    }

    /**
     * Obtient le nom du mangeur.
     *
     * @return Le nom du mangeur.
     */
    public String getName() {
        return name;
    }

    /**
     * Définit le nom du mangeur.
     *
     * @param name Le nouveau nom du mangeur.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtient l'âge du mangeur en mois.
     *
     * @return L'âge du mangeur en mois.
     */
    public int getAge() {
        return age;
    }

    /**
     * Définit l'âge du mangeur en mois.
     *
     * @param age Le nouvel âge du mangeur en mois.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Obtient la vitesse de la langue du mangeur.
     *
     * @return La vitesse de la langue du mangeur.
     */
    public double getTongueSpeed() {
        return tongueSpeed;
    }

    /**
     * Définit la vitesse de la langue du mangeur.
     *
     * @param tongueSpeed La nouvelle vitesse de la langue du mangeur.
     */
    public void setTongueSpeed(double tongueSpeed) {
        this.tongueSpeed = tongueSpeed;
    }
}
