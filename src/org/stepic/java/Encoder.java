package org.stepic.java;

import java.io.*;

/**
 * Created by Mikhail Valeyko on 25/10/2015.
 */
public class Encoder {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        OutputStream out = System.out;

        int nextByte = in.read();
        int prevByte = nextByte;
        while (prevByte != -1) {
            nextByte = in.read();
            if (prevByte == 13 && nextByte == 10) {
                prevByte = nextByte;
                nextByte = in.read();
            }
            out.write(prevByte);
            prevByte = nextByte;
        }
        out.flush();
    }
}
