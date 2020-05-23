package controller;

import android.app.Application;
import android.app.DownloadManager;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AppController2 extends Application {
    public static final String TAG = AppController2.class.getSimpleName();
    private static AppController2 mInstance;
    private RequestQueue mRequestQueue;

    public static synchronized AppController2 getInstance()
    {
      /*  if(mInstance == null) {
            mInstance = new AppController2();
        } */

        return mInstance;
    }
          @Override
    public void onCreate(){
        super.onCreate();
        mInstance = this ;

          }
          public RequestQueue getRequestQueue()
          {
              if(mRequestQueue == null)
              {
                  mRequestQueue = Volley.newRequestQueue(getApplicationContext());
              }

              return mRequestQueue;
          }

          public <T> void addToRequestQueue(Request<T> req, String tag){
            req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
            getRequestQueue().add(req);

          }

          public <T> void addToRequestQueue(Request<T> req){
                req.setTag(TAG);
                getRequestQueue().add(req);

          }
          public void cancelPendingRequests(Object tag)
          {
              if ( mRequestQueue != null)
              {
                  mRequestQueue.cancelAll(tag);
              }
          }


}
