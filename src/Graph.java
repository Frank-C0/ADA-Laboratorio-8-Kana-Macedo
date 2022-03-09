

import java.util.ArrayList;

public class Graph<E> {
	public static final int MaxVal = 9999; 
	public ArrayList<Node<E>> listNodes = new ArrayList<Node<E>>();
	public ArrayList<Arista<E>> listAristas = new ArrayList<Arista<E>>();
	public Graph() {
	}

	public Node<E> addVertex(E e) {
		Node<E> node = new Node<E>(e);
		listNodes.add(node);
		return node;
	}

	public void addUndirectedEdge(E nodo1, int distancia, E nodo2) {
		Node<E> node1 = null;
		for (Node<E> node : listNodes) {
			if (node.value.equals(nodo1)) {
				node1 = node;
			}
		}
		Node<E> node2 = null;
		for (Node<E> node : listNodes) {
			if (node.value.equals(nodo2)) {
				node2 = node;
			}
		}
		node1.addVecino(node2, distancia);
		node2.addVecino(node1, distancia);
		listAristas.add(new Arista<E>(node1, distancia, node2));
		listAristas.add(new Arista<E>(node2, distancia, node1));
	}
	public void addDirectedEdge(E nodo1, int distancia, E nodo2) {
		Node<E> node1 = null;
		for (Node<E> node : listNodes) {
			if (node.value.equals(nodo1)) {
				node1 = node;
			}
		}
		Node<E> node2 = null;
		for (Node<E> node : listNodes) {
			if (node.value.equals(nodo2)) {
				node2 = node;
			}
		}
		node1.addVecino(node2, distancia);
		listAristas.add(new Arista<E>(node1, distancia, node2));
	}

	public int size() {
		return listNodes.size();
	}

	public Node<E> getNode(int i) {
		return listNodes.get(i);
	}
	public int indexOf(Node<E> node) {
		return listNodes.indexOf(node);
	}
	public void printGrafo() {
		for (Node<E> node : listNodes) {
			System.out.print(node.value+" -> ");
			for (int i = 0; i < node.vecinos.size(); i++) {
				System.out.print("("+node.vecinos.get(i)+" "+node.getDistanciaDelVecinoI(i)+"),");
			}
			System.out.println();
		}
	}
}
