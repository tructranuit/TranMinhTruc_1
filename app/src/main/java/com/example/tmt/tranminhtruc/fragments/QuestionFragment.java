package com.example.tmt.tranminhtruc.fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmt.tranminhtruc.R;
import com.example.tmt.tranminhtruc.adapters.QuestionAdapter;
import com.example.tmt.tranminhtruc.models.Question;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {


    private Button btnNext;
    private TextView tvQuestion;
    private RadioGroup radioGroup;
    private RadioButton radOpt1;
    private RadioButton radOpt2;
    private RadioButton radOpt3;
    private RadioButton radOpt4;
    private ListView lvQuestion;
    private ProgressBar progressBar;

    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
//        tvQuestion = (TextView) view.findViewById(R.id.tv_question);
//
//        radioGroup = (RadioGroup) view.findViewById(R.id.radiogroup);
//        radOpt1 = (RadioButton) view.findViewById(R.id.rad_opt1);
//        radOpt2 = (RadioButton) view.findViewById(R.id.rad_opt2);
//        radOpt3 = (RadioButton) view.findViewById(R.id.rad_opt3);
//        radOpt4 = (RadioButton) view.findViewById(R.id.rad_opt4);
        btnNext = (Button) view.findViewById(R.id.btn_next);

        lvQuestion = (ListView) view.findViewById(R.id.lv_question);

        if (checkInternetConnection()) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    new ReadJSON().execute("https://myquestions.herokuapp.com/api/questions");
                }
            });
        }


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

//    public void checkAnswer() {
//        int radioID = radioGroup.getCheckedRadioButtonId();
//        if (radioID == -1) {
//            Toast.makeText(getContext(), "Chưa chọn câu trả lời", Toast.LENGTH_SHORT).show();
//        }
//        switch (radioID) {
//            case R.id.rad_opt1:
//                break;
//            case R.id.rad_opt2:
//                break;
//            case R.id.rad_opt3:
//                break;
//            case R.id.rad_opt4:
//                break;
//        }
//    }

    class ReadJSON extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
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
            ArrayList<Question> questionArrayList = new ArrayList<>();
            try {
                if (s != null) {
                    JSONObject jsonRootObject = new JSONObject(s);
                    JSONArray jsonArray = jsonRootObject.optJSONArray("List_Questions");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        questionArrayList.add(new Question(
                                jsonObject.getString("Question"),
                                jsonObject.getString("Option1"),
                                jsonObject.getString("Option2"),
                                jsonObject.getString("Option3"),
                                jsonObject.getString("Option4")
                        ));
                    }
                }

                QuestionAdapter adapter = new QuestionAdapter(getContext(), R.layout.question_item_layout, questionArrayList);
                lvQuestion.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean checkInternetConnection() {

        ConnectivityManager connManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();

        if (networkInfo == null) {
            Toast.makeText(getContext(), "No default network is currently active", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!networkInfo.isConnected()) {
            Toast.makeText(getContext(), "Network is not connected", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!networkInfo.isAvailable()) {
            Toast.makeText(getContext(), "Network not available", Toast.LENGTH_SHORT).show();
            return false;
        }
        Toast.makeText(getContext(), "Network OK", Toast.LENGTH_SHORT).show();
        return true;
    }

}
