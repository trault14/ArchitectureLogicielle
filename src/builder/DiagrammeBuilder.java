package builder;

import java.util.ArrayList;
import java.util.List;

import base.Diagramme;

public class DiagrammeBuilder{
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
	
	public DiagrammeBuilder diagramme() {
		DiagrammeBuilder child = new DiagrammeBuilder();
		this.diagrammes.add(child);
		return child;
	}
	
	public FlecheBuilder fleche() {
		FlecheBuilder child = new FlecheBuilder(this);
		this.fleches.add(child);
		return child;
	}
	
	public TypeBuilder type(String nom) {
		TypeBuilder child = new TypeBuilder(this);
		this.types.add(child);
		return child;
	}
	
	public Diagramme getContent() {
		Diagramme result = new Diagramme();
		for(DiagrammeBuilder db : this.diagrammes){
			result.addDiagramme(db.getContent());
		}
		for(TypeBuilder tb : this.types){
			result.addType(tb.getContent());
		}
		for(FlecheBuilder fb : this.fleches){
			result.addFleche(fb.getContent());
		}
		return result;
	}
}
