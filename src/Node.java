

import java.util.ArrayList;

//import Dijkstra.GrafoArray;
//import Dijkstra.Node2;

public class Node<E> {
	E value;
	public ArrayList<Node<E>> vecinos = new ArrayList<Node<E>>();

	public ArrayList<Integer> aristas = new ArrayList<Integer>();

	public Node(E e) {
		this.value = e;
	}

	public E getValue() {
		return value;
	}

	public boolean equals(Object o) {
		return value.equals(((Node<E>) o).value);
	}

	public int getNumeroDeVecinos() {
		return vecinos.size();
	}

	public int size() {
		return vecinos.size();
	}

	public Node<E> getVecino(int i) {
		return vecinos.get(i);
	}

	public int getDistanciaDelVecinoI(int i) {
		return aristas.get(i);
	}

	public int getDistanciaHacia(Node<E> n) {
		
		int index = vecinos.indexOf(n);
//		System.out.println(index);
		if (index < 0) {
			return Graph.MaxVal;
		}
		return aristas.get(vecinos.indexOf(n));
	}

	public void addVecino(Node<E> a, int distancia) {
		vecinos.add(a);
		aristas.add(distancia);
	}

	public String toString() {
		return value.toString();
	}
}