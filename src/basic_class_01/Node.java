package basic_class_01;
import java.util.*;
//图的节点
public class Node {
	public int value;
	public int in;//入度
	public int out;//出度
	public ArrayList<Node> nexts;
	public ArrayList<Edge> edges;
	
	public Node(int value) {
		this.value = value;
		in = 0;
		out = 0;
		this.nexts = new ArrayList<Node>();
		this.edges = new ArrayList<Edge>();
	}
}
