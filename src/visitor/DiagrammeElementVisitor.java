package visitor;

import base.Diagramme;
import base.Fleche;
import base.Methode;
import base.Type;
import base.Variable;

public interface DiagrammeElementVisitor {

	void visit(Diagramme diagramme) ;
	void visit(Type type) ;
	void visit(Fleche fleche) ;
	void visit(Methode methode) ;
	void visit(Variable var) ;
}
