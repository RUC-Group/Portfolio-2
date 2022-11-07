import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// class containing every method needed for an adjacency Graph
public class AdjacencyGraph {
    ArrayList<Vertex> Vertecies = new ArrayList<>();; // - list of all vertecies in the graph

    // method that adds a vertext to the graph
    public void addVertex(Vertex v) {
        System.out.println("add vertext");
        for (Vertex vertex : Vertecies) {
            if(vertex.name.equals(v.name)){
                System.out.println("same");
                return;
            } 
        }
        System.out.println("different");
        Vertecies.add(v);
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
        MinHeap<Pair> q = new MinHeap<Pair>(); // heap containing Pair, From and weights/distances from adjacency graph
        Map<Vertex, Integer> d = new HashMap<>(); // Map that contains From and weights/distances for the minimum spanning tree
        Map<Vertex, Vertex> p = new HashMap<>(); // Map containing From and To destinatinos of vertecies for the minimum spanning tree
        ArrayList<Pair> VertexPairs=new ArrayList<>(); // List to store all Pairs, needed to acces and update correct pair
 
        for (int i = 0; i < Vertecies.size(); i++) {
            d.put(Vertecies.get(i), Integer.MAX_VALUE); //filling d values of vertices with infinite
            p.put(Vertecies.get(i), null); //setting previous vertices of vertices to null
        }
        System.out.println(Vertecies.size());
        d.put(Vertecies.get(0), 0);

        for (int i = 0; i < Vertecies.size(); i++) { //fill minheap with pairs of vertex and element of map d
            Pair newPair = new Pair(Vertecies.get(i), d.get(Vertecies.get(i)));
            VertexPairs.add(newPair);
            q.Insert(newPair);
        }
        int pos = q.getPosition(VertexPairs.get(0));
        q.decreasekey(pos); //update heap to follow correct heap order

        // main loop in the algortihm 
        while (!q.isEmpty()) {
            Pair u = q.extractMin();  // - get minimum weight 
            for (int i = 0; i < u.previous.outEdges.size(); i++) { // iterating through every edge outgoing from the vertex in u

                // if weight on current edge is smaller than the weight in the minimumspanning tree map AND the vertex we connect to has not been visited, do
                if (u.previous.outEdges.get(i).weight < d.get(u.previous.outEdges.get(i).to)  && !u.previous.outEdges.get(i).to.visited) {
                   
                    d.put(u.previous.outEdges.get(i).to, u.previous.outEdges.get(i).weight);  // swap the min weight saved in d with the new min weight 
                    p.put(u.previous.outEdges.get(i).to, u.previous);   // insert the vertex to the p Map

                    Pair pairV=VertexPairs.get(u.previous.outEdges.get(i).to.index); //searching for the pair with the vertex the edge is connecting to

                    pairV.distance = d.get(u.previous.outEdges.get(i).to); //updating the distance variable of the pair with the new min weight

                    pos = q.getPosition(pairV);
                    q.decreasekey(pos); //update heap to follow correct heap order
                    
                }
            }
            u.previous.visited = true;  // mark the node as visited 
        }
        printMST(p,d);

    }

    // method that prints minimum spanning tree, Used in Prims algorithm
    public void printMST( Map<Vertex, Vertex> p,  Map<Vertex, Integer> d) {
        int i = 1;
        int totalDist = 0;
        //show all connections in the mininmum spanning tree
        for (Vertex city : p.keySet()) {
            if(p.get(city) != null){
                System.out.println("Connection " + i +": " + p.get(city).getName() + " to " + city.getName() + " has distance " + d.get(city) + " km.");
            }
            i++;
            totalDist += d.get(city); 
        }
        //total distance and price
        System.out.println("\ntotal distance travelled " + totalDist + "km.");
        System.out.println("total price to wire up the grid " + totalDist * 1000000 + "dkk.");
    }
}