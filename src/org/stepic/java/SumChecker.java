package org.stepic.java;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Mikhail Valeyko on 25/10/2015.
 */
public class SumChecker {
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int nextByte = inputStream.read();
        int checkSum = 0;
        while (nextByte != -1) {
            checkSum = Integer.rotateLeft(checkSum, 1) ^ (nextByte & 0xFF);
            nextByte = inputStream.read();
        }
        return checkSum;
    }

    public static void main(String[] args) throws IOException {
        InputStream stream = new ByteArrayInputStream(new byte[] {0x33, 0x45, 0x01});
        System.out.println(checkSumOfStream(stream));
    }
}
