
class Arista<E> implements Comparable<Arista<E>> {
		Node<E> node1;
		Node<E> node2;
		int distacia;
		Arista(Node<E> node1, int distacia,Node<E> node2) {
			this.node1 = node1;
			this.distacia = distacia;
			this.node2 = node2;
		}
		public String toString() {
			return "("+ node1.value+" "+distacia+" "+node2.value+")";
		}
		
		@Override
		public int compareTo(Arista<E> o) {
			if(this.distacia > o.distacia) {
				return 1;
			}
			if(this.distacia < o.distacia) {
				return -1;
			}
			return 0;
		}
	}