package builder;

public interface Builder {
	public DiagrammeBuilder diagramme();
	public FlecheBuilder fleche();
	public TypeBuilder type();
	public MethodeBuilder methode();
	public VariableBuilder variable();
	public Builder getContent(); //Le type de retour sera adapté à la classe qui l'implémente
}
