package builder;

import java.util.ArrayList;
import java.util.List;

import base.Diagramme;
import base.Type;

public class TypeBuilder{
	public DiagrammeBuilder parent;
	public List<MethodeBuilder> methodes = new ArrayList<MethodeBuilder>();
	public List<VariableBuilder> variables = new ArrayList<VariableBuilder>();
	public String nom;
    public String type;
	
	public TypeBuilder(DiagrammeBuilder parent){
		this.parent = parent;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}

    public void setType(String type) {
        this.type = type;
    }

    public DiagrammeBuilder diagramme() {
		return this.parent.diagramme();
	}

	
	public FlecheBuilder fleche(String nomBase, String nomPointe) {
		return this.parent.fleche(nomBase, nomPointe);
	}

	
	public TypeBuilder type(String type, String nom) {
		return this.parent.type(type, nom);
	}

	
	public MethodeBuilder methode(String visibility, String nom, String returnType) {
		MethodeBuilder child = new MethodeBuilder(this);
        child.setVisibility(visibility);
		child.setNom(nom);
        child.setReturnType(returnType);
		this.methodes.add(child);
		return child;
	}

	
	public VariableBuilder variable(String visibility, String nom, String type) {
		VariableBuilder child = new VariableBuilder(this);
        child.setVisibility(visibility);
		child.setNom(nom);
		child.setType(type);
		this.variables.add(child);
		return child;
	}

	
	public Type getContent(Diagramme parent){
		Type result = new Type();
		result.setParent(parent);
		for(MethodeBuilder mb : methodes){
			result.addMethode(mb.getContent(result));
		}
		for(VariableBuilder vb : variables){
			result.addVariable(vb.getContent(result));
		}
		result.setType(type);
		result.setNom(nom);
		return result;
	}
}
