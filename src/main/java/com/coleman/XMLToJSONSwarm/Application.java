package com.coleman.XMLToJSONSwarm;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Application {

    public static void main(String[] args) throws IOException {
        File file = new File("testing.xml");

        InputStream is = new FileInputStream(file);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();
        while(line != null){
            sb.append(line).append("\n");
            line = buf.readLine();
        }
        String XMLString = sb.toString();
        int PRETTY_PRINT_INDENT = 4;

        try {
            JSONObject xmlJSONObj = XML.toJSONObject(XMLString);
            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT);
            System.out.println(jsonPrettyPrintString);
        } catch(JSONException je){
            System.out.println(je);
        }


    }
}
