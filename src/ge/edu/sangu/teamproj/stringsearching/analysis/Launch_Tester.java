package src.ge.edu.sangu.teamproj.stringsearching.analysis;

import src.ge.edu.sangu.teamproj.stringsearching.Text;
import src.ge.edu.sangu.teamproj.stringsearching.kmp.Tasks;
import src.ge.edu.sangu.teamproj.stringsearching.naive.Naive;
import src.ge.edu.sangu.teamproj.stringsearching.rabinkarp.RabinKarp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Launch_Tester {
    static long totalTime_rabin;
    static long totalTime_naive;
    static long totalTime_Kms;
    static String Substr;
    public static void main(String[] args) {

        PreApp((byte) 0); /** Invoke Console.ReadKey() Like Sequence */

        Substr = "su"; /** Static Check String Substring */

        Test_Rabin(Substr); /** Start RabinKarp Test */

        PreApp((byte) 1); /** Continue */

        Test_Naive(Substr); /** Start Naive Test */

        PreApp((byte) 1); /** Continue */

        Test_Kmp(Substr);

        PreApp((byte) -1); /** Finish */

        generateReport();
    }

    private static void Test_Rabin(String A){ /** alfa - Substring To Search */
        System.out.println(" Using Substring Finding Method: RabinKarp:::: \n");

        /** Starting Execution Time */

        long startTime = System.currentTimeMillis();

        RabinKarp RK = new RabinKarp();
        RK.findOccurences( new Text(File_Reader.TextReturn()), new Text(A));
        long endTime   = System.currentTimeMillis();

        /** Saving Execution Time */
        totalTime_rabin = endTime-startTime;

        System.out.println(" Check Te Indexes: \n" + RK.findOccurences( new Text(File_Reader.TextReturn()), new Text(A)));
        System.out.println(" Program Execution Used: " + (totalTime_rabin) + " MilliSeconds");
    }

    private static void Test_Naive(String A)
    {
        System.out.println(" Using Substring Finding Method: Naive:::: \n");

        /** Starting Execution Time */

        long startTime = System.currentTimeMillis();

        Naive RK = new Naive();
        RK.findOccurences( new Text(File_Reader.TextReturn()), new Text(A));
        long endTime   = System.currentTimeMillis();

        /** Saving Execution Time */
        totalTime_naive = endTime-startTime;

        System.out.println(" Check Te Indexes: \n" + RK.findOccurences( new Text(File_Reader.TextReturn()), new Text(A)));
        System.out.println(" Program Execution Used: " + (totalTime_naive) + " MilliSeconds");
    }

    private static void Test_Kmp(String A){
        System.out.println(" Using Substring Finding Method: Kmp:::: \n");

        /** Starting Execution Time */

        long startTime = System.currentTimeMillis();

        Tasks Kmp = new Tasks();
        Kmp.substringSearch(File_Reader.TextReturn(), A);
        long endTime   = System.currentTimeMillis();

        /** Saving Execution Time */
        totalTime_Kms = endTime-startTime;

        System.out.println(" Check Te Indexes: \n" + Kmp.substringSearch(File_Reader.TextReturn(), A));
        System.out.println(" Program Execution Used: " + (totalTime_Kms) + " MilliSeconds");
    }

    private static void PreApp(byte c){

        if (c == 0) {
            System.out.println(" \n Press Any Key To Start ...");
        }
        else if(c == 1){
            System.out.println(" \n Press Any Key To Continue ...");
        }
        else {
            System.out.println(" \n Press Any Key To Finish ...");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateReport(){
        System.out.println("\nSubstring Finding Method: RabinKarp Used Time: " + totalTime_rabin + " MilliSeconds");
        System.out.println("Substring Finding Method: Naive Used Time: " + totalTime_naive + " MilliSeconds");
        System.out.println("Substring Finding Method: Kms Used Time: " + totalTime_Kms + " MilliSeconds");
    }
}
