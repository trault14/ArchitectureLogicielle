package builder;

import base.Type;
import base.Variable;

public class VariableBuilder{
	public TypeBuilder parent;
    public String visibility;
	public String nom;
    public String type;
	
	public VariableBuilder(TypeBuilder parent){
		this.parent = parent;
	}

	public void setVisibility(String visibility) {
	    this.visibility = visibility;
    }
	
	public void setNom(String nom){
		this.nom = nom;
	}

	public void setType(String type) {
	    this.type = type;
    }

	
	public DiagrammeBuilder diagramme() {
		return this.parent.parent.diagramme();
	}

	
	public FlecheBuilder fleche(String nomBase, String nomPointe) {
		return this.parent.fleche(nomBase, nomPointe);
	}

	
	public TypeBuilder type(String nom) {
		return this.parent.type(nom);
	}

	
	public MethodeBuilder methode(String visibility, String nom, String returnType) {
		return this.parent.methode(visibility, nom, returnType);
	}

	
	public VariableBuilder variable(String visibility, String nom, String type) {
		return this.parent.variable(visibility, nom, type);
	}

	
	public Variable getContent(Type parent) {
		Variable result = new Variable();
		result.setParent(parent);
        result.setVisibility(visibility);
		result.setNom(nom);
        result.setTypeVariable(type);
		return result;
	}
}
