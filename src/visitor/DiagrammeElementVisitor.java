package visitor;

public interface DiagrammeElementVisitor {

	void visit(Diagram) ;
	void visit(Type) ;
	void visit(Arrow);
}
