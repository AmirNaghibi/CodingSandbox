package com.sandbox;

import okhttp3.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;

import java.io.IOException;

@Log
public class HttpExample {
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String getExample(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public String postExample(String url, String jsonBody) throws IOException {
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(jsonBody, JSON);
        
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) {
        HttpExample example = new HttpExample();
        
        try {
            // GET request example
            String getResponse = example.getExample("https://jsonplaceholder.typicode.com/posts/1");
            System.out.println("GET Response: " + getResponse);

            // POST request example
            String postBody = """
                {
                    "title": "foo",
                    "body": "bar",
                    "userId": 1
                }""";
            String postResponse = example.postExample("https://jsonplaceholder.typicode.com/posts", postBody);
            System.out.println("POST Response: " + postResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 