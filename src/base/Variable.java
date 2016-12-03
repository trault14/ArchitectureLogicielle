package base;

import visitor.DiagrammeElement;
import visitor.DiagrammeElementVisitor;

public class Variable implements DiagrammeElement  {
	public String visibility;
	public String nom;
	public String typeVariable;
	public Type parent;
	
	public void setParent(Type parent){
		this.parent = parent;
	}

	public void setNom(String nom){
		this.nom = nom;
	}

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public void setTypeVariable(String typeVariable) {
        this.typeVariable = typeVariable;
    }

    @Override
	public void accept(DiagrammeElementVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
}
