package builder;

public class MethodeBuilder implements Builder{
	public TypeBuilder parent;
	public List<String> arguments = new ArrayList<String>();
	
	public MethodeBuilder(TypeBuilder parent){
		this.parent = parent;
	}
}
