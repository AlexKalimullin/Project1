package com.example.project1;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadJSONE {

    public static ValutesModel readJSONFile(String string) throws IOException,JSONException {

        String jsonText = string;

        JSONObject jsonRoot = new JSONObject(jsonText);

        String date = jsonRoot.getString("Date");
        String previousDate = jsonRoot.getString("PreviousDate");
        String reviousURL = jsonRoot.getString("PreviousURL");
        String timestamp = jsonRoot.getString("Timestamp");

        JSONObject jsonObj = (JSONObject) jsonRoot.getJSONObject("Valute");

        ValutesModel valutesModel = new ValutesModel();
        List<ValuteModel> valuteModelList = new ArrayList<>();

        for (Iterator<String> it = jsonObj.keys(); it.hasNext(); ) {
            String key = it.next();
            JSONObject jsonChildObject = (JSONObject) jsonObj.getJSONObject(key);
            String id = jsonChildObject.getString("ID");
            String numCode = jsonChildObject.getString("NumCode");
            String charCode = jsonChildObject.getString("CharCode");
            int nominal = jsonChildObject.getInt("Nominal");
            String name = jsonChildObject.getString("Name");
            double value = jsonChildObject.getDouble("Value");
            double previous = jsonChildObject.getDouble("Previous");
            ValuteModel valuteModel = new ValuteModel(id, numCode, charCode, nominal, name, value, previous);
            valuteModelList.add(valuteModel);
        }

        valutesModel.setDate(date);
        valutesModel.setPreviousDate(previousDate);
        valutesModel.setPreviousURL(reviousURL);
        valutesModel.setTimestamp(timestamp);
        valutesModel.setValutesModelList(valuteModelList);

        return valutesModel;
    }
}

