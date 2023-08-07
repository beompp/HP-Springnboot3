package com.example.firstproject;

public class jsonParsing1 {

    public static void main(String[] args) {
        String jsonString = "{\"title\": \"how to get stroage size\","
                + "\"url\": \"https://codechacha.com/ko/get-free-and-total-size-of-volumes-in-android/\","
                + "\"draft\": false,"
                + "\"star\": 10"
                + "}";

        JSONObject jObject = new JSONObject(jsonString);
        String title = jObject.getString("title");
        String url = jObject.getString("url");
        boolean draft = jObject.getBoolean("draft");
        int star = jObject.getInt("star");

        System.out.println("title: " + title);
        System.out.println("url: " + url);
        System.out.println("draft: " + draft);
        System.out.println("star: " + star);

    }
}
