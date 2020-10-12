class Edge {
    int source;
    int destination;
    int input;
    int output;
    int weight;
    int label;

    public Edge(int label, int source,int destination, int input, int output, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.input = input;
        this.output = output;
        this.label = label;
    }
    public int getLabel(){
        return this.label;
    }
}
