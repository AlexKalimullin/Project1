package com.example.project1;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadJson extends AsyncTask<String, Void, String> {

    private EditText editText;

    public DownloadJson(EditText editText)  {
        this.editText= editText;
    }

    @Override
    protected String doInBackground(String... params) {
        String textUrl = params[0];

        InputStream in = null;
        BufferedReader br= null;
        try {
            URL url = new URL(textUrl);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            int resCode = httpConn.getResponseCode();

            if (resCode == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
                br= new BufferedReader(new InputStreamReader(in));

                StringBuilder sb= new StringBuilder();
                String s= null;
                while((s= br.readLine())!= null) {
                    sb.append(s);
                    sb.append("\n");
                }
                return sb.toString();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            }catch (Exception ignored) {

            }
            try {
                br.close();
            }catch (Exception ignored) {

            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        if(result  != null){
            this.editText.setText(result);
            try {
                ValutesModel valutesModel = ReadJSONE.readJSONFile(result);
                this.editText.setText(valutesModel.toString());
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        } else{
            Log.e("MyMessage", "Failed to fetch data!");
        }
    }
}