package basic_class_01;
import java.util.*;
//����תͼ
//�����0��λ���Ϸſ�ʼ�ڵ��ֵ��1��λ��Ŀ��ڵ��ֵ��2��λ����Ȩ��
public class GraphGenerator {
	public static Graph createGraph(Integer[][] matrix) {
		Graph graph = new Graph();
		for(int i = 0; i < matrix.length ; i++) {
			Integer from = matrix[i][0];
			Integer to = matrix[i][1];
			Integer weight = matrix[i][2];
			
			if (!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, new Node(from));
			}
			if (!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, new Node(to));
			}
			
			Node fromNode = graph.nodes.get(from);
			Node toNode = graph.nodes.get(to);
			Edge edge = new Edge(weight,fromNode, toNode);
			fromNode.nexts.add(toNode);
			fromNode.edges.add(edge);
			fromNode.out ++;
			toNode.in ++;
			graph.edges.add(edge);
		}
		return graph;
	}
	
}
