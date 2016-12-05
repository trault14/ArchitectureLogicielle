package main;
import base.*;
import builder.*;
import visitor.DiagrammeElementDessinerVisitor;
import visitor.DiagrammeElementScripterVisitor;

public class Main {
	public static void main(String[] args) {
		System.out.println("Génération d'un diagramme...");
		
		DiagrammeBuilder diagrammeBuilder = new DiagrammeBuilder();
		
		diagrammeBuilder
				.type("class", "PairOfSocks")
					.variable("+", "material", "Wool")
					.variable("+", "thickness", "Integer")
					.variable("-", "color", "Color")
					.variable("+", "size", "Integer")
					.methode("+", "getTogether", "Socks")
					.methode("+", "wash", "void")
					.methode("-", "dry", "Boolean")
				.type("class", "Shirt")
					.methode("+", "fold", "void")
						//.argument("name", "type")
					.variable("+", "sleeveLength", "Integer")
					.methode("-", "wash", "Cloth")
					.methode("+", "dry", "Boolean")
					.methode("+", "ironed", "Boolean")
				.type("interface", "Cloth")
					.methode("+", "wear", "Tenue")
				.fleche("PairOfSocks", "Shirt")
				.fleche("PairOfSocks", "Cloth")
				.fleche("Cloth", "Shirt")
				.fleche("Cloth", "PairOfSocks")
		;

		Diagramme diagramme = diagrammeBuilder.getContent(null);

		DiagrammeElementDessinerVisitor visitor = new DiagrammeElementDessinerVisitor();
		//DiagrammeElementScripterVisitor visitor = new DiagrammeElementScripterVisitor();
		
		diagramme.accept(visitor);

		System.out.println("Fini");
	}
}
