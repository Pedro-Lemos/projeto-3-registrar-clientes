package br.com.fecapccp.temdetudo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FormCadastroActivity extends AppCompatActivity {

    private Button btnRegistrar;
    private TextView editTxtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_cadastro);

        btnRegistrar = findViewById(R.id.btnRegistrar);
        editTxtNome = findViewById(R.id.editTxtNome);


        btnRegistrar.setOnClickListener(v -> {
            Intent intent = new Intent(this, ConfirmaCadastroActivity.class);

            String txtNome = editTxtNome.getText().toString();
            if (txtNome.isEmpty()) {
                editTxtNome.setError("Campo obrigatório. Digite seu nome.");
                return;
            }
            intent.putExtra("nome", txtNome);

            startActivity(intent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}