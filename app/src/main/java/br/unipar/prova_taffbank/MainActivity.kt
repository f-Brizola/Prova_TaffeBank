package br.unipar.prova_taffbank

import android.annotation.SuppressLint
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val listaDeTarefas = mutableListOf<Tarefa>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edSaldo = findViewById<EditText>(R.id.edSaldo)
        val edValor = findViewById<EditText>(R.id.edValor)
        val edDescricao = findViewById<EditText>(R.id.edDescricao)
        val btnCredito = findViewById<Button>(R.id.btnCredito)
        val btnDebito = findViewById<Button>(R.id.btnDebito)
        val listaTarefas = findViewById<ListView>(R.id.listaTarefas)
        val total = findViewById<TextView>(R.id.txtTotal)
        val btnZerar = findViewById<Button>(R.id.btnZerar)

        val adapter = TarefaAdapter(this, listaDeTarefas)

        listaTarefas.adapter = adapter

        var conta = 0

        btnCredito.setOnClickListener {

            val saldo = edSaldo.text.toString()
            val valor = edValor.text.toString()
            val descricao = edDescricao.text.toString()

            if (saldo.isNotEmpty() && valor.isNotEmpty() && valor.isNotEmpty()){

                val sal = saldo.toDouble()
                val quant = valor.toDouble()


                val novaTarefa = Tarefa(descricao,valor,saldo)

                // atualiza a tela
                listaDeTarefas.add(novaTarefa)
                adapter.notifyDataSetChanged()

                var conta = sal - quant

                total.setText("Conta Paga, Valor do saldo atual é $conta")

            }
        }

        btnDebito.setOnClickListener {

            val saldo = edSaldo.text.toString()
            val valor = edValor.text.toString()
            val descricao = edDescricao.text.toString()

            if (saldo.isNotEmpty() && valor.isNotEmpty() && valor.isNotEmpty()){

                val sal = saldo.toDouble()
                val quant = valor.toDouble()


                val novaTarefa = Tarefa(descricao,valor,saldo)

                // atualiza a tela
                listaDeTarefas.add(novaTarefa)
                adapter.notifyDataSetChanged()

                var conta = sal - quant

                total.setText("Conta Paga, Valor do saldo atual é $conta")

            }
        }

        btnZerar.setOnClickListener{

            val edSaldo = findViewById<EditText>(R.id.edSaldo)
            val edValor = findViewById<EditText>(R.id.edValor)
            val edDescricao = findViewById<EditText>(R.id.edDescricao)
            val total = findViewById<TextView>(R.id.txtTotal)


            edSaldo.setText("")
            edValor.setText("")
            edDescricao.setText("")
            total.setText("")
            listaDeTarefas.clear();
            adapter.notifyDataSetChanged()
            conta = 0

        }


        fun limparValores(view: View){
            val edSaldo = findViewById<EditText>(R.id.edSaldo)
            val edValor = findViewById<EditText>(R.id.edValor)
            val edDescricao = findViewById<EditText>(R.id.edDescricao)

            edSaldo.setText("")
            edValor.setText("")
            edDescricao.setText("")
            total.setText("")

        }


    }
}