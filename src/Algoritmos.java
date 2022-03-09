import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Algoritmos<E> {
	public Graph<E> prim(Graph<E> G) {
		System.out.println("\tAlgoritmo de Prim");
		Graph<E> grafo = new Graph<E>();

		ArrayList<E> visitados = new ArrayList<E>();
		visitados.add(G.listNodes.get(0).value);
		
		for (Node<E> e : G.listNodes) {
			grafo.addVertex(e.value);
		}
		
		ArrayList<Arista<E>> aristasVecinas = new ArrayList<Arista<E>>();
		Node<E> nodeActual = G.getNode(0);
		
		for (int i = 0; i < nodeActual.vecinos.size(); i++) {
			if (!visitados.contains(nodeActual.getVecino(i).value)){
				aristasVecinas.add(
						new Arista<E>(nodeActual, 
								nodeActual.getDistanciaDelVecinoI(i), 
								nodeActual.getVecino(i)));
			}
		}
		while (!aristasVecinas.isEmpty()) {
			System.out.println("Aristas adyasentes al subgrafo:\n\t"+aristasVecinas);
			// Buscar la minima arista adyacente al subgrafo
			Arista<E> aristaMenorDistancia = aristasVecinas.get(0);
			for (int i = 1; i < aristasVecinas.size(); i++) {
				int nuevaDistancia = aristasVecinas.get(i).distacia;
				if (nuevaDistancia < aristaMenorDistancia.distacia) {
					aristaMenorDistancia = aristasVecinas.get(i);
				}
			}
			
			// Añadir arista a visitados y al grafo
			visitados.add(aristaMenorDistancia.node2.value);
			grafo.addUndirectedEdge(
					aristaMenorDistancia.node1.value, 
					aristaMenorDistancia.distacia, 
					aristaMenorDistancia.node2.value);
			System.out.println("  Añadir: "+aristaMenorDistancia.node1.value+" "+aristaMenorDistancia.distacia+ " "+ aristaMenorDistancia.node2.value);

			List<Node<E>> vecinos = aristaMenorDistancia.node2.vecinos;
			// añadir sus vecinos no visitados
			for (int i = 0; i <vecinos.size(); i++) {
				if (!visitados.contains(vecinos.get(i).value)) {
						aristasVecinas.add(new Arista<E>(
								aristaMenorDistancia.node2,
								aristaMenorDistancia.node2.getDistanciaDelVecinoI(i),
								vecinos.get(i)));
				}
			}
			// remover aristas que generan bucles
			for (int i = 0; i < aristasVecinas.size();) {
				if (visitados.contains(aristasVecinas.get(i).node1.value)
						&& visitados.contains(aristasVecinas.get(i).node2.value)) {
					aristasVecinas.remove(aristasVecinas.get(i));
				} else {
					i++;
				}
			}
			aristasVecinas.remove(aristaMenorDistancia);
		}
		return grafo;
	}
	

	public Graph<E> kruskal(Graph<E> G) {
		System.out.println("\tAlgoritmo de Kruskal");
		ArrayList<Arista<E>> listaDeAristas = new ArrayList<Arista<E>>();
		listaDeAristas.addAll(G.listAristas);
			
		Collections.sort(listaDeAristas);
		
		Graph<E> grafo = new Graph<E>();

		for (Node<E> node: G.listNodes) {
			grafo.addVertex(node.value);
		}
		// contar nodos
		int t = G.size();

		ArrayList<ArrayList<E>> tempSubGrafos = new ArrayList<ArrayList<E>>();
		for (int i = 0, v = 0; v < t && i < listaDeAristas.size(); i++) {
			int j = 0;
			for (; j < tempSubGrafos.size(); j++) {
//				System.out.println("Subgrafos:");
//				for (int h = 0; h < tempSubGrafos.size(); h++) {
//					System.out.println((h+1)+": "+tempSubGrafos.get(h));
//				}
				boolean generaBucle = false; 
				for (ArrayList<E> subgrafo : tempSubGrafos) {
//					System.out.println(listaDeAristas.get(i).node1.value+" "+listaDeAristas.get(i).node2.value+
//							"\n\t"+subgrafo);
					if(subgrafo.contains(listaDeAristas.get(i).node1.value)&&
							subgrafo.contains(listaDeAristas.get(i).node2.value)) {
						generaBucle = true;
						break;
					}
				}
				if (generaBucle) {
					System.out.println("Genera bucle: "+ listaDeAristas.get(i).node1.value+" "+listaDeAristas.get(i).node2.value);
					break;
				} else if (tempSubGrafos.get(j).contains(listaDeAristas.get(i).node1.value)) { // no genera bucle, insertar a
																								// subgrafo
					boolean b = false;
					int k = 0;
					for (; k < tempSubGrafos.size(); k++) { // el otro nodo esta en un subgrafo?
						if (tempSubGrafos.get(k).contains(listaDeAristas.get(i).node2.value)) {
							b = true;
							break;
						}
					}
					if (b) { // si el otro nodo esta en un subgrafo, se conbinan los subgrafos
						tempSubGrafos.get(k).addAll(tempSubGrafos.get(j));
						tempSubGrafos.remove(j);
						System.out.println("La arista une dos grafos\\nconbinar subgrafos");
					} else { // de lo contrario, solo se añade el otro nodo al subgrafo
						tempSubGrafos.get(j).add(listaDeAristas.get(i).node2.value);
					}
					grafo.addUndirectedEdge(listaDeAristas.get(i).node1.value, listaDeAristas.get(i).distacia, listaDeAristas.get(i).node2.value);

					System.out.println("Añadir: "+listaDeAristas.get(i).node1.value + "  " + listaDeAristas.get(i).node2.value + "  " + listaDeAristas.get(i).distacia);
					v++;
					break;
				} else if (tempSubGrafos.get(j).contains(listaDeAristas.get(i).node2.value)) { // no genera bucle, insertar a subgrafo
					boolean b = false;
					int k = 0;
					for (; k < tempSubGrafos.size(); k++) { // el otro nodo esta en un subgrafo?
						if (tempSubGrafos.get(k).contains(listaDeAristas.get(i).node1.value)) {
							b = true;
							break;
						}
					}
					
					grafo.addUndirectedEdge(listaDeAristas.get(i).node1.value, listaDeAristas.get(i).distacia, listaDeAristas.get(i).node2.value);
					System.out.println("Añadir: "+listaDeAristas.get(i).node1.value + "  " + listaDeAristas.get(i).node2.value + "  " + listaDeAristas.get(i).distacia);
					v++;
					if (b) { // si el otro nodo esta en un subgrafo, se conbinan los subgrafos
						tempSubGrafos.get(k).addAll(tempSubGrafos.get(j));
						tempSubGrafos.remove(j);
						System.out.println("La arista une dos grafos\nconbinar subgrafos");
					} else { // de lo contrario, solo se añade el otro nodo al subgrafo
						tempSubGrafos.get(j).add(listaDeAristas.get(i).node1.value);
					}
					
					break;
				}
			}
			if (j == tempSubGrafos.size()) { // nuevo subgrafo
				ArrayList<E> s = new ArrayList<E>();
				s.add(listaDeAristas.get(i).node1.value);
				s.add(listaDeAristas.get(i).node2.value);
				tempSubGrafos.add(s);
				grafo.addUndirectedEdge(listaDeAristas.get(i).node1.value, listaDeAristas.get(i).distacia, listaDeAristas.get(i).node2.value);
				System.out.println("Nuevo Subgrafo :"+listaDeAristas.get(i).node1.value + "  " + listaDeAristas.get(i).node2.value + "  " + listaDeAristas.get(i).distacia);
				v++;
			}
		}
		return grafo;
	}
}
