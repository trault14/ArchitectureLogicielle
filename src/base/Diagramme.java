package base;

import java.util.ArrayList;
import java.util.List;

public class Diagramme {
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
}
