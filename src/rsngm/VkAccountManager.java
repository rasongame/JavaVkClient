package rsngm;


import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class VkAccountManager {
    private String access_token;
    private HttpClient client;
    public static VkAccountManager instance;
    public String first_name, last_name, status;
    private VkAccountManager() {
        client = HttpClient.newHttpClient();
    }


    public boolean login(String login) throws IOException, InterruptedException {
        String buffer = "";
        access_token = login;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(
                        URI.create(
                                String.format("https://api.vk.com/method/account.getProfileInfo?access_token=%s&v=5.110",
                                        login)))
                .build();
        HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());
        buffer = resp.body();
        System.out.println(buffer);
        JSONObject object_1 = (JSONObject) JSONValue.parse(buffer);
        JSONObject parsed = (JSONObject) object_1.get("response");
        System.out.println(parsed.get("first_name"));
        first_name = parsed.get("first_name").toString();
        last_name = parsed.get("last_name").toString();
        status = parsed.get("status").toString();
        return false;

    }

    private String getMethodString(String method, String args) {
        return String.format("https://api.vk.com/method/%s?%s&access_token=%s&v=5.110",
                method, args, access_token);
    }

    public void sendMessage(String peer_id, String msg) throws IOException, InterruptedException {
        String buffer = "";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(
                        URI.create(
                                getMethodString("messages.send",
                                        "peer_id=" + peer_id + "&message=" + msg)))
                .build();
        HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());
        buffer = resp.body();
        return;
    }

    public static VkAccountManager getInstance() {
        if (instance == null) {
            instance = new VkAccountManager();
        }
        return instance;

    }
}
