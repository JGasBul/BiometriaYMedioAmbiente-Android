package com.example.beacondetecter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CallAPI  {

    String url = "http://192.168.70.246:8080/mediciones/guardar_mediciones";
    Context context;
    public CallAPI(Context context){
        this.context = context;
    }

    public void guardar_mediciones(Medidas medida) {
        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(context);
       StringRequest request = new StringRequest(Request.Method.POST, url, response -> {
           Toast.makeText(context, "Data added to API", Toast.LENGTH_SHORT).show();
           try {
               // on below line we are parsing the response
               // to json object to extract data from it.
               JSONObject respObj = new JSONObject(response);
           } catch (JSONException e) {
               e.printStackTrace();
           }
       }, error -> {
           Toast.makeText(context, "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
           Log.d(">>>>", "Fail to get response = " + error);
       }) {
           @Nullable
           @Override
           protected Map<String, String> getParams() throws AuthFailureError {
               // below line we are creating a map for
               // storing our values in key and value pair.
               Map<String, String> params = new HashMap<String, String>();

               // on below line we are passing our key
               // and value pair to our parameters.
               params.put("value", String.valueOf(medida.value));
               params.put("date", medida.date);

               // at last we are
               // returning our params.
               return params;
           }
       };
        // below line is to make
        // a json object request.
        queue.add(request);
    }

}

