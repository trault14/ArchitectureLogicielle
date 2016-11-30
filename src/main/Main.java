package main;
import base.*;
import builder.*;
import visitor.DiagrammeElementDessinerVisitor;

public class Main {
	public static void main(String[] args) {
		System.out.println("Génération d'un diagramme...");
		
		DiagrammeBuilder diagrammeBuilder = new DiagrammeBuilder();
		
		diagrammeBuilder
				.type("classe1")
					.variable("var1")
					.variable("var2")
					.variable("var3")
					.variable("var4")
					.methode("methode1")
					.methode("methode2")
					.methode("methode3")
				.type("classe2")
					.methode("methode1")
					.variable("variable1")
					.methode("Methode2")
					.methode("methode3")
					.methode("methode4")
					.methode("methode5")
				.type("interface1")
					.methode("methode1")
				.fleche("classe1", "classe2")
				.fleche("classe1", "interface1")
				.fleche("interface1", "classe1");

		Diagramme diagramme = diagrammeBuilder.getContent(null);

		DiagrammeElementDessinerVisitor visitor = new DiagrammeElementDessinerVisitor();
		diagramme.accept(visitor);

		System.out.println("Fini");
	}
}
