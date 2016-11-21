package base;

import java.util.ArrayList;
import java.util.List;

public class Type {
	public String nom;
	public List<Methode> methodes = new ArrayList<Methode>();
	public List<Variable> variables = new ArrayList<Variable>();
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
	public void addMethode(Methode methode){
		this.methodes.add(methode);
	}
	
	public void addVariable(Variable variable){
		this.variables.add(variable);
	}
}
