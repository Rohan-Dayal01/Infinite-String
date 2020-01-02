import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    //Try something with remainder. Also, dividing with whole longs, not floats
    static long repeatedString(String s, long n) {
        long slen = s.length();
        int[] apos = new int[s.length()];
        long numas=0;
        for(int x=0;x<apos.length;x++){
            if(s.substring(x,x+1).equals("a")){
                apos[x]=1;//all positions that contain 'a' given 1 for true
                numas++;
            }
        }
        long remlen = n%slen;//determining the number of remainder spots we must check
        long finas = (n/slen)*numas;
        for(int x=0;x<remlen;x++){
            if(apos[x]==1){
                finas++;
            }
        }
        return finas;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
