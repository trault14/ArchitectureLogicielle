package builder;

import java.util.ArrayList;
import java.util.List;

public class MethodeBuilder implements Builder{
	public TypeBuilder parent;
	public List<String> arguments = new ArrayList<String>();
	
	public MethodeBuilder(TypeBuilder parent){
		this.parent = parent;
	}

	@Override
	public DiagrammeBuilder diagramme() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlecheBuilder fleche() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeBuilder type() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MethodeBuilder methode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VariableBuilder variable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Builder getContent() {
		// TODO Auto-generated method stub
		return null;
	}
}
