import java.util.*;
public class Vertex implements Comparable <Vertex>{

    int ID;
    int x;
    int y;
    List <Integer> edges;
    boolean visited;
    double distance;

    public Vertex (int ID, int x, int y)
    {
        this.ID = ID;
        this.x = x;
        this.y = y;
        visited = false;
        edges = new ArrayList<>();
        distance = Double.POSITIVE_INFINITY;

    }
    public double getDistance (Vertex other)
    {
        double xDist = Math.pow (other.x - this.x, 2);
        double yDist = Math.pow(other.y - this.y,2);
        return Math.pow (xDist + yDist, 0.5);

    }

    @Override
    public int compareTo(Vertex o) {
        if (this.distance < o.distance)
            return -1;
        if (this.distance> o.distance)
            return 1;
        return 0;
    }

    public String toString ()
    {
        return "Vertex ID: " + this.ID + " Vertex Distance: " + this.distance;

    }
}
