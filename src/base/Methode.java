package base;

import java.util.ArrayList;
import java.util.List;

import visitor.DiagrammeElement;
import visitor.DiagrammeElementVisitor;

public class Methode implements DiagrammeElement {

	// Arguments de la méthode
	public List<String> arguments = new ArrayList<String>();
	
	// Sortie
	public String sortie;

	// Nom de la méthode
	public String nom;

	// Type dont la méthode appartient
	public Type parent;

	// public (statut = true) ou private (statut = false)
	public boolean statut;
	
	public boolean getStatut(){
		return this.statut;
	}
	
	public String getSortie(){
		return this.sortie;
	}

	//Changer le statut (public ou private) de la méthode
	public void setStatut() {
		statut = !statut;
	}

	public void setParent(Type parent) {
		this.parent = parent;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void addArgument(String argument) {
		this.arguments.add(argument);
	}

	@Override
	public void accept(DiagrammeElementVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
}
