package base;

import java.util.ArrayList;
import java.util.List;

import visitor.DiagrammeElement;
import visitor.DiagrammeElementVisitor;

public class Diagramme implements DiagrammeElement {
	public List<Type> types = new ArrayList<Type>();
	public List<Fleche> fleches = new ArrayList<Fleche>();
	public List<Diagramme> diagrammes = new ArrayList<Diagramme>();
	public Diagramme parent;
	
	public void setParent(Diagramme parent){
		this.parent = parent;
	}

	public void addType(Type type){
		this.types.add(type);
	}
	
	public Type getType(String nom){
		for (Type t : types){
			if(t.nom.equals(nom)){
				return t;
			}
		}
		System.err.println("Type "+nom+" non trouv�");
		return null; //TODO � modifier (exit code ?)
	}
	
	public void addFleche(Fleche fleche){
		fleche.setBase(this.getType(fleche.nomBase));
		fleche.setPointe(this.getType(fleche.nomPointe));
		this.fleches.add(fleche);
	}
	
	public void addDiagramme(Diagramme diagramme){
		this.diagrammes.add(diagramme);
	}
		
	@Override
	public void accept(DiagrammeElementVisitor visitor) {
		// TODO Auto-generated method stub
		for (Type type : this.types) {
			type.accept(visitor);
		}

		for (Fleche fleche : this.fleches) {
			fleche.accept(visitor);
		}

		for (Diagramme diagramme : this.diagrammes) {
			diagramme.accept(visitor);
		}

		visitor.visit(this);
	}
}
