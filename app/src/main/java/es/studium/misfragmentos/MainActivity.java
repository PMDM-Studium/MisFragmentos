package es.studium.misfragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAyuda;
    Button btnAcercaDe;
    FragmentManager fm = getSupportFragmentManager();
    Fragment ayuda;
    Fragment acerca;
    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAyuda = findViewById(R.id.btnAyuda);
        btnAcercaDe= findViewById(R.id.btnAcerca);
        btnAyuda.setOnClickListener(this);
        btnAcercaDe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
if(v.getId()==(R.id.btnAyuda))
{
    ayuda = fm.findFragmentByTag("ayuda");
    if(null == ayuda)
    {
        Bundle datosAEnviar = new Bundle();
        datosAEnviar.putLong("id", 123L);
        datosAEnviar.putInt("edad", 21);
        datosAEnviar.putString("nombre", "Lucas");

        Fragment fragmento = new Ayuda();
        fragmento.setArguments(datosAEnviar);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedorFragmento, fragmento);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
else
{
    acerca = fm.findFragmentByTag("acerca");
    if(null == acerca)
    {
        ft = fm.beginTransaction();
        ft.replace(R.id.contenedorFragmento, new AcercaDe(),"acerca");
        ft.commit();
    }
}
    }
}