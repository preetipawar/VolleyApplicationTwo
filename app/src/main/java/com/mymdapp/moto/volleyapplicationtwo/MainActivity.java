package com.mymdapp.moto.volleyapplicationtwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView  id,title,body;
    String json_url="http://192.168.42.215/api/article/7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.button);
        id=(TextView)findViewById(R.id.tx1);
        title=(TextView)findViewById(R.id.tx2);
        body=(TextView)findViewById(R.id.tx3);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,json_url,(String) null,
                        new Response.Listener<JSONObject>()
                        {
                            @Override
                            public void onResponse(JSONObject response)
                            {
                                try
                                {
                                    id.setText(response.getString("id"));
                                    title.setText(response.getString("title"));
                                    body.setText(response.getString("body"));
                                }
                                catch (JSONException e)
                                {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener()
                        {

                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                Toast.makeText(MainActivity.this,"Smthng went wrong...",Toast.LENGTH_SHORT).show();
                                error.printStackTrace();
                            }
                        });

                MySingleton.getInstance(MainActivity.this).addToRequestque(jsonObjectRequest);
            }
        });

    }
}
