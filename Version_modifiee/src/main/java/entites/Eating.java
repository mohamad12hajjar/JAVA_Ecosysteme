package entites;

/**
 * L'interface <code>Eating</code> représente le comportement de manger, où une classe qui implémente cette interface
 * doit fournir une méthode pour manger un insecte.
 */
public interface Eating {

    /**
     * La méthode <code>eat</code> est utilisée pour représenter l'action de manger un insecte.
     *
     * @param insect L'insecte à manger.
     */
    void eat(Insect insect);
}
