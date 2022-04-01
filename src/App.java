public class App {
    //Main method
    public static void main(String[] args) throws Exception {
        AdjacencyGraph electricalGrid = makeElectricGridGraph();
        //electricalGrid.printGraph();
        electricalGrid.primMST();

    }

    // creation of electrical grid graph
    public static AdjacencyGraph makeElectricGridGraph() {
        AdjacencyGraph electricGrid = new AdjacencyGraph();

        // create Vertecies
        Vertex eskildstrup = new Vertex("Eskildstrup",0);
        Vertex haslev = new Vertex("Haslev",1);
        Vertex holdbæk = new Vertex("Holdbæk",2);
        Vertex jærgerspris = new Vertex("Jægerspris",3);
        Vertex kalundborg = new Vertex("Kaldundborg",4);
        Vertex korsør = new Vertex("Korsør",5);
        Vertex køge = new Vertex("Køge",6);
        Vertex maribo = new Vertex("Maribo",7);
        Vertex nakskov = new Vertex("Nakskov",8);
        Vertex nykøbing = new Vertex("Nykøbing F.",9);
        Vertex næstved = new Vertex("Næstved",10);
        Vertex ringsted = new Vertex("Ringsted",11);
        Vertex roskilde = new Vertex("Roskilde",12);
        Vertex slagelse = new Vertex("Slagelse",13);
        Vertex sorø = new Vertex("Sorø",14);
        Vertex vordingborg = new Vertex("Vordingborg",15);

        //add Vertecies to graph
        electricGrid.addVertex(eskildstrup);
        electricGrid.addVertex(haslev);
        electricGrid.addVertex(holdbæk);
        electricGrid.addVertex(jærgerspris);
        electricGrid.addVertex(kalundborg);
        electricGrid.addVertex(korsør);
        electricGrid.addVertex(køge);
        electricGrid.addVertex(maribo);
        electricGrid.addVertex(nakskov);
        electricGrid.addVertex(nykøbing);
        electricGrid.addVertex(næstved);
        electricGrid.addVertex(ringsted);
        electricGrid.addVertex(roskilde);
        electricGrid.addVertex(slagelse);
        electricGrid.addVertex(sorø);
        electricGrid.addVertex(vordingborg);   
        
        // add Edges to the graph
        electricGrid.addEdge(eskildstrup, maribo, 28);
        electricGrid.addEdge(eskildstrup, nykøbing, 13);
        electricGrid.addEdge(eskildstrup, vordingborg, 24);
        electricGrid.addEdge(haslev, korsør, 60);
        electricGrid.addEdge(haslev, køge, 24);
        electricGrid.addEdge(haslev, næstved, 25);
        electricGrid.addEdge(haslev, ringsted, 19);
        electricGrid.addEdge(haslev, roskilde, 47);
        electricGrid.addEdge(haslev, slagelse, 48);
        electricGrid.addEdge(haslev, sorø, 34);
        electricGrid.addEdge(haslev, vordingborg, 40);
        electricGrid.addEdge(holdbæk, jærgerspris, 34);
        electricGrid.addEdge(holdbæk, kalundborg, 44);
        electricGrid.addEdge(holdbæk, korsør, 66);
        electricGrid.addEdge(holdbæk, ringsted, 36);
        electricGrid.addEdge(holdbæk, roskilde, 32);
        electricGrid.addEdge(holdbæk, slagelse, 46);
        electricGrid.addEdge(holdbæk, sorø, 34);
        electricGrid.addEdge(jærgerspris, korsør, 95);
        electricGrid.addEdge(jærgerspris, køge, 58);
        electricGrid.addEdge(jærgerspris, ringsted, 56);    
        electricGrid.addEdge(jærgerspris, roskilde, 33);
        electricGrid.addEdge(jærgerspris, slagelse, 74);
        electricGrid.addEdge(jærgerspris, sorø, 63);
        electricGrid.addEdge(kalundborg, ringsted, 62);
        electricGrid.addEdge(kalundborg, roskilde, 70);
        electricGrid.addEdge(kalundborg, slagelse, 39);
        electricGrid.addEdge(kalundborg, sorø, 51);
        electricGrid.addEdge(korsør, næstved, 45);
        electricGrid.addEdge(korsør, slagelse, 20);
        electricGrid.addEdge(køge, næstved, 45);
        electricGrid.addEdge(køge, ringsted, 28);
        electricGrid.addEdge(køge, roskilde, 25);
        electricGrid.addEdge(køge, vordingborg, 60);
        electricGrid.addEdge(maribo, nakskov, 27);
        electricGrid.addEdge(maribo, nykøbing, 26);
        electricGrid.addEdge(næstved, roskilde, 57);
        electricGrid.addEdge(næstved, ringsted, 26);
        electricGrid.addEdge(næstved, slagelse, 37);
        electricGrid.addEdge(næstved, sorø, 32);
        electricGrid.addEdge(næstved, vordingborg, 28);
        electricGrid.addEdge(ringsted, roskilde, 31);
        electricGrid.addEdge(ringsted, sorø, 15);
        electricGrid.addEdge(ringsted, vordingborg, 58);
        electricGrid.addEdge(slagelse, sorø, 14);

        return electricGrid;
    }
}
