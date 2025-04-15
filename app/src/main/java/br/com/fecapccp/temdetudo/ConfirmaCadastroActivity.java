package br.com.fecapccp.temdetudo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfirmaCadastroActivity extends AppCompatActivity {

    private TextView txtBemVindo;
    private Button btnRetornar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirma_cadastro);

        txtBemVindo = findViewById(R.id.txtBemVindo);
        btnRetornar = findViewById(R.id.btnRetornar);

        Bundle bundle = getIntent().getExtras();

        assert bundle != null;
        String nomeCliente = bundle.getString("nome");

        txtBemVindo.setText("Bem-vindo(a), " + nomeCliente + "!");

        btnRetornar.setOnClickListener(v -> {
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}