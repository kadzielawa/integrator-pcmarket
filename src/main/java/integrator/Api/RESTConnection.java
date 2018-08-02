package integrator.Api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class RESTConnection {

    private static final String BASE_URL = "xxx";
    private static final String X_AUTH_KEY = "xxx";

    static HttpURLConnection openConnection(String basePath) {
        HttpURLConnection conn = null;
        String urlAddress = BASE_URL + basePath;
        try {
            URL url = new URL(urlAddress);
            conn = (HttpURLConnection) url.openConnection();
            conn.addRequestProperty("X-Auth-Key", X_AUTH_KEY);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return conn;
    }

    static String getOutput(HttpURLConnection conn) {

        StringBuilder output = null;

        try {
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String outputByLine;
            while ((outputByLine = br.readLine()) != null) {
                output.append(outputByLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();

    }
}
