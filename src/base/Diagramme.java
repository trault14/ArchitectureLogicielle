package base;

import java.util.ArrayList;
import java.util.List;

import visitor.DiagrammeElement;
import visitor.DiagrammeElementVisitor;

public class Diagramme implements DiagrammeElement {
	public List<Type> types = new ArrayList<Type>();
	public List<Fleche> fleches = new ArrayList<Fleche>();
	public List<Diagramme> diagrammes = new ArrayList<Diagramme>();
	
	public void addType(Type type){
		this.types.add(type);
	}
	
	public void addFleche(Fleche fleche){
		this.fleches.add(fleche);
	}
	
	public void addDiagramme(Diagramme diagramme){
		this.diagrammes.add(diagramme);
	}
		
	@Override
	public void accept(DiagrammeElementVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
}
