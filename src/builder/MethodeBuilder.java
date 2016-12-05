package builder;

import java.util.ArrayList;
import java.util.List;

import base.Methode;
import base.Type;

public class MethodeBuilder{
	public TypeBuilder parent;
	public List<ArgumentBuilder> arguments = new ArrayList<>();
	String visibility;
	String nom;
	String returnType;
	
	public MethodeBuilder(TypeBuilder parent){
		this.parent = parent;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
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
		return this.parent.methode(visibility, nom, returnType);
	}

	
	public VariableBuilder variable(String visibility, String nom, String type) {
		return this.parent.variable(visibility, nom, type);
	}


	public ArgumentBuilder argument(String name, String type) {
		ArgumentBuilder child = new ArgumentBuilder(this);
		child.setName(name);
		child.setType(type);
		this.arguments.add(child);
		return child;
	}

	public Methode getContent(Type parent) {
		Methode result = new Methode();
		result.setParent(parent);
        result.setVisibility(visibility);
		result.setNom(nom);
        result.setReturnType(returnType);
		for(ArgumentBuilder ab : arguments){
			result.addArgument(ab.getContent(result));
		}
		return result;
	}
}
