package ukma;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("Task3.txt");
        testPhone(writer);
        writer.write("\n\n");
        testBrokenPhone(writer);
        writer.close();
    }

    private static void testPhone(FileWriter writer) throws IOException {
        Phone phone1 = new Phone(2023, "Iphone 15pro");
        Phone phone2 = new Phone(2022, "Iphone 14pro");
        Phone phone3 = new Phone(2023, "Iphone 15pro");

        Map<Phone, Integer> map = new HashMap<>();
        map.put(phone1, 1);
        map.put(phone2, 2);
        map.put(phone3, 3);
        for (Map.Entry<Phone, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            String hash = entry.getKey().hashCode() + "";
            writer.append(hash + "\n");
        }
        System.out.println(map.get(new Phone(2022, "Iphone 14pro")));
    }

    private static void testBrokenPhone(FileWriter writer) throws IOException {
        BrokenPhone phone1 = new BrokenPhone(2023, "Iphone 15pro");
        BrokenPhone phone2 = new BrokenPhone(2022, "Iphone 14pro");
        BrokenPhone phone3 = new BrokenPhone(2023, "Iphone 15pro");

        Map<BrokenPhone, Integer> map = new HashMap<>();
        map.put(phone1, 1);
        map.put(phone2, 2);
        map.put(phone3, 3);
        for (Map.Entry<BrokenPhone, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            String hash = entry.getKey().hashCode() + "";
            writer.append(hash + "\n");
        }
        System.out.println(map.get(new BrokenPhone(2022, "Iphone 14pro")));
    }
}
