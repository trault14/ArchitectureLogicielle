package visitor;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.svggen.SVGGraphics2DIOException;
//import org.apache.batik.svggen.font.Font;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import tools.TypeDessin;
import base.Diagramme;
import base.Fleche;
import base.Methode;
import base.Type;
import base.Variable;

public class DiagrammeElementDessinerVisitor implements DiagrammeElementVisitor {

	int x = 30;
	int y = 10;
	int hauteur = 15;
	int largeur = 100;
	int dtexte = 2 * hauteur / 3; // decalage du texte en y

	SVGGraphics2D svgGenerator = this.getGenerator();

	private List<TypeDessin> typeDessin = new ArrayList<TypeDessin>();

	public SVGGraphics2D getGenerator() {
		DOMImplementation domImpl = GenericDOMImplementation
				.getDOMImplementation();
		String svgNS = "http://www.w3.org/2000/svg";
		Document document = domImpl.createDocument(svgNS, "svg", null);
		SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
		svgGenerator.setBackground(Color.white);
		svgGenerator.setPaint(Color.black);
		return svgGenerator;
	}

	public void printGraphic() {
		Writer out;
		try {
			PrintStream fileOut = new PrintStream(new FileOutputStream(
					"output.svg"));
			out = new OutputStreamWriter(fileOut, "UTF-8");
			svgGenerator.stream(out, true);
		} catch (UnsupportedEncodingException | SVGGraphics2DIOException
				| FileNotFoundException e) {
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
		System.out.println("Visite du Type");

		typeDessin.add(new TypeDessin(type, x, y, hauteur, largeur));

		int nbVariables = type.variables.size();
		int nbMethodes = type.methodes.size();

		// Couleur du fond du type
		svgGenerator.setPaint(Color.white);

		// Création du rectangle du type
		svgGenerator.fill(new Rectangle(x, y, largeur, (nbVariables
				+ nbMethodes + 1)
				* hauteur));
		svgGenerator.setPaint(Color.black);
		svgGenerator.draw(new Rectangle(x, y, largeur, (nbVariables
				+ nbMethodes + 1)
				* hauteur));

		// Ecriture du nom du type
		svgGenerator.drawString(type.nom, x, y + dtexte);

		// Ligne de séparation
		svgGenerator.drawLine(x, y + hauteur, x + largeur, y + hauteur);

		this.y += hauteur;

		// prochain type placé de manière aléatoire sur le diagramme
		// this.x = this.x + (int)(Math.random()*20) - (int)(Math.random()*20);

		if (type.methodes.isEmpty() && type.variables.isEmpty()) {
			this.y += hauteur; // on saute une ligne
		}
	}

	// /!\ Pour le moment, les types sont alignés verticalement
	@Override
	public void visit(Fleche fleche) {
		System.out.println("Visite de Fleche");

		// Recuperation des classes reliées par la fleche
		Type base = fleche.getBase();
		Type pointe = fleche.getPointe();

		// Recuperation des indices des classes dans la liste de types du
		// diagramme les contenant
		int indexBase = base.parent.getTypes().indexOf(base);
		int indexPointe = pointe.parent.getTypes().indexOf(pointe);

		// Décalage de la ligne par rapport au Type
		int e = (int) (Math.random() * 10) + 3;
		// System.out.println(e);

		// Recupération des coordonnées du type de départ
		int xBase = this.typeDessin.get(indexBase).getX();
		int yBase = this.typeDessin.get(indexBase).getY()
				+ this.typeDessin.get(indexBase).getHeight();

		int xPointe = this.typeDessin.get(indexPointe).getX();
		int yPointe = this.typeDessin.get(indexPointe).getY()
				+ this.typeDessin.get(indexPointe).getHeight();

		// Tracé des lignes

		// Ligne principale
		svgGenerator.setPaint(Color.black);

		int[] xTriangle = new int[3];
		int[] yTriangle = new int[3];

		yTriangle[0] = yPointe + e;
		yTriangle[1] = yPointe + 2 + e;
		yTriangle[2] = yPointe - 2 + e;
		// Fleche à gauche
		int difference = xPointe - xBase;
		if (difference < this.typeDessin.get(indexBase).getWidth() / 2) {
			int x0;
			int x1;
			int y0;
			int y1;
			if(xBase>xPointe){
				x0 = xPointe;
				x1 = xBase;
				
				y0 = yPointe;
				y1 = yBase;
			}else{
				x0 = xBase;
				x1 = xPointe;
				
				y0 = yBase;
				y1 = yPointe;
			}
			svgGenerator.drawLine(x0 - e, yBase + e, x0 - e, yPointe + e);

			// lignes secondaires reliant la ligne principale avec les classes
			svgGenerator.drawLine(x0 - e, y0 + e, x0, y0 + e);
			
			svgGenerator.drawLine(x0 - e, y1 + e, x1, y1 + e);

			// Triangle de la fleche
			xTriangle[0] = xPointe;
			xTriangle[1] = xPointe - 2;
			xTriangle[2] = xPointe - 2;

		} else {
			// Fleche à droite
			svgGenerator.drawLine(xPointe
					+ this.typeDessin.get(indexPointe).getWidth() + e, yBase
					+ e, xPointe + this.typeDessin.get(indexPointe).getWidth()
					+ e, yPointe + e);

			// lignes secondaires reliant la ligne principale avec les classes
			// Ligne partant de la classe de base
			svgGenerator.drawLine(xBase
					+ this.typeDessin.get(indexBase).getWidth(), yBase + e,
					xPointe + this.typeDessin.get(indexPointe).getWidth() + e,
					yBase + e);
			// Ligne arrivant à la pointe
			svgGenerator.drawLine(xPointe
					+ this.typeDessin.get(indexPointe).getWidth(), yPointe
					+ e, xPointe + this.typeDessin.get(indexPointe).getWidth()
					+ e, yPointe + e);

			// Triangle de la fleche
			xTriangle[0] = xPointe
					+ this.typeDessin.get(indexPointe).getWidth() ;
			xTriangle[1] = xPointe
					+ this.typeDessin.get(indexPointe).getWidth() + 2;
			xTriangle[2] = xPointe
					+ this.typeDessin.get(indexPointe).getWidth() + 2;
		}

		svgGenerator.drawPolygon(new Polygon(xTriangle, yTriangle, 3));
		svgGenerator.fillPolygon(new Polygon(xTriangle, yTriangle, 3));
	}

	@Override
	public void visit(Methode methode) {
		System.out.println("Visite de Methode");
		// svgGenerator.draw(new Rectangle(x, y, largeur, hauteur));
		svgGenerator.drawString("m : " + methode.nom, x, y + dtexte);
		this.y += hauteur; // Passage à la ligne suivante
		if (methode.equals(methode.parent.methodes.get(methode.parent.methodes
				.size() - 1))) {
			this.y += hauteur; // on saute une ligne si la méthode est la
								// dernière
			// prochain type placé de manière aléatoire sur le diagramme
			this.x = this.x + (int) (Math.random() * 80)
					- (int) (Math.random() * 20);
		}
	}

	@Override
	public void visit(Variable var) {
		System.out.println("Visite de Variable");
		// svgGenerator.draw(new Rectangle(x, y, largeur, hauteur));

		// Recuperation des coordonnees du type
		// int xVar =
		// this.typeDessin.get(var.parent.getParent().getTypes().indexOf(var.parent)).getX();
		svgGenerator.drawString("v : " + var.nom, x, y + dtexte);
		this.y += hauteur; // Passage à la ligne suivante
		if (var.equals(var.parent.variables.get(var.parent.variables.size() - 1))) {
			svgGenerator.drawLine(x, y, x + largeur, y);
		}
		if (var.parent.methodes.isEmpty()) {
			this.y += hauteur; // on saute une ligne
		}
	}

}
