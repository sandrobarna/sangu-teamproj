package src.ge.edu.sangu.teamproj.stringsearching;
import src.ge.edu.sangu.teamproj.stringsearching.rabinkarp.RabinKarp;

/**
 * Created by Mad-Asus on 06.02.2016.
 */

public class Launcher {
    public static void main(String[] args) {
        RabinKarp alfa = new RabinKarp();
        System.out.println(alfa.findOccurences(new Text("avtanasdasdas"),new Text("a")));
    }
}
