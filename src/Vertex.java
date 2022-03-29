import java.util.ArrayList;

public class Vertex {
    String name;
    ArrayList<Edge> outEdges;
    boolean visited = false;
    public Vertex(String name){
        this.name = name;
        outEdges = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEdgeToList(Edge edge) {
        outEdges.add(edge);
    }
    public ArrayList<Edge> getEdgeList() {
        return this.outEdges;
    }
}