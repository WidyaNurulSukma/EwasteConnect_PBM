package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    private TextInputEditText etEmail, etPassword;
    private TextInputLayout tilEmail, tilPassword;
    private Button btnRegister, btnGoogleSignIn;
    private TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize views
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        tilEmail = findViewById(R.id.tilEmail);
        tilPassword = findViewById(R.id.tilPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnGoogleSignIn = findViewById(R.id.btnGoogleSignIn);
        tvLogin = findViewById(R.id.tvLogin);

        // Set click listeners
        btnRegister.setOnClickListener(view -> validateAndRegister());

        btnGoogleSignIn.setOnClickListener(view ->
                Toast.makeText(this, "Google Sign-In belum diimplementasikan", Toast.LENGTH_SHORT).show()
        );

        tvLogin.setOnClickListener(view -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
    }

    private void validateAndRegister() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        boolean isValid = true;

        // Validasi email
        if (email.isEmpty()) {
            tilEmail.setError("Email tidak boleh kosong");
            isValid = false;
        } else if (!isValidEmail(email)) {
            tilEmail.setError("Format email tidak valid");
            isValid = false;
        } else {
            tilEmail.setError(null);
        }

        // Validasi password
        if (password.isEmpty()) {
            tilPassword.setError("Password tidak boleh kosong");
            isValid = false;
        } else if (password.length() < 6) {
            tilPassword.setError("Password minimal 6 karakter");
            isValid = false;
        } else {
            tilPassword.setError(null);
        }

        // Jika validasi berhasil
        if (isValid) {
            startActivity(new Intent(this, RegistrationSuccessActivity.class));
            finish();
        }
    }

    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }
}
