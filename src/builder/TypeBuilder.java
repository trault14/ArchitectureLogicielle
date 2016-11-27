package builder;

import java.util.ArrayList;
import java.util.List;

import base.Type;

public class TypeBuilder{
	public DiagrammeBuilder parent;
	public List<MethodeBuilder> methodes = new ArrayList<MethodeBuilder>();
	public List<VariableBuilder> variables = new ArrayList<VariableBuilder>();
	public String nom;
	
	public TypeBuilder(DiagrammeBuilder parent){
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
		MethodeBuilder child = new MethodeBuilder(this);
		child.setNom(nom);
		this.methodes.add(child);
		return child;
	}

	
	public VariableBuilder variable(String nom) {
		VariableBuilder child = new VariableBuilder(this);
		child.setNom(nom);
		this.variables.add(child);
		return child;
	}

	
	public Type getContent(){
		Type result = new Type();
		for(MethodeBuilder mb : methodes){
			result.addMethode(mb.getContent());
		}
		for(VariableBuilder vb : variables){
			result.addVariable(vb.getContent());
		}
		result.setNom(nom);
		return result;
	}
}
