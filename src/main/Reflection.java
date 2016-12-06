package main;

import java.io.IOException;
import java.util.List;

import base.Diagramme;
import builder.DiagrammeBuilder;
import reflection.Lister;
import visitor.DiagrammeElementDessinerVisitor;
import visitor.DiagrammeElementScripterVisitor;

public class Reflection {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		System.out.println("Génération du diagramme par Reflection...");
		
		Lister lister = new Lister();
		List<String> classesNames = lister.list("");
		
		DiagrammeBuilder diagrammeBuilder = lister.build(classesNames);
		Diagramme diagramme = diagrammeBuilder.getContent(null);
		
		DiagrammeElementDessinerVisitor visitor = new DiagrammeElementDessinerVisitor();
		DiagrammeElementScripterVisitor visitor2 = new DiagrammeElementScripterVisitor();
		
		diagramme.accept(visitor);
		diagramme.accept(visitor2);
		
		
		System.out.println("Fini");
		
	}
}
