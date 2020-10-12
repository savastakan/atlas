import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public Graph toGraph(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
        Graph graph = new Graph();
        int label = 0;
        for(String line; (line = br.readLine()) != null; ) {
            Pattern regex = Pattern.compile("^(\\d*)\\s--\\s(\\d*)\\s/\\s(\\d*)\\s->\\s(\\d*)");
            Matcher regexMatcher = regex.matcher(line);
            while (regexMatcher.find()) {
                int state_ = Integer.parseInt(regexMatcher.group(1));
                int input_ =  Integer.parseInt(regexMatcher.group(2));
                int output_ =  Integer.parseInt(regexMatcher.group(3));
                int nextState_ =  Integer.parseInt(regexMatcher.group(4));
                graph.addEdge(label, state_,nextState_,input_,output_,1);
                if (state_ == 0) {
                    graph.addStart(label);
                }
                label++;
            }
        }
        return graph;
    }


    public void createFSMFile(String fileName, int state, int input, int output) throws IOException {
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec("tools/fsm-gen-fsm " +output+ " " +input+ " " +state+ " " +(state*input)+ " 0");
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName)));
        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }
}
