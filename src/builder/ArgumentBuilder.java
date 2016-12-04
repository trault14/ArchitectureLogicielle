package builder;

import base.Argument;
import base.Methode;

public class ArgumentBuilder {
    public MethodeBuilder parent;
    public String name;
    public String type;

    public ArgumentBuilder(MethodeBuilder parent) {
        this.parent = parent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MethodeBuilder methode(String visibility, String nom, String returnType) {
        return this.parent.methode(visibility, nom, returnType);
    }

    public ArgumentBuilder argument(String name, String type) {
        return this.parent.argument(name, type);
    }

    public VariableBuilder variable(String visibility, String nom, String type) {
        return this.parent.variable(visibility, nom, type);
    }

    public Argument getContent(Methode parent) {
        Argument result = new Argument();
        result.setParent(parent);
        result.setName(name);
        result.setType(type);
        return result;
    }

}
