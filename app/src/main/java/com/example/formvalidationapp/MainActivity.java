package com.example.formvalidationapp;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextSurname;
    private EditText editTextEmail;
    private EditText editPhoneNumber;
    private EditText editPassword;
    private EditText editCheckPassword;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextname);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextEmail = findViewById(R.id.editTextEmail);
        editPhoneNumber = findViewById(R.id.editPhonenumber);
        editPassword = findViewById(R.id.editPassword);
        editCheckPassword = findViewById(R.id.editCheckPassword);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String surname = editTextSurname.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String phone = editPhoneNumber.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                String checkpassword = editCheckPassword.getText().toString().trim();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić Imię", Toast.LENGTH_SHORT).show();
                } else if (surname.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić nazwisko", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić adres e-mail", Toast.LENGTH_SHORT).show();
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(MainActivity.this, "Niepoprawny adres e-mail", Toast.LENGTH_SHORT).show();
                } else if (phone.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić numer telefonu", Toast.LENGTH_SHORT).show();
                } else if (phone.length() <9) {
                    Toast.makeText(MainActivity.this, "Niepoprawny numer telefonu", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić hasło", Toast.LENGTH_SHORT).show();
                } else if (password.length() <6) {
                    Toast.makeText(MainActivity.this, "Hasło jest za krótkie! Wprowadz conajmniej 6 znaków", Toast.LENGTH_SHORT).show();
                } else if (checkpassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Wprowadź ponownie hasło", Toast.LENGTH_SHORT).show();
                } else if (!checkpassword.matches(password)) {
                    Toast.makeText(MainActivity.this, "Hasła nie są takie same", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Formularz przesłany poprawnie", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


