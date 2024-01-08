package entites;

/**
 * L'interface <code>Growing</code> représente le comportement de croissance, où une classe qui implémente cette interface
 * doit fournir une méthode pour faire croître un objet en fonction d'une valeur spécifiée.
 */
public interface Growing {

    /**
     * La méthode <code>grow</code> est utilisée pour représenter l'action de faire croître un objet.
     *
     * @param value La valeur de croissance à appliquer.
     */
    void grow(int value);
}
