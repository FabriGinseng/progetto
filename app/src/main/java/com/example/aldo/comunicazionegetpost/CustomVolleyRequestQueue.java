package com.example.aldo.comunicazionegetpost;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by Aldo on 18/05/2017.
 */

public class CustomVolleyRequestQueue {
    private static CustomVolleyRequestQueue mInstance;
    private static Context mcontext;
    private RequestQueue requestQueue;

    private CustomVolleyRequestQueue(Context context){
        mcontext = context;
        this.requestQueue = getRequestQueue();
    }

    public static synchronized CustomVolleyRequestQueue getInstance(Context context){
        if(mInstance == null)
            mInstance = new CustomVolleyRequestQueue(context);
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        if (this.requestQueue == null){
            requestQueue = Volley.newRequestQueue(mcontext.getApplicationContext());
        }
        return this.requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req){
        getRequestQueue().add(req);
    }


}
