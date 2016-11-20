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
}
