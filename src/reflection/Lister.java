package reflection;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
				Method[] methods = c.getMethods();
				for(Method method : methods){
					type.methode("+", method.getName(), method.getGenericReturnType().getTypeName()); //TODO details
				}
				Field[] vars = c.getFields();
				for(Field var : vars){
					type.variable("+", var.getName(), var.getGenericType().getTypeName()); //TODO details
				}
				//TODO fleches
			} catch (ClassNotFoundException e) {
				System.err.println("Class not found : "+className);
				e.printStackTrace();
			}
		}
		return diagramme;
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/*
		Class c = Class.forName("builder.DiagrammeBuilder");
		System.out.println(c.getMethods()[0].getName());
		*/
		System.out.println("Begin Lister Main");
		Lister lister = new Lister();
		List<String> classesNames = lister.list("");
		for(String className : classesNames){
			System.out.println(className);
		}
		System.out.println("End Lister Main");
	}
}
