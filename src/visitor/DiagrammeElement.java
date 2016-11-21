package visitor;

public interface DiagrammeElement {

	void accept(DiagrammeElementVisitor visitor);
}
