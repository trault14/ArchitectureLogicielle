package builder;

import base.Diagramme;
import base.Fleche;

public class FlecheBuilder{
	public DiagrammeBuilder parent;
	public String base;
	public String pointe;
	
	public FlecheBuilder(DiagrammeBuilder parent){
		this.parent = parent;
	}
	
	public void setBase(String base){
		this.base = base;
	}
	
	public void setPointe(String pointe){
		this.pointe = pointe;
	}

	
	public DiagrammeBuilder diagramme() {
		return this.parent.diagramme();
	}
	
	public TypeBuilder type(String type, String nom) {
		return this.parent.type(type, nom);
	}
	
	public FlecheBuilder fleche(String nomBase, String nomPointe) {
		return this.parent.fleche(nomBase, nomPointe);
	}

	public Fleche getContent(Diagramme parent) {
		Fleche result = new Fleche();
		result.setParent(parent);
		result.setBase(this.base);
		result.setPointe(this.pointe);
		return result; //TODO probleme pour avoir les bases.
	}
}
