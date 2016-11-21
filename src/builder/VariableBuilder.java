package builder;

public class VariableBuilder implements Builder {
	public TypeBuilder parent;
	public String nom;
	
	public VariableBuilder(TypeBuilder parent){
		this.parent = parent;
	}
	
	public void setNom(String nom){
		this.nom = nom;
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
