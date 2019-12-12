package com.example.trusts;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.example.trusts.model.Profile;
import com.example.trusts.support.Preferences;

public class ProfileActivity extends AppCompatActivity {
    EditText nama, alamat, jenis_kelamin;
    Preferences mPreferences;
    Profile profile;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile);
            initToolbar(R.id.toolbar);

            mPreferences = new Preferences(this);

            nama = (EditText) findViewById(R.id.et_name);
            alamat = (EditText)findViewById(R.id.et_alamat);
            jenis_kelamin = (EditText)findViewById(R.id.jenis_kelamin);

            profile = mPreferences.getProfile();

            if(profile!=null) {
                nama.setText(profile.getNama_lengkap());
                alamat.setText(profile.getAlamat());
                jenis_kelamin.setText(profile.getJenis_kelamin());
            }
        }

        public void initToolbar(int toolbarId) {
        Toolbar toolbar = (Toolbar) findViewById(toolbarId);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            assert getSupportActionBar() != null;
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }

}
