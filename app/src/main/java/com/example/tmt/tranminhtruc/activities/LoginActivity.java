package com.example.tmt.tranminhtruc.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tmt.tranminhtruc.R;
import com.example.tmt.tranminhtruc.utils.User;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText edtUserName;
    private EditText edtPassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUserName = (EditText) findViewById(R.id.edt_email);
        edtPassWord = (EditText) findViewById(R.id.edt_password);

        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void login() {

        final String user = edtUserName.getText().toString();
        final String pass = edtPassWord.getText().toString();

        if (!validate(user, pass)) {
            onLoginFailed();
            return;
        }

        btnLogin.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (user.equals(User.USERNAME) && pass.equals(User.PASSWORD)) {
                    onLoginSuccess();
                } else {
                    onLoginFailed();
                }
                progressDialog.dismiss();
            }
        }, 2000);
    }

    private void onLoginSuccess() {
        finish();
    }

    private void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        btnLogin.setEnabled(true);
    }

    private boolean validate(String user, String pass) {
        boolean valid = true;

        if (user.isEmpty()) {
            edtUserName.setError("Chưa nhập username");
            valid = false;
        } else {
            edtUserName.setError(null);
        }

        if (pass.isEmpty()) {
            edtPassWord.setError("Chưa nhập password");
            valid = false;
        } else {
            edtPassWord.setError(null);
        }

        return valid;
    }
}
