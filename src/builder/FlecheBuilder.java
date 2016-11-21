package builder;

public class FlecheBuilder implements Builder {
	public DiagrammeBuilder parent;
	public TypeBuilder base;
	public TypeBuilder pointe;
	
	public FlecheBuilder(DiagrammeBuilder parent){
		this.parent = parent;
	}
	
	public void setBase(TypeBuilder base){
		this.base = base;
	}
	
	public void setPointe(TypeBuilder pointe){
		this.pointe = pointe;
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
