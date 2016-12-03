package main;
import base.*;
import builder.*;
import visitor.DiagrammeElementDessinerVisitor;

public class Main {
	public static void main(String[] args) {
		System.out.println("Génération d'un diagramme...");
		
		DiagrammeBuilder diagrammeBuilder = new DiagrammeBuilder();
		
		diagrammeBuilder
				.type("pairOfSocks")
					.variable("+", "material", "Wool")
					.variable("+", "thickness", "Integer")
					.variable("-", "color", "Color")
					.variable("+", "size", "Integer")
					.methode("+", "getTogether", "Socks")
					.methode("+", "wash", "void")
					.methode("-", "dry", "Boolean")
				.type("shirt")
					.methode("+", "fold", "void")
					.variable("+", "sleeveLength", "Integer")
					.methode("-", "wash", "Cloth")
					.methode("+", "dry", "Boolean")
					.methode("+", "ironed", "Boolean")
				.type("cloth")
					.methode("+", "wear", "Tenue")
				.fleche("pairOfSocks", "shirt")
				.fleche("pairOfSocks", "cloth")
				.fleche("cloth", "shirt")
				.fleche("cloth", "pairOfSocks")
		;

		Diagramme diagramme = diagrammeBuilder.getContent(null);

		DiagrammeElementDessinerVisitor visitor = new DiagrammeElementDessinerVisitor();
		diagramme.accept(visitor);

		System.out.println("Fini");
	}
}
