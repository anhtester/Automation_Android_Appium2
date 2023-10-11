package com.anhtester.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    public static String getJson(String filePath, String key) throws IOException, ParseException {
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader(filePath));
        return (String) jsonObject.get(key);
    }
}

