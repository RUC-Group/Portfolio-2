

class Edge implements Comparable<Edge>{
    Vertex from;
    Vertex to;
    Integer weight;
    
    public Edge(Vertex from, Vertex to, Integer weight){
        this.from = from; 
        this.to = to; 
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Edge o) {
        return this.weight.compareTo((o.weight));
    }
}
