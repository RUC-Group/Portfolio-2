public class Pair implements Comparable<Pair>{
    Vertex previous;
    Integer distance;
    public Pair(Vertex vertex, Integer distance){
        this.distance = distance;
        this.previous = vertex;
    }
    @Override
    public int compareTo(Pair o) {
        return this.distance.compareTo((o.distance));
    }
    
}
