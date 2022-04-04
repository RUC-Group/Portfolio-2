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

    // method that adds an edge to the grap. This is undirected.
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
        MinHeap q = new MinHeap(); // heap containing Pair, From and weights/distances from adjacency graph
        Map<Vertex, Integer> d = new HashMap<>(); // Map that contains From and weights/distances for the minimum spanning tree
        Map<Vertex, Vertex> p = new HashMap<>(); // Map containing From and To destinatinos of vertecies for the minimum spanning tree
        ArrayList<Pair> VertexPairs=new ArrayList<>();

        //set 
        for (int i = 0; i < Vertecies.size(); i++) {
            d.put(Vertecies.get(i), Integer.MAX_VALUE);
            p.put(Vertecies.get(i), null);
        }
        d.put(Vertecies.get(0), 0);

        for (int i = 0; i < Vertecies.size(); i++) {
            Pair newPair = new Pair(Vertecies.get(i), d.get(Vertecies.get(i)));
            VertexPairs.add(newPair);
            q.Insert(newPair);
        }
        int pos = q.getPosition(VertexPairs.get(0));
        q.decreasekey(pos);

        // main loop in the algortihm 
        while (!q.isEmpty()) {
            Pair u = q.extractMin();  // - get minimum weight 
            for (int i = 0; i < u.previous.outEdges.size(); i++) {

                // if weight on current edge is smaller than the Weight in the minimumspanning tree map AND the vertex is not visited, do
                if (u.previous.outEdges.get(i).weight < d.get(u.previous.outEdges.get(i).to)  && !u.previous.outEdges.get(i).to.visited) {
                   
                    d.put(u.previous.outEdges.get(i).to, u.previous.outEdges.get(i).weight);  // swap current weight with the min weight saved in d
                    p.put(u.previous.outEdges.get(i).to, u.previous);   // insert the vertex to the p Map
                    pos = q.getPosition(VertexPairs.get(u.previous.outEdges.get(i).to.index));
                    VertexPairs.get(u.previous.outEdges.get(i).to.index).distance = d.get(u.previous.outEdges.get(i).to);
                    q.decreasekey(pos); //update heap to follow correct heap order
                    
                }
            }
            u.previous.visited = true;  // mark the node as visited 
        }
        printMST(p,d);

    }

    // method that prints minimum spanning tree, Used in Prims algorithm
    public void printMST( Map<Vertex, Vertex> p,  Map<Vertex, Integer> d) {
        int i = 0;
        int totalDist = 0;
        //show all connections in the mininmum spanning tree
        for (Vertex city : p.keySet()) {
            if(p.get(city) != null){
                System.out.println(i + ": city: " + city.getName() + " to " + p.get(city).getName() + " has distance " + d.get(city) + " km.");
            }
            i++;
            totalDist += d.get(city); 
        }
        //total distance and price
        System.out.println("total distance traveld " + totalDist + ".");
        System.out.println("total price to wire up the grid " + totalDist * 1000000 + "dkk.");
    }
}