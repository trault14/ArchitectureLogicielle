package base;

import visitor.DiagrammeElement;
import visitor.DiagrammeElementVisitor;

public class Fleche implements DiagrammeElement {
	public String nomBase;
	public String nomPointe;
	public Type base;
	public Type pointe;
	public Diagramme parent;
	
	public void setParent(Diagramme parent){
		this.parent = parent;
	}
	
	public void setBase(String nomBase){
		this.nomBase = nomBase;
	}
	
	public void setPointe(String nomPointe){
		this.nomPointe = nomPointe;
	}
	
	public void setBase(Type base){
		this.base = base;
	}
	
	public void setPointe(Type pointe){
		this.pointe = pointe;
	}
		
	@Override
	public void accept(DiagrammeElementVisitor visitor) {
		visitor.visit(this);
	}
}
