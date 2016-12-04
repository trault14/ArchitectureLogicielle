package visitor;

public interface DiagrammeElement {

	DiagrammeElement getParent();
	void accept(DiagrammeElementVisitor visitor);
}
