package basic_class_01;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
//深度优先遍历
public class Code_33_DFS {
    public static void dfs(Node node) {
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();

        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            for (Node n : pop.nexts) {
                if (!set.contains(n)) {
                    stack.add(pop);
                    stack.add(n);
                    set.add(n);
                    System.out.println(n.value);
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        Integer[][] matrix = {{1,2,1},{1,4,1},{2,5,1},{2,3,1},{5,3,1},{3,7,1}};
        Graph graph = GraphGenerator.createGraph(matrix);
        Node node = graph.nodes.get(1);
        dfs(node);
    }
}
