package base;

import java.util.ArrayList;
import java.util.List;

import visitor.DiagrammeElement;
import visitor.DiagrammeElementVisitor;

public class Methode implements DiagrammeElement  {
	public List<String> arguments = new ArrayList<String>();

	public String nom;
	public Type parent;
	
	public void setParent(Type parent){
		this.parent = parent;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
	public void addArgument(String argument){
		this.arguments.add(argument);
	}

	@Override
	public void accept(DiagrammeElementVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
}
