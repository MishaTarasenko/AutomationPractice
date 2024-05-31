package ukma;

import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task1 {
    public static void main(String[] args) {
        String sample = "Hello World!";

        try {
            FileWriter writer = new FileWriter("Task1.txt");

            String md5Hash = hashString(sample, "MD5");
            System.out.println("MD5 Hash: " + md5Hash);
            writer.write("MD5 Hash: " + md5Hash + "\r\n");

            String sha1Hash = hashString(sample, "SHA-1");
            System.out.println("SHA-1 Hash: " + sha1Hash);
            writer.write("SHA-1 Hash: " + sha1Hash + "\r\n");

            String sha256Hash = hashString(sample, "SHA-256");
            System.out.println("SHA-256 Hash: " + sha256Hash);
            writer.write("SHA-256 Hash: " + sha256Hash + "\r\n");

            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String hashString(String string, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        byte[] hashBytes = messageDigest.digest(string.getBytes(StandardCharsets.UTF_8));

        return bytesToHex(hashBytes);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder strB = new StringBuilder();
        for (byte b : bytes) {
            strB.append(String.format("%02x", b));
        }
        return strB.toString();
    }
}