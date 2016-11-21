package base;

import java.util.ArrayList;
import java.util.List;

import visitor.DiagrammeElement;
import visitor.DiagrammeElementVisitor;

public class Methode implements DiagrammeElement  {
	public List<String> arguments = new ArrayList<String>();

	@Override
	public void accept(DiagrammeElementVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}
}
