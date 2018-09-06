package basic_class_01;
import java.util.*;
// ͼ
public class Graph {
	public HashMap<Integer,Node> nodes;
	public HashSet<Edge> edges;
	
	public Graph() {
		nodes = new HashMap<Integer,Node>();
		edges = new HashSet<Edge>();
	}
}
