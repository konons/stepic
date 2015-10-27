package org.stepic.java;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Mikhail Valeyko on 25/10/2015.
 */
public class SymbolStream {
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        StringBuilder result = new StringBuilder();

        int nextByte = reader.read();
        while (nextByte != -1) {
            result.append((char) nextByte);
            nextByte = reader.read();
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        while (scanner.hasNext()) {
            try {
                sum += scanner.nextDouble();
            } catch (InputMismatchException e) {
                scanner.next();
            }
        }
        System.out.printf("%.6f", sum);
    }
}
