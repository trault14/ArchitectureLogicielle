package base;

import visitor.DiagrammeElement;
import visitor.DiagrammeElementVisitor;

public class Fleche implements DiagrammeElement {
	public Type base;
	public Type pointe;
	@Override
	public void accept(DiagrammeElementVisitor visitor) {
		// TODO Auto-generated method stub
		this.base.accept(visitor);
		this.pointe.accept(visitor);
		visitor.visit(this);
	}
}
