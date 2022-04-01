
// Pair class, made to connect an edge and a vertex in the MST inside of the Heap. Contains the Vertex that it came from and the weight of it 
public class Pair implements Comparable<Pair>{
    Vertex previous;
    Integer distance;
    int index;

    // constructor
    public Pair(Vertex prev, Integer distance,int index){
        this.distance = distance;
        this.previous = prev;
        this.index = index;
    }

    // compare to method
    @Override
    public int compareTo(Pair o) {
        return this.distance.compareTo((o.distance));
    }
    
}
