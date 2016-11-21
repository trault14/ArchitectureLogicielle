package builder;

import java.util.ArrayList;
import java.util.List;

public class DiagrammeBuilder implements Builder{
	public DiagrammeBuilder parent; //Le diagramme de base n'aura pas de parent
	public List<TypeBuilder> types = new ArrayList<TypeBuilder>();
	public List<FlecheBuilder> fleches = new ArrayList<FlecheBuilder>();
	public List<DiagrammeBuilder> diagrammes = new ArrayList<DiagrammeBuilder>();
	
	public DiagrammeBuilder(){
		this.parent = null; //Rajouter un type de base ? DiagrammeBase ? DiagrammeNull ?
	}
	
	public DiagrammeBuilder(DiagrammeBuilder parent){
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
