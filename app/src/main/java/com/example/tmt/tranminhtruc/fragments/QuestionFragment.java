package com.example.tmt.tranminhtruc.fragments;


import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tmt.tranminhtruc.R;
import com.example.tmt.tranminhtruc.adapters.QuestionAdapter;
import com.example.tmt.tranminhtruc.models.Question;
import com.example.tmt.tranminhtruc.utils.TaskCompleted;
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
public class QuestionFragment extends Fragment implements TaskCompleted {


    private Button btnNext;
    private ListView lvQuestion;
    private ProgressBar progressBar;

    private ArrayList<Question> questionArrayList;

    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        btnNext = (Button) view.findViewById(R.id.btn_next);

        lvQuestion = (ListView) view.findViewById(R.id.lv_question);

        if (checkInternetConnection()) {
            new ReadJSON(this).execute("https://myquestions.herokuapp.com/api/questions");
        }


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.custom_dialog_layout);
                dialog.setTitle("Nhập họ tên");
                dialog.show();
            }
        });

        return view;
    }

    public void setupDialog(Dialog dialog) {
        dialog.setContentView(R.layout.custom_dialog_layout);
        Button btnOK = (Button) dialog.findViewById(R.id.btn_ok);
        EditText edtName = (EditText) dialog.findViewById(R.id.edt_name);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onTaskComplete(ArrayList<Question> questionArrayList) {
        Log.d("Size: ", questionArrayList.size()+"");
    }

    class ReadJSON extends AsyncTask<String, Void, String> {

        private final TaskCompleted listener;

        public ReadJSON(TaskCompleted listener) {
            this.listener = listener;
        }


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

            if (s != null) {
                Question[] questionArr = new Gson().fromJson(s, Question[].class);
                ArrayList<Question> questionArrayList = new ArrayList<Question>(Arrays.asList(questionArr));

                QuestionAdapter adapter = new QuestionAdapter(getContext(), R.layout.question_item_layout, questionArrayList);
                lvQuestion.setAdapter(adapter);
                if (listener!=null){
                    listener.onTaskComplete(questionArrayList);
                }
                progressBar.setVisibility(View.GONE);
            } else {
                Toast.makeText(getContext(), "No data found", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean checkInternetConnection() {

        boolean status = true;

        ConnectivityManager connManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();

        if (networkInfo == null) {
            Toast.makeText(getContext(), "No default network is currently active", Toast.LENGTH_SHORT).show();
            status = false;
        }

        if (!networkInfo.isConnected()) {
            Toast.makeText(getContext(), "Network is not connected", Toast.LENGTH_SHORT).show();
            status = false;
        }

        if (!networkInfo.isAvailable()) {
            Toast.makeText(getContext(), "Network not available", Toast.LENGTH_SHORT).show();
            status = false;
        }

        return status;
    }

}
