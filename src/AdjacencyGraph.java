import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// class containing every method needed for an adjacency Graph
public class AdjacencyGraph {
    ArrayList<Vertex> Vertecies; // - list of all vertecies in the graph

    //constructor
    public AdjacencyGraph(){
        Vertecies = new ArrayList<>();
    }

    // method that adds a vertext to the graph
    public void addVertex(Vertex name) {
        Vertecies.add(name);
    }

    // method that adds an edge to the grap. This is bidirectional.
    public void addEdge(Vertex from, Vertex to, Integer weight) {
        if(!Vertecies.contains(from) && Vertecies.contains(to)){
            System.out.println("missing vertecies from graph");
            return;
        }
        else{
            Edge newE = new Edge(from, to, weight);
            Edge newErev = new Edge(to, from, weight);
            from.addEdgeToList(newE);
            to.addEdgeToList(newErev);
        }
    }

    // method that shows all vertecies and all of their connections to all the other vertecies. 
    public void printGraph(){
        for (int i = 0; i < Vertecies.size(); i++) {
            System.out.println(Vertecies.get(i).name + " is connected to: ");
            for (Edge edge : Vertecies.get(i).outEdges) {
                System.out.println("\t" +edge.to.name + " with weight: " + edge.weight);
            }
            System.out.println("");
        }
    }

    // prims algorithm
    public void primMST() {
        //initialization of heap and Maps
        MinHeap<Pair> q = new MinHeap<>();
        Map<Vertex, Integer> d = new HashMap<>();
        Map<Vertex, Vertex> p = new HashMap<>();

        //set 
        for (int i = 0; i < Vertecies.size(); i++) {
            d.put(Vertecies.get(i), Integer.MAX_VALUE);
            p.put(Vertecies.get(i), null);
            Pair newPair = new Pair(Vertecies.get(i), d.get(Vertecies.get(i)));
            q.Insert(newPair);
        }
        d.put(Vertecies.get(0), 0);

        // main loop in the algortihm 
        while (!q.isEmpty()) {
            Pair u = q.extractMin();  // - get minimum weight 
            for (int i = 0; i < u.previous.outEdges.size(); i++) {
                if (u.previous.outEdges.get(i).weight < d.get(u.previous.outEdges.get(i).to) && !u.previous.visited) {
                    d.put(u.previous.outEdges.get(i).to, u.previous.outEdges.get(i).weight);
                    p.put(u.previous.outEdges.get(i).to, u.previous);
                    int pos = q.getPosition(u);
                    q.decreasekey(pos);
                }
            }
            u.previous.visited = true;  // mark the node as visited 
        }
        //prints the minimum spanning tree
        printMST(p,d);

    }

    // method that prints minimum spanning tree, Used in Prims algorithm
    public void printMST( Map<Vertex, Vertex> p,  Map<Vertex, Integer> d) {
        int i = 0;
        int totalDist = 0;
        for (Vertex city : p.keySet()) {
            if(p.get(city) != null){
                System.out.println(i + ": city: " + city.getName() + " to " + p.get(city).getName() + " has distance " + d.get(city) + " km.");
            }
            i++;
            totalDist += d.get(city); 
        }

        System.out.println("total distance traveld " + totalDist + ".");
        System.out.println("total price to wire up the grid " + totalDist * 1000000 + "dkk.");
    }
}