package reflection;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import builder.*;

public class Lister {
	
	public List<String> list(String packageName) throws IOException{
		
		List<String> classesNames = new ArrayList<String>();
		
		Enumeration<URL> urls = ClassLoader.getSystemResources(packageName);
		
		while(urls.hasMoreElements()){
			URL url = urls.nextElement();
			File root = new File(url.getPath());
			for (File file : root.listFiles()) {
				if (file.isDirectory()) {
				    List<String> subClasses = this.list(file.getName());
				    classesNames.addAll(subClasses);
				} else {
					if(file.getName().endsWith(".class")){
						classesNames.add(packageName+"."+file.getName().substring(0, file.getName().length()-6));
					}
					else{
						classesNames.add(packageName+"."+file.getName());
					}
				}
			}
		}
		
		return classesNames;
	}
	
	public DiagrammeBuilder build(List<String> classesNames){
		DiagrammeBuilder diagramme = new DiagrammeBuilder();
		for(String className : classesNames){
			Class c;
			try {
				c = Class.forName(className);
				TypeBuilder type = diagramme.type("class", className);
				Method[] methods = c.getDeclaredMethods();
				for(Method method : methods){
					type.methode("+", method.getName(), method.getGenericReturnType().getTypeName()); //TODO details
				}
				Field[] vars = c.getFields();
				for(Field var : vars){
					type.variable("+", var.getName(), var.getGenericType().getTypeName()); //TODO details
				}
				
				Type[] interfaces = c.getGenericInterfaces();
				for(Type interf : interfaces){
					diagramme.fleche(className, interf.getTypeName()); //TODO ajouter quand on aura la differenciation class/interface
				}
				Type superclass = c.getGenericSuperclass();
				if(superclass!=null && superclass.getTypeName()!="java.lang.Object"){
					diagramme.fleche(className, superclass.getTypeName()); //TODO ajouter quand on aura la differenciation class/interface
				}
				
			} catch (ClassNotFoundException e) {
				System.err.println("Class not found : "+className);
				e.printStackTrace();
			}
		}
		return diagramme;
	}
}
