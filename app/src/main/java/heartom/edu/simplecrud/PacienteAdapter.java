package heartom.edu.simplecrud;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import heartom.edu.simplecrud.Otro.Usuario;


public class PacienteAdapter extends RecyclerView.Adapter<PacienteAdapter.PacienteViewHolder> {

    List<Usuario> lista;

    public PacienteAdapter(List<Usuario> lista) {
        this.lista = lista;
    }

    @Override
    public PacienteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.paciente_row,parent,false);

        return new PacienteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PacienteViewHolder holder, int position) {
        holder.bindPaciente(lista.get(position));
    }

    public void addPaciente(Usuario paciente){
        lista.add(paciente);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class PacienteViewHolder extends RecyclerView.ViewHolder{

        TextView tvNombre;
        TextView tvId;

        public PacienteViewHolder(View itemView) {
            super(itemView);
            tvNombre = (TextView) itemView.findViewById(R.id.tvPaciente);
            tvId = (TextView) itemView.findViewById(R.id.tvId);
        }

        public void bindPaciente(Usuario paciente){
            String nombre = paciente.getUserName() + " " + paciente.getEmail() + " " + paciente.getFechaCreada();
            tvNombre.setText(nombre);
            tvId.setText(String.valueOf(paciente.getId()));
        }


    }
}
