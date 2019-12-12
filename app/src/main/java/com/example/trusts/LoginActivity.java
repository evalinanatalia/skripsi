package com.example.trusts;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.trusts.model.RequestLogin;
import com.example.trusts.model.ResponseProfile;
import com.example.trusts.network.NetworkService;
import com.example.trusts.retrofit.RetrofitClient;
import com.example.trusts.support.Preferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText etUsername;
    EditText etPassword;
    Preferences mPreference;
    ResponseProfile responseProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPreference = new Preferences(this);

        btnLogin = (Button) findViewById(R.id.btn_login);
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                RequestLogin dataLogin = new RequestLogin();
                dataLogin.setUsername(etUsername.getText().toString());
                dataLogin.setPassword(etPassword.getText().toString());

                NetworkService service = RetrofitClient.getClient().create(NetworkService.class);
                Call<ResponseProfile> call = service.postLogin(dataLogin);

                call.enqueue(new Callback<ResponseProfile>() {
                    @Override
                    public void onResponse(Call<ResponseProfile> call, Response<ResponseProfile> response) {
                        responseProfile = response.body();
                        //Save User Data
                        mPreference.saveProfile(responseProfile.getData());
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<ResponseProfile> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "gagal",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
