package com.example.tmt.tranminhtruc.adapters;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.tmt.tranminhtruc.R;
import com.example.tmt.tranminhtruc.models.Question;

import java.util.ArrayList;

/**
 * Created by tmtruc on 19/04/2017.
 */

public class QuestionAdapter extends ArrayAdapter<Question> {

    ArrayList<Question> questionArrayList;
    Context context;

    public QuestionAdapter(Context context, int layoutId, ArrayList<Question> arrayList) {
        super(context, layoutId, arrayList);
        questionArrayList = new ArrayList<>();
        questionArrayList.addAll(arrayList);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.question_item_layout, null);
        }

        TextView tvQuestion = (TextView) view.findViewById(R.id.tv_question);
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radiogroup);
        RadioButton radOpt1 = (RadioButton) view.findViewById(R.id.rad_opt1);
        RadioButton radOpt2 = (RadioButton) view.findViewById(R.id.rad_opt2);
        RadioButton radOpt3 = (RadioButton) view.findViewById(R.id.rad_opt3);
        RadioButton radOpt4 = (RadioButton) view.findViewById(R.id.rad_opt4);

        final Question question = questionArrayList.get(position);

        tvQuestion.setText(question.getQuestion().toString());
        radOpt1.setText(question.getOption1().toString());
        radOpt2.setText(question.getOption2().toString());
        radOpt3.setText(question.getOption3().toString());
        radOpt4.setText(question.getOption4().toString());

        // final int radioId = radioGroup.getCheckedRadioButtonId();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rad_opt1:
                        question.setSelect(1);
                        break;
                    case R.id.rad_opt2:
                        question.setSelect(2);
                        break;
                    case R.id.rad_opt3:
                        question.setSelect(3);
                        break;
                    case R.id.rad_opt4:
                        question.setSelect(4);
                        break;
                    default:
                        question.setSelect(0);
                        break;
                }
            }
        });

        question.setQuestion_ID(position+1);

        return view;
    }
}
