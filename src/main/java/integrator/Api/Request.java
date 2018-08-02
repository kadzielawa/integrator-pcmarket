package integrator.Api;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class Request extends RESTConnection {

    public String postRequest(String basePath, String json) {
        HttpURLConnection conn = openConnection(basePath);
        String output = "error";
        try {
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes());
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output = getOutput(conn);
                conn.disconnect();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return output;
    }

    public static void getRequest(String urlAddress) {

        HttpURLConnection conn = openConnection(urlAddress);

        try {
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

        } catch (IOException e) {
            e.printStackTrace();

        }

    }


}
