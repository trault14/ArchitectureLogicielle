package main;
import base.*;
import builder.*;

public class Main {
	public static void main(String[] args) {
		System.out.println("Génération d'un diagramme...");
		
		DiagrammeBuilder diagrammeBuilder = new DiagrammeBuilder();
		
		diagrammeBuilder
				.type("classe1")
				.type("classe2")
					.methode("methode1")
					.variable("variable1")
				.type("interface1");
		
		Diagramme diagramme = diagrammeBuilder.getContent();

		System.out.println("Fini");
	}
}
