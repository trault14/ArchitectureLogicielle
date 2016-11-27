package base;

import visitor.DiagrammeElement;
import visitor.DiagrammeElementVisitor;

public class Fleche implements DiagrammeElement {
	public String nomBase;
	public String nomPointe;
	public Type base;
	public Type pointe;
	
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
		// TODO Auto-generated method stub
		this.base.accept(visitor);
		this.pointe.accept(visitor);
		visitor.visit(this);
	}
}
