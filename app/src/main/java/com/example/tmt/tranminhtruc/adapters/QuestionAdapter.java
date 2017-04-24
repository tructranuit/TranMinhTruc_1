package com.example.tmt.tranminhtruc.adapters;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.tmt.tranminhtruc.R;
import com.example.tmt.tranminhtruc.models.Question;
import com.example.tmt.tranminhtruc.models.Result;

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

    class ViewHolder {
        TextView tvQuestion;
        RadioGroup radioGroup;
        RadioButton radOpt1;
        RadioButton radOpt2;
        RadioButton radOpt3;
        RadioButton radOpt4;

        ViewHolder(View view) {
            tvQuestion = (TextView) view.findViewById(R.id.tv_question);
            radioGroup = (RadioGroup) view.findViewById(R.id.radiogroup);
            radOpt1 = (RadioButton) view.findViewById(R.id.rad_opt1);
            radOpt2 = (RadioButton) view.findViewById(R.id.rad_opt2);
            radOpt3 = (RadioButton) view.findViewById(R.id.rad_opt3);
            radOpt4 = (RadioButton) view.findViewById(R.id.rad_opt4);
        }
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

//        Log.d("getview: ", position + " " + convertView);

        View view = convertView;
        ViewHolder viewHolder = null;

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.question_item_layout, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.radioGroup.setTag(position);

        final Question question = questionArrayList.get(position);

        viewHolder.tvQuestion.setText(question.getId() + " - " + question.getQuestion().toString());

        viewHolder.radOpt1.setText(question.getAnswers().get(0).getId() + ") " + question.getAnswers().get(0).getText());
        viewHolder.radOpt2.setText(question.getAnswers().get(1).getId() + ") " + question.getAnswers().get(1).getText());
        viewHolder.radOpt3.setText(question.getAnswers().get(2).getId() + ") " + question.getAnswers().get(2).getText());
        viewHolder.radOpt4.setText(question.getAnswers().get(3).getId() + ") " + question.getAnswers().get(3).getText());

        viewHolder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                switch (checkedId) {
                    case R.id.rad_opt1:
                        question.setCurrentAnswer(question.getAnswers().get(0).getId());
                        question.setCurrentAnswerPositon(0);
                        break;
                    case R.id.rad_opt2:
                        question.setCurrentAnswer(question.getAnswers().get(1).getId());
                        question.setCurrentAnswerPositon(1);
                        break;
                    case R.id.rad_opt3:
                        question.setCurrentAnswer(question.getAnswers().get(2).getId());
                        question.setCurrentAnswerPositon(2);
                        break;
                    case R.id.rad_opt4:
                        question.setCurrentAnswer(question.getAnswers().get(3).getId());
                        question.setCurrentAnswerPositon(3);
                        break;
                    default:
                        question.setCurrentAnswer(Question.NONE);
                        break;
                }
            }
        });

        if (question.getCurrentAnswer() != (Question.NONE)) {
            RadioButton radioButton = (RadioButton) viewHolder.radioGroup.getChildAt(question.getCurrentAnswerPositon());
            radioButton.setChecked(true);
        } else {
            viewHolder.radioGroup.clearCheck();
        }
        return view;
    }
}
