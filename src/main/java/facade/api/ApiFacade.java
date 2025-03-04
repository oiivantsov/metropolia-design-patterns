package facade.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ApiFacade {

    public String getAttributeValueFromJson(String urlString, String attributeName) throws IOException {
        String jsonResponse = fetchJsonFromApi(urlString);
        return parseJsonForAttribute(jsonResponse, attributeName);
    }

    private String fetchJsonFromApi(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            return content.toString();
        } finally {
            con.disconnect();
        }
    }

    private String parseJsonForAttribute(String json, String attributeName) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);

            // support for nested attributes using dot notation (e.g., "rates.USD")
            // use regular expression to split attribute name by dot (dot escaped with double backslash because it's a special character)
            String[] keys = attributeName.split("\\.");
            Object value = jsonObject;

            for (String key : keys) {
                if (value instanceof JSONObject) {
                    value = ((JSONObject) value).get(key);
                } else {
                    throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in JSON response.");
                }
            }

            if (value == null) {
                throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in JSON response.");
            }

            return value.toString();
        } catch (ParseException e) {
            throw new IllegalArgumentException("Failed to parse JSON response.", e);
        }
    }
}
