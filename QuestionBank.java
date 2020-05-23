package data;

import android.nfc.Tag;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import controller.AppController2;
import controller.appcontroller;
import model.Question;

public class QuestionBank {
   ArrayList<Question> questionArrayList = new ArrayList<>();
    private String url = "https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json" ;
    public List<Question> getQuestions(final AnswerListAsyncResponse callBack)
    {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                (JSONArray) null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                     //   Log.d("JSON Stuff","onResponse: " + response);
for(int i=0;i<response.length();i++)
{

    try {
        Question question = new Question();
        question.setAnswer(response.getJSONArray(i).get(0).toString());
        question.setAnswerTrue(response.getJSONArray(i).getBoolean(1));

// add question object to list
        questionArrayList.add(question);
       // Log.d("HELLO", "onResponse: " + question.getAnswer());




       // Log.d("JSON", "onResponse: " + response.getJSONArray(i).get(0)) ;

     //   Log.d("JSON", "onResponse: " + response.getJSONArray(i).getBoolean(1)) ;
    } catch (JSONException e) {
        e.printStackTrace();
    }


}
         if(null != callBack) callBack.processFinished(questionArrayList);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController2.getInstance().addToRequestQueue(jsonArrayRequest);

        return questionArrayList;

    }

}
