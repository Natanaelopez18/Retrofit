package heartom.edu.simplecrud;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import heartom.edu.simplecrud.Otro.Usuario;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PacienteActivity extends AppCompatActivity  {

    private final String baseUrl = "http://192.168.56.1:3000";
    RecyclerView rvClientes;
    FloatingActionButton fabAdd;
    List<Usuario> listaPacientes = new ArrayList<>();
    PacienteAdapter adapter;
    PacienteService pacienteService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);

        iniciarControles();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rvClientes.setLayoutManager(llm);

        adapter = new PacienteAdapter(listaPacientes);
        rvClientes.setAdapter(adapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(rvClientes.getContext(),llm.getOrientation());
        rvClientes.addItemDecoration(itemDecoration);

        pacienteService = retrofit.create(PacienteService.class);

        Call<List<Usuario>> lista = pacienteService.getPacientes();
        lista.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if(response.isSuccessful()){
                    listaPacientes = response.body();
                    adapter = new PacienteAdapter(listaPacientes);
                    rvClientes.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {

            }
        });

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogo();
            }
        });

    }

    private void iniciarControles(){
        rvClientes = (RecyclerView) findViewById(R.id.rvClientes);
        fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
    }

    private void mostrarDialogo(){
        PacienteDialog dialog = new PacienteDialog();
        dialog.show(getSupportFragmentManager(),"dialog_fragment");
    }
/*
   @Override
    public void RegistrarPaciente(Usuario paciente) {

        final ProgressDialog dialog = new ProgressDialog(PacienteActivity.this);
        dialog.setMessage("Registrando");
        dialog.show();
        Call<Usuario> p = pacienteService.registrarPaciente(paciente);
        p.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful()){
                    Usuario usuarioResponse = response.body();
                    adapter.addPaciente(usuarioResponse);
                    Toast.makeText(getApplicationContext(),"CORRECTO", Toast.LENGTH_LONG).show();
                }
                if(dialog.isShowing()){
                    dialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                if(dialog.isShowing()){
                    dialog.dismiss();
                }
            }
        });
    }*/
}
