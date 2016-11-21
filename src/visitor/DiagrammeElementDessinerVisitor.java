package visitor;

import base.Diagramme;
import base.Fleche;
import base.Methode;
import base.Type;
import base.Variable;

public class DiagrammeElementDessinerVisitor implements DiagrammeElementVisitor{

	@Override
	public void visit(Diagramme diagramme) {
		// TODO Auto-generated method stub
		System.out.println("Visite du Diagramme");
	}

	@Override
	public void visit(Type type) {
		// TODO Auto-generated method stub
		System.out.println("Visite du Type");
	}

	@Override
	public void visit(Fleche fleche) {
		// TODO Auto-generated method stub
		System.out.println("Visite de Fleche");
	}

	@Override
	public void visit(Methode methode) {
		// TODO Auto-generated method stub
		System.out.println("Visite de Methode");
	}

	@Override
	public void visit(Variable var) {
		// TODO Auto-generated method stub
		System.out.println("Visite de Variable");
	}

}
