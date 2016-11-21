package base;

import java.util.ArrayList;
import java.util.List;

import visitor.DiagrammeElement;
import visitor.DiagrammeElementVisitor;

public class Diagramme implements DiagrammeElement {
	public List<Type> types = new ArrayList<Type>();
	public List<Fleche> fleches = new ArrayList<Fleche>();
	public List<Diagramme> diagrammes = new ArrayList<Diagramme>();
	@Override
	public void accept(DiagrammeElementVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
}
