package ukma;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserModel {

    private int id;
    private String name;
    private String email;

    public static List<UserModel> getAll() throws IOException {
        ArrayList<UserModel> users = new ArrayList<>();
        File file = new File("/Users/k1ng/Documents/AutomationPractice/AutomationPractice3/model/src/main/resources/users.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        while(reader.ready()) {
            String line = reader.readLine();
            String[] split = line.split("&");
            System.out.println("Parse user --> id: " + split[0] + " name: " + split[1] + " email: " + split[2]);
            users.add(new UserModel(Integer.parseInt(split[0]), split[1], split[2]));
        }
        System.out.println();
        return users;
    }
}
