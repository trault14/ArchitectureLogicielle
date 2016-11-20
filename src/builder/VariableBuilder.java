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
}
