package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText etEmail;
    private TextInputEditText etPassword;
    private TextInputLayout tilEmail;
    private TextInputLayout tilPassword;
    private CheckBox cbRememberMe;
    private Button btnLogin;
    private Button btnGoogleLogin;
    private TextView tvForgotPassword;
    private TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi komponen
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        tilEmail = findViewById(R.id.tilEmail);
        tilPassword = findViewById(R.id.tilPassword);
        cbRememberMe = findViewById(R.id.cbRememberMe);
        btnLogin = findViewById(R.id.btnLogin);
        btnGoogleLogin = findViewById(R.id.btnGoogleLogin);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvRegister = findViewById(R.id.tvRegister);

        // Aksi klik tombol login
        btnLogin.setOnClickListener(v -> validateAndLogin());

        btnGoogleLogin.setOnClickListener(v ->
                Toast.makeText(LoginActivity.this, "Google Sign-In belum diimplementasikan", Toast.LENGTH_SHORT).show()
        );

        tvForgotPassword.setOnClickListener(v ->
                Toast.makeText(LoginActivity.this, "Fitur lupa password belum diimplementasikan", Toast.LENGTH_SHORT).show()
        );

        tvRegister.setOnClickListener(v ->
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class))
        );
    }

    private void validateAndLogin() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        boolean isValid = true;

        if (email.isEmpty()) {
            tilEmail.setError("Email tidak boleh kosong");
            isValid = false;
        } else {
            tilEmail.setError(null);
        }

        if (password.isEmpty()) {
            tilPassword.setError("Password tidak boleh kosong");
            isValid = false;
        } else {
            tilPassword.setError(null);
        }

        if (isValid) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
    }
}
