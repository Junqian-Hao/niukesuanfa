package basic_class_01;
import java.util.*;
//ͼ�Ľڵ�
public class Node {
	public int value;
	public int in;//���
	public int out;//����
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
