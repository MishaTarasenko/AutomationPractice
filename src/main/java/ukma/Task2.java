package ukma;

import java.io.FileWriter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Task2 {
    public static void main(String[] args) {
        String sample = "Hello World!";

        try {
            FileWriter writer = new FileWriter("Task2.txt");

            long sha1prngHash = hashString(sample, "SHA1PRNG");
            System.out.println("MD5 Hash: " + sha1prngHash);
            writer.write("MD5 Hash: " + sha1prngHash + "\r\n");

            long nativePRNGHash = hashString(sample, "NativePRNG");
            System.out.println("SHA-1 Hash: " + nativePRNGHash);
            writer.write("SHA-1 Hash: " + nativePRNGHash + "\r\n");

            long drbgHash = hashString(sample, "DRBG");
            System.out.println("SHA-256 Hash: " + drbgHash);
            writer.write("SHA-256 Hash: " + drbgHash + "\r\n");

            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static long hashString(String input, String algorithm) throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance(algorithm);
        sr.setSeed(9119);
        sr.nextBytes(input.getBytes());
        long number = sr.nextLong();
        return number;
    }
}
