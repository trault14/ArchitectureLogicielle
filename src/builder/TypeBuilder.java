package builder;

import java.util.ArrayList;
import java.util.List;

public class TypeBuilder implements Builder {
	public DiagrammeBuilder parent;
	public List<MethodeBuilder> methodes = new ArrayList<MethodeBuilder>();
	public List<VariableBuilder> variables = new ArrayList<VariableBuilder>();
	public String nom;
	
	public TypeBuilder(DiagrammeBuilder parent){
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
