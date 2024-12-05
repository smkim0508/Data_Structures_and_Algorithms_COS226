import edu.princeton.cs.algs4.Point2D;

public class Clustering {

    // helper function to check if argument is null
    private static <T> void checkArgNull(T arg) {
        if (arg == null) throw new IllegalArgumentException("argument is null");
    }

    // run the clustering algorithm and create the clusters
    public Clustering(Point2D[] locations, int k) {
        checkArgNull(locations);
        int loc_length = locations.length;

        for (int i = 0; i < loc_length; i++) checkArgNull(locations[i]);
        checkArgNull(k);
        if (k < 1 || k > loc_length)
            throw new IllegalArgumentException("k outside of expected range");


    }

    // return the cluster of the ith location
    public int clusterOf(int i) {

    }

    // use the clusters to reduce the dimensions of an input
    public int[] reduceDimensions(int[] input) {

    }

    // unit testing (required)
    public static void main(String[] args) {

    }
}
