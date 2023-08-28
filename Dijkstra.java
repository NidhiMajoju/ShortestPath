import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {

    Graph graph;
    Queue<Vertex> path;

    public static void main (String[] args) throws FileNotFoundException {
        Graph graph = new Graph("input6.txt");
        Dijkstra obj = new Dijkstra(graph);
        System.out.println(obj.distance(graph.start, graph.end));
    }

    public Dijkstra (Graph graph)  {

        this.graph = graph;
        path = new PriorityQueue<>();
    }
    public double distance (int source, int destination)
    {
        graph.list[source].distance = 0;
        path.offer(graph.list[source]);
        dijkstra(source, destination);

        //return distance of the destination
        return graph.list[destination].distance;

    }
    private void dijkstra (int source, int destination)
    {
        while (!path.isEmpty())
        {
            Vertex current = path.poll();
            int index = 0;
            for (int i = 0; i<current.edges.size(); i++)
            {
                int edgeIndex = current.edges.get(i);
                if (!graph.list[edgeIndex].visited)
                {

                    // add to edge distance?
                    //starting source has a distance of 0;
                    // if (a to b + a's distance is less that b's distance, then b distances becomes the sum

                    double potentialDistance = current.getDistance(graph.list[edgeIndex]) + current.distance;
                    if (potentialDistance < graph.list[edgeIndex].distance)
                    {
                        graph.list[edgeIndex].distance = potentialDistance;
                    }
                    path.offer (graph.list[edgeIndex]);
//                    old code
//                    double dist = current.getDistance(graph.list[edgeIndex]);
//                    if (dist<distance)
//                    {
//                        index = edgeIndex;
//                         distance = dist;
//                    }
                }

                           }
            // path.offer(graph.list[index]);
            // current.distance = distance;
            current.visited = true;

        }

    }

}
