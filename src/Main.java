	
public class Main {

	public static void main(String[] args) {
		
		Graph<String> g = new Graph<String>();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		
		g.addUndirectedEdge("A", 4, "B");
		g.addUndirectedEdge("A",4 , "C");
		g.addUndirectedEdge("B", 2, "C");
		g.addUndirectedEdge("C",3 , "D");
		g.addUndirectedEdge("D", 3, "F");
		g.addUndirectedEdge("C",2 , "E");
		g.addUndirectedEdge("E", 3, "F");
		g.addUndirectedEdge("C", 4, "F");
		
		System.out.println("  Ejemplo 1\nGrafo:");
		g.printGrafo();
		Algoritmos<String> a1 = new Algoritmos<String>();
		
		Graph<String> resutadoPrim1= a1.prim(g);
		System.out.println("Resultado Algoritmo Prim:");
		resutadoPrim1.printGrafo();
		Graph<String> resutadoKruskal1= a1.kruskal(g);
		System.out.println("Resultado Algoritmo Kruskal:");
		resutadoKruskal1.printGrafo();
		
		// EJEMPLO 2
		Graph<String> g2 = new Graph<String>();
		g2.addVertex("A");
		g2.addVertex("B");
		g2.addVertex("C");
		g2.addVertex("D");
		g2.addVertex("E");
		g2.addVertex("F");
		g2.addVertex("G");
		
		g2.addUndirectedEdge("A",7,"B");
		g2.addUndirectedEdge("B",8,"C");
		g2.addUndirectedEdge("C",5,"E");
		g2.addUndirectedEdge("E",9,"G");
		g2.addUndirectedEdge("G",11,"F");
		g2.addUndirectedEdge("F",6,"D");
		g2.addUndirectedEdge("D",5,"A");
		g2.addUndirectedEdge("D",9,"B");
		g2.addUndirectedEdge("B",7,"E");
		g2.addUndirectedEdge("E",8,"F");
		g2.addUndirectedEdge("D",15,"E");
		
		
		System.out.println("  Ejemplo 2\nGrafo:");
		g2.printGrafo();
		Algoritmos<String> a2 = new Algoritmos<String>();
		
		Graph<String> resutadoPrim2= a2.prim(g2);
		System.out.println("Resultado Algoritmo Prim:");
		resutadoPrim2.printGrafo();
		Graph<String> resutadoKruskal2= a2.kruskal(g2);
		System.out.println("Resultado Algoritmo Kruskal:");
		resutadoKruskal2.printGrafo();
	}

}
