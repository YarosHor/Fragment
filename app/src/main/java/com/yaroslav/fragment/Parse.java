package com.yaroslav.fragment;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class Parse {

    public Contact[] parse(Context context, String fileName) {
        int id;
        String name;
        String surname1;
        String surname2;
        String birth;
        String company;
        String email;
        String phone1;
        String phone2;
        String adress;
        try {
            JSONArray jsonArray = new JSONArray(read(context, fileName));
            Contact[] datos = new Contact[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                // create a JSONObject for fetching single user data
                JSONObject userDetail = jsonArray.getJSONObject(i);
                // fetch email and name and store it in arraylist
                id = userDetail.getInt("id");
                name = userDetail.getString("name");
                surname1 = userDetail.getString("firstSurname");
                surname2 = userDetail.getString("secondSurname");
                birth = userDetail.getString("birth");
                company = userDetail.getString("company");
                email = userDetail.getString("email");
                phone1 = userDetail.getString("phone1");
                phone2 = userDetail.getString("phone2");
                adress = userDetail.getString("address");
                datos[i] = new Contact(id, name, surname1, surname2,birth ,company ,email ,phone1 ,phone2 ,adress);
            }
            return  datos;
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String read(Context context, String fileName) throws IOException {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return jsonString;

    }
}
