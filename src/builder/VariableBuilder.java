package builder;

import base.Variable;

public class VariableBuilder{
	public TypeBuilder parent;
	public String nom;
	
	public VariableBuilder(TypeBuilder parent){
		this.parent = parent;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}

	
	public DiagrammeBuilder diagramme() {
		return this.parent.parent.diagramme();
	}

	
	public FlecheBuilder fleche() {
		return this.parent.fleche();
	}

	
	public TypeBuilder type(String nom) {
		return this.parent.type(nom);
	}

	
	public MethodeBuilder methode(String nom) {
		return this.parent.methode(nom);
	}

	
	public VariableBuilder variable(String nom) {
		return this.parent.variable(nom);
	}

	
	public Variable getContent() {
		Variable result = new Variable();
		result.setNom(nom);
		return result;
	}
}
