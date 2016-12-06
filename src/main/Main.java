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
						.argument("pattern", "Pattern")
						.argument("iron", "Metal")
					.variable("+", "sleeveLength", "Integer")
					.methode("-", "wash", "Cloth")
						.argument("temperature", "Integer")
					.methode("+", "dry", "Boolean")
					.methode("+", "ironed", "Boolean")
				.type("interface", "Cloth")
					.methode("+", "wear", "Tenue")
					.methode("+", "wear", "Outfit")
				.fleche("PairOfSocks", "Shirt")
				.fleche("PairOfSocks", "Cloth")
				.fleche("Shirt","Cloth")
		;

		Diagramme diagramme = diagrammeBuilder.getContent(null);

		DiagrammeElementDessinerVisitor visitor = new DiagrammeElementDessinerVisitor();
		DiagrammeElementScripterVisitor visitor2 = new DiagrammeElementScripterVisitor();
		
		diagramme.accept(visitor);
		diagramme.accept(visitor2);

		System.out.println("Fini");
	}
}
