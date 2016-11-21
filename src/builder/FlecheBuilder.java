package builder;

import base.Fleche;

public class FlecheBuilder{
	public DiagrammeBuilder parent;
	public TypeBuilder base;
	public TypeBuilder pointe;
	
	public FlecheBuilder(DiagrammeBuilder parent){
		this.parent = parent;
	}
	
	public void setBase(TypeBuilder base){
		this.base = base;
	}
	
	public void setPointe(TypeBuilder pointe){
		this.pointe = pointe;
	}

	
	public DiagrammeBuilder diagramme() {
		return this.parent.diagramme();
	}
	
	public TypeBuilder type(String nom) {
		return this.parent.type(nom);
	}
	
	public FlecheBuilder fleche() {
		return this.parent.fleche();
	}

	public Fleche getContent() {
		Fleche result = new Fleche();
		return result; //TODO probleme pour avoir les bases.
	}
}
