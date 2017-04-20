package com.example.tmt.tranminhtruc.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.tmt.tranminhtruc.R;
import com.example.tmt.tranminhtruc.adapters.QuestionAdapter;
import com.example.tmt.tranminhtruc.models.Question;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private TextView tvQuestion;
    private RadioGroup radioGroup;
    private RadioButton radOpt1;
    private RadioButton radOpt2;
    private RadioButton radOpt3;
    private RadioButton radOpt4;


    public static ArrayList<Question> questionArrayList = new ArrayList<>();

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        tvQuestion = (TextView) view.findViewById(R.id.tv_question);
        radioGroup = (RadioGroup) view.findViewById(R.id.radiogroup);
        radOpt1 = (RadioButton) view.findViewById(R.id.rad_opt1);
        radOpt2 = (RadioButton) view.findViewById(R.id.rad_opt2);
        radOpt3 = (RadioButton) view.findViewById(R.id.rad_opt3);
        radOpt4 = (RadioButton) view.findViewById(R.id.rad_opt4);

        ReadJSON readJSON = new ReadJSON();
        readJSON.execute("https://myquestions.herokuapp.com/api/questions");

        if (readJSON.getStatus() == AsyncTask.Status.FINISHED) {
            Log.d("Size: ", questionArrayList.size() + "");
        }


        return view;
    }

    class ReadJSON extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            StringBuilder stringBuilder = new StringBuilder();
            try {
                URL url = new URL(params[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setAllowUserInteraction(false);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                bufferedReader.close();
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return stringBuilder.toString();
        }

        @Override
        protected void onPostExecute(String s) {

//            try {
            if (s != null) {
//                    JSONObject jsonRootObject = new JSONObject(s);
//                    JSONArray jsonArray = jsonRootObject.getJSONArray("List_Questions");
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//                        questionArrayList.add(new Question(
//                                jsonObject.getString("Question"),
//                                jsonObject.getString("Option1"),
//                                jsonObject.getString("Option2"),
//                                jsonObject.getString("Option3"),
//                                jsonObject.getString("Option4")
//                        ));
//                    }
//                }

                Question[] questionArr = new Gson().fromJson(s, Question[].class);
                questionArrayList = new ArrayList<>(Arrays.asList(questionArr));
                //               Log.d("Size: ", questionArrayList.size()+"");

//                questionArrayList = questionList.getList_Questions();
//               QuestionAdapter adapter = new QuestionAdapter(getContext(), R.layout.question_item_layout, questionArrayList);
//            } catch (JSONException e) {
//                e.printStackTrace();
            }
        }
    }

}
