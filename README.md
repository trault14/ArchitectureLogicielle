# DSL embarqué pour le dessin svg de diagrammes de type

Équipe :
  * Quéraud Romain
  * Rault Tim
  * Than Trong Thai-An
———

Le projet permet de générer un diagramme de type de **deux manières différentes** : à partir de la description de ce diagramme via l’**utilisation du DSL** ou bien par **introspection automatique** du projet. **Le résultat du dessin quelle que soit la méthode employée se situe dans le dossier output.svg à la racine du projet**.

## Génération du diagramme via le DSL
Il est possible de générer un diagramme de type en fournissant sa **définition sous forme d’un programme écrit dans le langage DSL** dont les règles syntaxiques sont données ci-dessous. **Le programme est à écrire dans la procédure main de la classe Main située dans le chemin ArchitectureLogicielle/src/main/ et le dessin du diagramme se lance au moyen de cette procédure main**.

### Syntaxe du DSL
La syntaxe du DSL repose sur le modèle fluent API par appel de méthode.
  * Sur un objet de type diagrammeBuilder :
     .type(class/interface, nom) permet d’ajouter une classe ou une interface au diagramme
     .fleche(class/interface1, class/interface2) permet de tracer une flèche entre deux types
  * Sur un objet de type type :
     .variable(visibilité, nom, type) : ajouter une variable au type
     .methode(visibilité, nom, type de retour) : ajouter une méthode au type
  * Sur un objet de type methode : 
     .argument(nom, type) : ajouter un argument à une méthode

### Exemple de diagramme
Voici ci-dessous un exemple de diagramme de type décrit à l’aide du DSL :

DiagrammeBuilder diagrammeBuilder = new DiagrammeBuilder();
		
		diagrammeBuilder
				.type("class", "PairOfSocks")
					.variable("+", "material", "Wool")
					.variable("+", "thickness", "Integer")
					.variable("-", "color", "Color")
					.variable("+", "size", "Integer")
					.methode("+", "getTogether", "Socks")
					.methode("+", "wash", "void")
					.methode("-", "dry", "Boolean")
				.type("class", "Shirt")
					.methode("+", "fold", "void")
						.argument("pattern", "Pattern")
						.argument("iron", "Metal")
					.variable("+", "sleeveLength", "Integer")
					.methode("-", "wash", "Cloth")
						.argument("temperature", "Integer")
					.methode("+", "dry", "Boolean")
					.methode("+", "ironed", "Boolean")
				.type("interface", "Cloth")
					.methode("+", "wear", "Tenue")
					.methode("+", "wear", "Outfit")
				.fleche("PairOfSocks", "Shirt")
				.fleche("PairOfSocks", "Cloth")
				.fleche("Shirt","Cloth")
		;

		Diagramme diagramme = diagrammeBuilder.getContent(null);

## Génération du diagramme via l’introspection
Il est possible de générer automatiquement le diagramme du type du projet grâce à l’introspection par **lancement de la procédure main située dans la classe Reflection dans le chemin ArchitectureLogicielle/src/main/**. Le résultat de l’analyse, c’est-à-dire le dessin se trouve dans ce cas également dans le fichier **output.svg**.

