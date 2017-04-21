package com.example.tmt.tranminhtruc.fragments;


import android.app.Dialog;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmt.tranminhtruc.R;
import com.example.tmt.tranminhtruc.models.Question;
import com.example.tmt.tranminhtruc.models.Result;
import com.example.tmt.tranminhtruc.utils.TaskCompleted;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

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

    private int questionID = 0;

    //public static ArrayList<Question> questionArrayList = new ArrayList<>();

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

        Button btnNext = (Button) view.findViewById(R.id.btn_next);


//        String s = null;
//        try {
//            s = new ReadJSON().execute("https://myquestions.herokuapp.com/api/questions").get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        Question[] questionArr = new Gson().fromJson(s, Question[].class);
//        final ArrayList<Question> questionArrayList = new ArrayList<>(Arrays.asList(questionArr));
//
//        setQuestionView(questionArrayList.get(questionID));
//
//        final ArrayList<Result> resultArrayList = new ArrayList<>();
//
//
//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int checkID = radioGroup.getCheckedRadioButtonId();
//                Result result = null;
//                switch (checkID){
//                    case R.id.rad_opt1:
//                        result = new Result(questionID+1, questionArrayList.get(questionID).getAnswers().get(0).getId());
//                        break;
//                    case R.id.rad_opt2:
//                        result = new Result(questionID+1, questionArrayList.get(questionID).getAnswers().get(1).getId());
//                        break;
//                    case R.id.rad_opt3:
//                        result = new Result(questionID+1, questionArrayList.get(questionID).getAnswers().get(2).getId());
//                        break;
//                    case R.id.rad_opt4:
//                        result = new Result(questionID+1, questionArrayList.get(questionID).getAnswers().get(3).getId());
//                        break;
//                }
//                resultArrayList.add(questionID, result);
//
//                if (questionID < questionArrayList.size() - 1) {
//                    questionID++;
//                    setQuestionView(questionArrayList.get(questionID));
//                }else {
//                    Dialog dialog = new Dialog(getContext());
//                    dialog.setContentView(R.layout.custom_dialog_layout);
//                    dialog.setTitle("Nhập họ tên");
//                    dialog.show();
//                }
//            }
//        });

        return view;
    }


    public void setQuestionView(Question question) {
        tvQuestion.setText(question.getId() + " - " + question.getQuestion().toString());
        radOpt1.setText(question.getAnswers().get(0).getId() + " - " + question.getAnswers().get(0).getText());
        radOpt2.setText(question.getAnswers().get(1).getId() + " - " + question.getAnswers().get(1).getText());
        radOpt3.setText(question.getAnswers().get(2).getId() + " - " + question.getAnswers().get(2).getText());
        radOpt4.setText(question.getAnswers().get(3).getId() + " - " + question.getAnswers().get(3).getText());
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
//            if (s != null) {
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

//                Question[] questionArr = new Gson().fromJson(s, Question[].class);
//                ArrayList<Question> questionArrayList = new ArrayList<>(Arrays.asList(questionArr));

            //               Log.d("Size: ", questionArrayList.size()+"");

//                questionArrayList = questionList.getList_Questions();
//               QuestionAdapter adapter = new QuestionAdapter(getContext(), R.layout.question_item_layout, questionArrayList);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
        }
    }

    // Check internet connection
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
