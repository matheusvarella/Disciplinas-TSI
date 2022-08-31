package com.example.petshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Pet p = animais.get(i);
        if (selecionados.contains(p)) {
            selecionados.remove(p);
        } else {
            selecionados.add(p);
        }
        adapter.notifyDataSetChanged();
    }

    class PetAdapter extends ArrayAdapter<Pet> {
        public PetAdapter(Context ctx) {
            super(ctx, 0, animais);
        }

        @Override
        public View getView(int position, View recicle, ViewGroup parent) {
            if (recicle == null) {
                recicle = getLayoutInflater().inflate(R.layout.item_pet, null);
            }

            TextView tipo = (TextView) recicle.findViewById(R.id.txt_tipo);
            TextView raca = (TextView) recicle.findViewById(R.id.txt_raca);
            TextView idade = (TextView) recicle.findViewById(R.id.txt_idade);
            TextView nome = (TextView) recicle.findViewById(R.id.txt_nome);
            CheckBox vacinado = (CheckBox) recicle.findViewById(R.id.chk_vacinado);

            Pet p = animais.get(position);

            if (selecionados.contains(p)) {
                recicle.setBackgroundColor(Color.parseColor("#F1F1F1"));
            } else {
                recicle.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }

            tipo.setText("" + p.getTipo());
            raca.setText("" + p.getRaca());
            idade.setText(p.getIdade() + " meses");
            nome.setText(p.getNome());
            vacinado.setChecked(p.isVacinado());

            return recicle;
        }
    }

    LinkedList<Pet> selecionados;
    LinkedList<Pet> animais;
    RadioGroup botoes;
    EditText edRaca, edNome, edIdade;
    Switch swVacinado;
    ListView listaAnimais;
    ArrayAdapter adapter;
    Pet edicao = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            animais = (LinkedList<Pet>) savedInstanceState.getSerializable("animais");
            selecionados = (LinkedList<Pet>) savedInstanceState.getSerializable("selecionados");

            if (animais == null) {
                animais = new LinkedList<>();
            }
            if (selecionados == null) {
                selecionados = new LinkedList<>();
            }
        } else {
            animais = new LinkedList<>();
            selecionados = new LinkedList<>();
        }

        botoes = (RadioGroup) findViewById(R.id.grupo_tipo);
        edRaca = (EditText) findViewById(R.id.ed_raca);
        edNome = (EditText) findViewById(R.id.ed_nome);
        edIdade = (EditText) findViewById(R.id.ed_idade);
        swVacinado = (Switch) findViewById(R.id.sw_vacinado);
        listaAnimais = (ListView) findViewById(R.id.lista_animais);
        // adapter = new ArrayAdapter( this,
        //        android.R.layout.simple_list_item_single_choice,
        //        animais);
        adapter = new PetAdapter(this);
        listaAnimais.setAdapter( adapter );
        listaAnimais.setChoiceMode(AbsListView.CHOICE_MODE_NONE);
        listaAnimais.setOnItemLongClickListener(this);
        listaAnimais.setOnItemClickListener(this);
    }

    @Override
    public void onSaveInstanceState(Bundle dados) {
        dados.putSerializable("animais", animais);
        dados.putSerializable("selecionados", selecionados);
        super.onSaveInstanceState(dados);
    }

    public void confirmar( View v) {
        Pet pet = (edicao != null) ? edicao : new Pet();

        switch( botoes.getCheckedRadioButtonId() ) {
            case R.id.rb_gato: pet.setTipo('G'); break;
            case R.id.rb_cao:  pet.setTipo('C'); break;
            case R.id.rb_passaro: pet.setTipo('P'); break;
        }

        pet.setRaca( edRaca.getText().toString() );
        pet.setNome( edNome.getText().toString() );
        pet.setIdade( Integer.parseInt(edIdade.getText().toString()) );
        pet.setVacinado( swVacinado.isChecked() );
        if (edicao == null) {
            animais.add(pet);
        }
        adapter.notifyDataSetChanged();
        edRaca.setText("");
        edNome.setText("");
        edIdade.setText("");
        swVacinado.setChecked(false);
        edicao = null;
    }

    public void remover( View v) {
        if (listaAnimais.getChoiceMode() == AbsListView.CHOICE_MODE_NONE){
            animais.removeAll(selecionados);
            selecionados.clear();
            adapter.notifyDataSetChanged();

        } else if (listaAnimais.getChoiceMode() == AbsListView.CHOICE_MODE_SINGLE) {
            int itemSelecionado = listaAnimais.getCheckedItemPosition();

            if (itemSelecionado >= 0) {
                animais.remove(itemSelecionado);
                adapter.notifyDataSetChanged();
                listaAnimais.clearChoices();
            } else {
                Toast.makeText(this, R.string.msg_sem_selecao_unica,
                        Toast.LENGTH_LONG).show();
            }
        } else if (listaAnimais.getChoiceMode() == AbsListView.CHOICE_MODE_MULTIPLE) {
            if (listaAnimais.getCheckedItemCount() > 0) {
                SparseBooleanArray sels = listaAnimais.getCheckedItemPositions();
                LinkedList<Pet> selecionados = new LinkedList<>();

                for (int i = 0; i < animais.size(); i++) {
                    if (sels.get(i)) {
                        selecionados.add(animais.get(i));
                    }
                }
                animais.removeAll(selecionados);
                adapter.notifyDataSetChanged();
                listaAnimais.clearChoices();
            } else {
                Toast.makeText(this, R.string.msg_sem_selecao_multipla,
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public boolean onItemLongClick(
            AdapterView<?> adapterView,
            View view,
            int posicao,
            long identificador) {
        edicao = animais.get(posicao);

        switch (edicao.getTipo()) {
            case 'G': botoes.check(R.id.rb_gato);
            break;
            case 'C': botoes.check(R.id.rb_cao);
            break;
            case 'P': botoes.check(R.id.rb_passaro);
            break;
        }
        edNome.setText(edicao.getNome());
        edRaca.setText(edicao.getRaca());
        swVacinado.setChecked(edicao.isVacinado());
        edIdade.setText(String.valueOf(edicao.getIdade()));

        return true;
    }
}