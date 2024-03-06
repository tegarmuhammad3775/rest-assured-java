package azurewebsite.payload;

import org.json.simple.JSONObject;
import java.util.Random;

public class user {
    Random rand = new Random();

    public  JSONObject createUsers(){
        JSONObject data = new JSONObject();
        data.put("id",10);
        data.put("username","user"+rand.nextInt(100));
        data.put("password","12345");
        return data;
    }

    public  JSONObject updateUsers(){
        JSONObject data = new JSONObject();
        data.put("id",10);
        data.put("username","user"+rand.nextInt(100));
        data.put("password","78910");
        return data;
    }
}
