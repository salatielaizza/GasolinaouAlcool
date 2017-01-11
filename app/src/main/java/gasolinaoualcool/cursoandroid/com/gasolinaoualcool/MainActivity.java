package gasolinaoualcool.cursoandroid.com.gasolinaoualcool;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //localizar os componentes na tela
        precoAlcool = (EditText) findViewById(R.id.precoAlcoolID);
        precoGasolina = (EditText) findViewById(R.id.precoGasolinaID);
        botaoVerificar = (Button) findViewById(R.id.botaoVerificarID);
        textoResultado = (TextView) findViewById(R.id.textoResultadoID);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //recupera os valores digitados e transforma em String, getText()
                String textoPrecoAlcool = precoAlcool.getText().toString();
                String textoPrecoGasolina = precoGasolina.getText().toString();

                //transformar o String dos preços dos combustiveis em Double
                Double valorAlcool = Double.parseDouble(textoPrecoAlcool);
                Double valorGasolina = Double.parseDouble(textoPrecoGasolina);

                //cálculo para ver qual combustivel compensa utilizar
                double resultado = valorAlcool / valorGasolina;

                if (resultado >= 0.7){
                    textoResultado.setText("Compensa utilizar Gasolina");
                }else {
                    textoResultado.setText("Compensa utilizar Álcool");
                }
            }
        });
    }
}
