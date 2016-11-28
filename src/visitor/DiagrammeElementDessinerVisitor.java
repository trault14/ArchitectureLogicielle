package visitor;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.svggen.SVGGraphics2DIOException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import base.Diagramme;
import base.Fleche;
import base.Methode;
import base.Type;
import base.Variable;

public class DiagrammeElementDessinerVisitor implements DiagrammeElementVisitor{
	
	int x = 10;
	int y = 10;
	int hauteur = 15;
	int largeur = 100;
	int dtexte = 2*hauteur / 3; //decalage du texte en y
	
	SVGGraphics2D svgGenerator = this.getGenerator();

	public SVGGraphics2D getGenerator(){
	    DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
	    String svgNS = "http://www.w3.org/2000/svg";
	    Document document = domImpl.createDocument(svgNS, "svg", null);
	    SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
	    svgGenerator.setBackground(Color.white);
	    svgGenerator.setPaint(Color.black);
	    return svgGenerator;
	}
	
	public void printGraphic(){
		Writer out;
		try {
			PrintStream fileOut = new PrintStream(new FileOutputStream("output.svg"));
			out = new OutputStreamWriter(fileOut, "UTF-8");
			svgGenerator.stream(out, true);
		} catch (UnsupportedEncodingException | SVGGraphics2DIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void visit(Diagramme diagramme) {
		System.out.println("Visite du Diagramme");
		this.printGraphic();
		
	}

	@Override
	public void visit(Type type) {
		//System.out.println("Visite du Type");
		int nbVariables = type.variables.size();
		int nbMethodes = type.methodes.size();
		svgGenerator.setPaint(Color.yellow);
		svgGenerator.fill(new Rectangle(x, y, largeur, (nbVariables+nbMethodes+1)*hauteur));
		svgGenerator.setPaint(Color.black);
		svgGenerator.draw(new Rectangle(x, y, largeur, (nbVariables+nbMethodes+1)*hauteur));
		svgGenerator.drawString(type.nom, x, y+dtexte);
		svgGenerator.drawLine(x, y + hauteur, x+largeur, y+hauteur);
		this.y += hauteur;
		if(type.methodes.isEmpty() && type.variables.isEmpty()){
			this.y += hauteur; //on saute une ligne
		}
	}

	@Override
	public void visit(Fleche fleche) {
		System.out.println("Visite de Fleche");
	}

	@Override
	public void visit(Methode methode) {
		System.out.println("Visite de Methode");
		//svgGenerator.draw(new Rectangle(x, y, largeur, hauteur));
		svgGenerator.drawString("m : " + methode.nom, x, y+dtexte);
		this.y += hauteur; //Passage à la ligne suivante
		if(methode.equals(methode.parent.methodes.get(methode.parent.methodes.size()-1))){
			this.y += hauteur; //on saute une ligne si la méthode est la dernière
		}
	}

	@Override
	public void visit(Variable var) {
		System.out.println("Visite de Variable");
		//svgGenerator.draw(new Rectangle(x, y, largeur, hauteur));
		svgGenerator.drawString("v : " + var.nom, x, y+dtexte);
		this.y += hauteur; //Passage à la ligne suivante
		if(var.equals(var.parent.variables.get(var.parent.variables.size()-1))){
			svgGenerator.drawLine(x, y, x+largeur, y);
		}
		if(var.parent.methodes.isEmpty()){
			this.y += hauteur; //on saute une ligne
		}
	}

}
