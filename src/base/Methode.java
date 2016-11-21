package base;

import java.util.ArrayList;
import java.util.List;

public class Methode {
	public List<String> arguments = new ArrayList<String>();
	public String nom;
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
	public void addArgument(String argument){
		this.arguments.add(argument);
	}
}
