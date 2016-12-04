package base;

import java.util.ArrayList;
import java.util.List;

import visitor.DiagrammeElement;
import visitor.DiagrammeElementVisitor;

public class Type implements DiagrammeElement {
	public String type;
	public String nom;
	public List<Methode> methodes = new ArrayList<Methode>();
	public List<Variable> variables = new ArrayList<Variable>();
	public Diagramme parent;
	
	public Diagramme getParent(){
		return this.parent;
	} 
	
	public void setParent(Diagramme parent){
		this.parent = parent;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
	public void addMethode(Methode methode){
		this.methodes.add(methode);
	}
	
	public void addVariable(Variable variable){
		this.variables.add(variable);
	}

	@Override
	public void accept(DiagrammeElementVisitor visitor) {
		visitor.visit(this);
		
		for (Variable var : this.variables) {
			var.accept(visitor);
		}
		
		for (Methode methode : this.methodes) {
			methode.accept(visitor);
		}

	}
}
