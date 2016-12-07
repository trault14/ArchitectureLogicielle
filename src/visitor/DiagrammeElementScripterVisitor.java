package visitor;

import base.Diagramme;
import base.Fleche;
import base.Methode;
import base.Type;
import base.Variable;

public class DiagrammeElementScripterVisitor implements DiagrammeElementVisitor {

	public int nbParents(DiagrammeElement element) {
		int nb = 0;
		while (element.getParent() != null) {
			nb++;
			element = element.getParent();
		}
		return nb;
	}

	@Override
	public void visit(Diagramme diagramme) {
		String str = "";
		for (int i = 0; i < this.nbParents(diagramme); i++) {
			str += " ";
		}
		System.out.println(str + ".diagramme");
	}

	@Override
	public void visit(Type type) {
		String str = "";
		for (int i = 0; i < this.nbParents(type); i++) {
			str += " ";
		}
		System.out.println(str + ".type(" + type.type + "," + type.nom + ")");
	}

	@Override
	public void visit(Fleche fleche) {
		String str = "";
		for (int i = 0; i < this.nbParents(fleche); i++) {
			str += " ";
		}
		System.out.println(str + ".fleche(" + fleche.nomBase + ","
				+ fleche.nomPointe + ")");

	}

	@Override
	public void visit(Methode methode) {
		String str = "";
		for (int i = 0; i < this.nbParents(methode); i++) {
			str += " ";
		}
		System.out.println(str + ".methode(" + methode.visibility + ","
				+ methode.nom + "," + methode.returnType + ")");

	}

	@Override
	public void visit(Variable var) {
		String str = "";
		for (int i = 0; i < this.nbParents(var); i++) {
			str += " ";
		}
		System.out.println(str + ".variable(" + var.visibility + "," + var.nom
				+ "," + var.typeVariable + ")");
	}

}
