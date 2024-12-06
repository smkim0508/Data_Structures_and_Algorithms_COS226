import edu.princeton.cs.algs4.CC;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.KruskalMST;
import edu.princeton.cs.algs4.Point2D;

public class Clustering {

    // helper function to check if argument is null
    private static <T> void checkArgNull(T arg) {
        if (arg == null) throw new IllegalArgumentException("argument is null");
    }

    // private array to track clusters
    private int[] cluster;
    // private variable to keep track of the number of locations
    private int locCount;

    // run the clustering algorithm and create the clusters
    public Clustering(Point2D[] locations, int k) {
        checkArgNull(locations);
        locCount = locations.length;

        for (int i = 0; i < locCount; i++) checkArgNull(locations[i]);
        checkArgNull(k);
        if (k < 1 || k > locCount)
            throw new IllegalArgumentException("k outside of expected range");

        EdgeWeightedGraph locationGraph = new EdgeWeightedGraph(locCount);
        EdgeWeightedGraph mstGraph = new EdgeWeightedGraph(locCount);

        // EdgeWeightedGraph between all point pairs
        for (int i = 0; i < locCount; i++) {
            for (int j = i + 1; j < locCount; j++) {
                locationGraph.addEdge(new Edge(i, j, locations[i].distanceTo(locations[j])));
            }
        }

        // fill mst
        KruskalMST mst = new KruskalMST(locationGraph);
        int edgeCount = 0;
        for (Edge edge : mst.edges()) {
            if (edgeCount < locCount - k) {
                mstGraph.addEdge(edge);
                edgeCount++;
            }
        }

        // finds connected components
        CC connected = new CC(mstGraph);
        cluster = new int[locCount];
        for (int i = 0; i < locCount; i++) {
            cluster[i] = connected.id(i);
        }
    }

    // return the cluster of the ith location
    public int clusterOf(int i) {
        checkArgNull(i);
        if (i < 0 || i > locCount - 1) throw new IllegalArgumentException("location out of bounds");
        return cluster[i];
    }

    // use the clusters to reduce the dimensions of an input
    public int[] reduceDimensions(int[] input) {

    }

    // unit testing (required)
    public static void main(String[] args) {

    }
}
