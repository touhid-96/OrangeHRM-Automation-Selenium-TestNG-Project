package Utils;

import Config.EmployeeModel;
import com.github.javafaker.Faker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    static String adminFileLocation = "./src/test/resources/admin.json";
    static String empFileLocation = "./src/test/resources/employees.json";

    public static JSONObject getAdmin() throws IOException, ParseException {
        //read file
        JSONParser jsonParser = new JSONParser();
        JSONArray adminJsonArray = (JSONArray) jsonParser.parse(new FileReader(adminFileLocation));
        JSONObject adminJsonObj = (JSONObject) adminJsonArray.get(0);

        return adminJsonObj;
    }

    public static JSONObject getFakerInfo() {
        Faker faker = new Faker();
        JSONObject fakerObj = new JSONObject();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        fakerObj.put("firstName", firstName);
        fakerObj.put("lastName", lastName);
        fakerObj.put("username", firstName+"."+lastName);

        return fakerObj;
    }

    public static void saveEmployee(EmployeeModel empModel) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONArray empJsonArray = (JSONArray) jsonParser.parse(new FileReader(empFileLocation));

        JSONObject empObj = new JSONObject();
        empObj.put("firstName", empModel.getFirstName());
        empObj.put("lastName", empModel.getLastName());
        empObj.put("username", empModel.getUsername());
        empObj.put("password", empModel.getPassword());
        empObj.put("empID", empModel.getEmpID());

        empJsonArray.add(empObj);

        //file write
        FileWriter fileWriter = new FileWriter(empFileLocation);
        fileWriter.write(empJsonArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }
}
