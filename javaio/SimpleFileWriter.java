package javaio;

import java.io.*;

/**
 * Created by danwoo on 2016-08-01.
 */
public class SimpleFileWriter {
    public static void main(String[] args) {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w = null;
        try {
            w = new PrintWriter(new File("out.txt"));
            String s = null;
            while ((s = r.readLine()) != null) {
                w.println(s);
            }
            w.flush(); // PrintWriter 의 내부에 Buffer 존재, Buffer is Full / .close() is called. (not guaranteed)
            w.close();
            r.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
