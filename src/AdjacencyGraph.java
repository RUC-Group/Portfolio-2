import java.util.ArrayList;
import java.util.Arrays;

public class AdjacencyGraph {
    ArrayList<Vertex> Vertecies;
    public AdjacencyGraph(){
        Vertecies = new ArrayList<>();
    }

    public void addVertex(Vertex name) {
        Vertecies.add(name);
    }

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

    public void printGraph(){
        for (int i = 0; i < Vertecies.size(); i++) {
            System.out.println(Vertecies.get(i).name + " is connected to: ");
            for (Edge edge : Vertecies.get(i).outEdges) {
                System.out.println("\t" +edge.to.name + " with weight: " + edge.weight);
            }
            System.out.println("");
        }
    }
    public void primMST() {
        
    }

    /*
    public void primMST() {
        Integer[] d = new Integer[Vertecies.size()];
        Vertex[] p = new Vertex[Vertecies.size()];
        MinHeap<Pair> q = new MinHeap<Pair>();
        Arrays.fill(d, Integer.MAX_VALUE);
        Arrays.fill(p, null);
        if(Vertecies.size() > 0){
            d[0] = 0;
            p[0] = Vertecies.get(0);
        }

        for (int i = 0; i < d.length; i++) {
            Pair newPair = new Pair(Vertecies.get(i), d[i]); //<--- noget med d[i]
            q.Insert(newPair);
        }
        while (!q.isEmpty()) {
            Pair pair = q.extractMin();
            for (int i = 0; i < pair.previous.outEdges.size() - 1; i++) {
                if (pair.previous.outEdges.get(i).weight < d[i] && !pair.previous.visited) {
                    d[i] = pair.previous.outEdges.get(i).weight;
                    p[i] = pair.previous; 
                    q.decreasekey(i);
                }
            }
            pair.previous.visited = true;
        }
        System.out.println("MST vertecies: ");
        for (int i = 0; i < p.length; i++) {
            if (p[i] != null) {
                System.out.println("city: " + p[i].name + " to " + i + " has distance " + d[i]);
            }
        }
       
    }
    */
}