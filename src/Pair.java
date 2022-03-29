public class Pair implements Comparable<Pair>{
    Vertex previous;
    Integer distance;
    public Pair(Vertex prev, Integer distance){
        this.distance = distance;
        this.previous = prev;
    }
    @Override
    public int compareTo(Pair o) {
        return this.distance.compareTo((o.distance));
    }
    
}
