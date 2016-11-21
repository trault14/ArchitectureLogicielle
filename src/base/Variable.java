package base;

import visitor.DiagrammeElement;
import visitor.DiagrammeElementVisitor;

public class Variable implements DiagrammeElement  {
	public String nom;
	
	public void setNom(String nom){
		this.nom = nom;
	}

	@Override
	public void accept(DiagrammeElementVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
}
