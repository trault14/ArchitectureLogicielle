package builder;

public class TypeBuilder implements Builder {
	public DiagrammeBuilder parent;
	public List<MethodeBuilder> methodes = new ArrayList<MethodeBuilder>();
	public List<VariableBuilder> variables = new ArrayList<VariableBuilder>();
	
	public TypeBuilder(DiagrammeBuilder parent){
		this.parent = parent;
	}
}
