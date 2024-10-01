package br.unipar.prova_taffbank

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class TarefaAdapter (

    private val context : Context,
    private val listaTarefa : MutableList <Tarefa>) : ArrayAdapter<Tarefa>(context,0,listaTarefa){

    override fun getView (position: Int, convertView: View?, parent: ViewGroup): View {

        val tarefa = listaTarefa.get(position)

        val view = LayoutInflater.from(context).inflate(R.layout.item_tarefa, parent, false)

        val descricao = view.findViewById<TextView>(R.id.txtDescricao)
        val valor = view.findViewById<TextView>(R.id.txtValor)
        val transacao = view.findViewById<TextView>(R.id.txtTransacao)

        descricao.text = tarefa.descricao
        valor.text = tarefa.valor
        transacao.text = tarefa.transacao

        return view

    }
}





