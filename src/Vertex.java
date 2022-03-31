import java.util.ArrayList;

//Vertex class, contains a list of all edges that connect to it, a name and a boolean defining if its been visited in a MST
public class Vertex {
    String name;
    ArrayList<Edge> outEdges;
    boolean visited = false;

    //constructor
    public Vertex(String name){
        this.name = name;
        outEdges = new ArrayList<>();
    }
    //getter for name
    public String getName() {
        return name;
    }
    // method that adds an edge to the list of edges
    public void addEdgeToList(Edge edge) {
        outEdges.add(edge);
    }

    // getter for list of edges
    public ArrayList<Edge> getEdgeList() {
        return this.outEdges;
    }
}