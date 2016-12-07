package visitor;

/***
 * 
 * Représente un élement du diagramme
 *
 */
public interface DiagrammeElement {

	DiagrammeElement getParent();
	/***
	 * 
	 * @param visitor représentation de l'élement
	 */
	void accept(DiagrammeElementVisitor visitor);
}
