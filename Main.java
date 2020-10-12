import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Util util = new Util();
        int state = 10;
        int input = 10;
        int output = 10;
        //String fileName = args[0];
        String fileName = "fsm.txt";
        util.createFSMFile(fileName,state,input,output);
        Graph graph = util.toGraph(fileName);
        Atlas atlas = new Atlas();
        System.out.println("atlas: " + atlas.run(graph).length());
    }
}
