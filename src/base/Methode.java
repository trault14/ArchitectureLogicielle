package base;

import java.util.ArrayList;
import java.util.List;

import visitor.DiagrammeElement;
import visitor.DiagrammeElementVisitor;

public class Methode implements DiagrammeElement {

	// Arguments de la méthode
	public List<Argument> arguments = new ArrayList<>();

	// Visibilité public ou private de la methode
	public String visibility;

	// Nom de la méthode
	public String nom;

	// Type de retour de la methode
    public String returnType;

	// Type dont la méthode appartient
	public Type parent;

	// public (statut = true) ou private (statut = false)
	public boolean statut;
	
	public boolean getStatut(){
		return this.statut;
	}
	
	public String getReturnType(){
		return this.returnType;
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

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public void addArgument(Argument argument) {
		this.arguments.add(argument);
	}

	@Override
	public void accept(DiagrammeElementVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public DiagrammeElement getParent() {
		return this.parent;
	}
}
