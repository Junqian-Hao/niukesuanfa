package basic_class_01;
import java.util.*;
//图的宽度优先遍历
public class Code_31_BFS {
	public static void bfs(Node node) {
		if(node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		HashSet<Node> set = new HashSet<Node>();
		
		queue.add(node);
		set.add(node);
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			System.out.println(cur.value);
			for(Node next : cur.nexts) {
				if(!set.contains(next)) {
					queue.add(next);
					set.add(next);
				}
			}
		}
	}
	public static void main(String[] args) {
		Integer[][] matrix = {{1,2,1},{1,4,1},{2,5,1},{2,3,1},{5,3,1},{3,7,1}};
		Graph graph = GraphGenerator.createGraph(matrix);
		Node node = graph.nodes.get(1);
		bfs(node);
	}
}
