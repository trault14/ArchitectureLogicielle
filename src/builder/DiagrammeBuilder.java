package builder;

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
}
