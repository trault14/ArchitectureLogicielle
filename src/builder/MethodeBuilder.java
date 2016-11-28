package builder;

import java.util.ArrayList;
import java.util.List;

import base.Methode;
import base.Type;

public class MethodeBuilder{
	public TypeBuilder parent;
	public List<String> arguments = new ArrayList<String>();
	String nom;
	
	public MethodeBuilder(TypeBuilder parent){
		this.parent = parent;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}

	
	public DiagrammeBuilder diagramme() {
		return this.parent.diagramme();
	}

	
	public FlecheBuilder fleche(String nomBase, String nomPointe) {
		return this.parent.fleche(nomBase, nomPointe);
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

	
	public Methode getContent(Type parent) {
		Methode result = new Methode();
		result.setParent(parent);
		result.setNom(nom);
		return result;
	}
}
