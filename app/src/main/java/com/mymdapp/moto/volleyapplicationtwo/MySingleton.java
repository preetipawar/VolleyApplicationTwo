package com.mymdapp.moto.volleyapplicationtwo;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by moto on 24-03-2019.
 */

public class MySingleton
{
    private static MySingleton mInstance;
    private RequestQueue requestQueue;
    private  static Context mCtx;
   // private Request<T> request;


    private MySingleton(Context context)
    {
        mCtx = context;
        requestQueue = getRequestQueue();
    }


    public RequestQueue getRequestQueue()
    {
        if(requestQueue==null)
        {
            requestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());

        }
        return requestQueue;
    }

    public static synchronized MySingleton getInstance(Context context)
    {
        if(mInstance == null)
        {
            mInstance = new MySingleton(context);
        }
        return mInstance;

    }

    public<T>  void addToRequestque(Request<T> request)
    {
        requestQueue.add(request);
    }







}
