package com.mp.firebase_ex2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    EditText et_email;
    EditText et_pw;
    Button bt_login;
    Button bt_getpw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        et_email = (EditText)findViewById(R.id.et_email);
        et_pw = (EditText)findViewById(R.id.et_pw);
        bt_login = (Button)findViewById(R.id.bt_upload);
        bt_getpw = (Button)findViewById(R.id.bt_check);

        bt_login.setOnClickListener(onClickListener);
        bt_getpw.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.bt_upload:
                    login();
                    break;
                case R.id.bt_check:
                    myStartActivity(PasswordResetActivity.class);
                    break;
            }
        }
    };
    private void login() {
        String email = et_email.getText().toString();
        String password = et_pw.getText().toString();
        if (email.length() > 0 && password.length() > 0) {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                startToast("로그인에 성공했습니다.");
                                FirebaseUser user = mAuth.getCurrentUser();
                                myStartActivity(MainActivity.class);
                            } else {
                                // If sign in fails, display a message to the user.
                                if(task.getException()!=null) {
                                    startToast(task.getException().toString());
                                }
                            }

                            // ...
                        }
                    });
        } else {
            startToast("이메일 또는 비밀번호를 입력해주세요!");
        }
    }

    private void startToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void myStartActivity(Class c){
        Intent intent = new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
