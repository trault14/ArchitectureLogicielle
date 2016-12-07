package builder;

import java.util.ArrayList;
import java.util.List;

import base.Diagramme;

/***
 * 
 * Un builder retourne un élément de base
 *
 */
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
	
	public FlecheBuilder fleche(String nomBase, String nomPointe) {
		FlecheBuilder child = new FlecheBuilder(this);
		child.setBase(nomBase);
		child.setPointe(nomPointe);
		this.fleches.add(child);
		return child;
	}
	
	public TypeBuilder type(String type, String nom) {
		TypeBuilder child = new TypeBuilder(this);
		child.setType(type);
		child.setNom(nom);
		this.types.add(child);
		return child;
	}
	
	/***
	 * 
	 * retourne l'élement de base correspondant au diagramme. Avec un parcours en profondeur, on parcours également les fils du diagramme.
	 */
	public Diagramme getContent(Diagramme parent) {
		Diagramme result = new Diagramme();
		result.setParent(parent);
		for(DiagrammeBuilder db : this.diagrammes){
			result.addDiagramme(db.getContent(result));
		}
		for(TypeBuilder tb : this.types){
			result.addType(tb.getContent(result));
		}
		for(FlecheBuilder fb : this.fleches){ //Il faut obligatoirement avoir ajout� les types avant, pour que les fleches puissent bien se construire
			result.addFleche(fb.getContent(result));
		}
		return result;
	}
}
