package com.example.tmt.tranminhtruc.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tmt.tranminhtruc.R;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalInformationFragment extends Fragment {

    private TextView tvFullName;
    private TextView tvDayofBirth;
    private TextView tvAddress;
    private TextView tvEmail;
    private TextView tvPhoneNumber;
    private TextView tvWebsite;

    public PersonalInformationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_personal_information, container, false);

        tvFullName = (TextView) v.findViewById(R.id.tv_full_name);
        tvDayofBirth = (TextView) v.findViewById(R.id.tv_day_of_birth);
        tvAddress = (TextView) v.findViewById(R.id.tv_address);
        tvEmail = (TextView) v.findViewById(R.id.tv_email);
        tvPhoneNumber = (TextView) v.findViewById(R.id.tv_phone_number);
        tvWebsite = (TextView) v.findViewById(R.id.tv_website);

        tvAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.google.com/maps/place/KTX+Khu+B,+%C4%90HQG/@10.8819859,106.780436,17z/data=!3m1!4b1!4m5!3m4!1s0x3174d89aad780e49:0x54542761d4c22175!8m2!3d10.8819859!4d106.7826247";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        tvPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+tvPhoneNumber.getText()));
                startActivity(intent);
            }
        });

        tvWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tvWebsite.getText().toString()));
                startActivity(intent);
            }
        });
        return v;
    }

}
