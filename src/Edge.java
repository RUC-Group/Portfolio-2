
// class Edge, contains two vertecies that define from where to where the edge leads, with a weight.
class Edge implements Comparable<Edge>{
    Vertex from;
    Vertex to;
    Integer weight;
    
    // contructor
    public Edge(Vertex from, Vertex to, Integer weight){
        this.from = from; 
        this.to = to; 
        this.weight = weight;
    }
    
    // compare to method
    @Override
    public int compareTo(Edge o) {
        return this.weight.compareTo((o.weight));
    }
}
