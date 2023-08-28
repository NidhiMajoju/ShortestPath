import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {
    int V;
    int E;

    int start;
    int end;
    Vertex [] list;

    public Graph (String fileName) throws FileNotFoundException {

        Scanner input = new Scanner(new File(fileName));

        this.V = input.nextInt();
        list = new Vertex[V];
        this.E = input.nextInt();
        input.nextLine();

        //construct individual vertices
        for (int i = 0; i<V; i++)
        {
            int ID = input.nextInt();
            int X = input.nextInt();
            int Y = input.nextInt();
            list [i] = new Vertex(ID,X, Y);
            input.nextLine();
        }

        //add edges to the list
        for (int i = 0; i<E; i++)
        {
            int index = input.nextInt();
            int edge = input.nextInt();
            list[index].edges.add(edge);
            input.nextLine();
        }
        start = input.nextInt();
        end = input.nextInt();

    }
    public double distance (int from, int to)
    {
        return list[from].getDistance(list[to]);
    }

}
