package com.android.desafiofinalstarwars.ui

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import android.view.View
import com.android.desafiofinalstarwars.databinding.FragmentViewDetalhesBinding
import com.android.desafiofinalstarwars.model.Especie
import com.android.desafiofinalstarwars.model.Nave
import com.android.desafiofinalstarwars.model.Personagem
import com.android.desafiofinalstarwars.model.Veiculo


class DetalhesView(private val binding : FragmentViewDetalhesBinding) {

//    constructor(personagem: Personagem) : this(){
//
//    }

    private val nome = binding.textViewNome
    private val generic1 = binding.textViewInfoGeneric1
    private val generic2 = binding.textViewInfoGeneric2
    private val generic3 = binding.textViewInfoGeneric3
    private val generic4 = binding.textViewInfoGeneric4
    private val generic5 = binding.textViewInfoGeneric5
    private val generic6 = binding.textViewInfoGeneric6
    private val generic7 = binding.textViewInfoGeneric7
    private val generic8 = binding.textViewInfoGeneric8
    private val generic9 = binding.textViewInfoGeneric9
    private val generic10 = binding.textViewInfoGeneric10
    private val generic11 = binding.textViewInfoGeneric11
    private val generic12 = binding.textViewInfoGeneric12

   @SuppressLint("SetTextI18n")
   fun bind(personagem: Personagem){
       Log.i(TAG, "bind: " + personagem.nome)

       if (!personagem.nome.isNullOrEmpty()) nome.text = personagem.nome
       else nome.visibility = View.GONE

       if (!personagem.genero.isNullOrEmpty()) generic1.text = "Gender: "+ personagem.genero
       else generic1.visibility = View.GONE

       if (!personagem.altura.isNullOrEmpty()) generic2.text = "Height: "+ personagem.altura + "cm"
       else generic2.visibility = View.GONE

       if (!personagem.anoNascimento.isNullOrEmpty()) generic3.text = "Year of Birth: "+ personagem.anoNascimento
       else generic3.visibility = View.GONE

       if (!personagem.peso.isNullOrEmpty()) generic4.text = "Weight: "+ personagem.peso + "Kg"
       else generic4.visibility = View.GONE

       if (!personagem.corDePele.isNullOrEmpty()) generic5.text = "Skin Color: "+ personagem.corDePele
       else generic5.visibility = View.GONE

       if (!personagem.corDoCabelo.isNullOrEmpty()) generic6.text = "Hair Color: "+ personagem.corDoCabelo
       else generic6.visibility = View.GONE

       if (!personagem.corDoOlho.isNullOrEmpty()) generic7.text = "Eye Color: "+ personagem.corDoOlho
       else generic7.visibility = View.GONE

       generic8.visibility = View.GONE
       generic9.visibility = View.GONE
       generic10.visibility = View.GONE
       generic11.visibility = View.GONE
       generic12.visibility = View.GONE
   }

    fun bind(especie: Especie){
        if (!especie.nome.isNullOrEmpty()) nome.text = especie.nome
        else nome.visibility = View.GONE

        if (!especie.lingua.isNullOrEmpty()) generic1.text = "Language: "+ especie.lingua
        else generic1.visibility = View.GONE

        if (!especie.alturaMedia.isNullOrEmpty()) generic2.text = "Average Height: "+ especie.alturaMedia + "cm"
        else generic2.visibility = View.GONE

        if (!especie.classificacao.isNullOrEmpty()) generic3.text = "Classification: "+ especie.classificacao
        else generic3.visibility = View.GONE

        if (!especie.coresDeCabelo.isNullOrEmpty()) generic4.text = "Hair Colors: "+ especie.coresDeCabelo
        else generic4.visibility = View.GONE

        if (!especie.coresDePele.isNullOrEmpty()) generic5.text = "Skin Colors: "+ especie.coresDePele
        else generic5.visibility = View.GONE

        if (!especie.coresDeOlho.isNullOrEmpty()) generic6.text = "Eye Colors: "+ especie.coresDeOlho
        else generic6.visibility = View.GONE

        if (!especie.mediaDeVida.isNullOrEmpty()) generic7.text = "Lifespan: "+ especie.mediaDeVida
        else generic7.visibility = View.GONE

        generic8.visibility = View.GONE
        generic9.visibility = View.GONE
        generic10.visibility = View.GONE
        generic11.visibility = View.GONE
        generic12.visibility = View.GONE
    }

    fun bind(nave: Nave){
        if (!nave.nome.isNullOrEmpty()) nome.text = nave.nome
        else nome.visibility = View.GONE

        if (!nave.modelo.isNullOrEmpty()) generic1.text = "Model: "+ nave.modelo
        else generic1.visibility = View.GONE

        if (!nave.classe.isNullOrEmpty()) generic2.text = "Class: "+ nave.classe
        else generic2.visibility = View.GONE

        if (!nave.MGLT.isNullOrEmpty()) generic3.text = "MGLT: "+ nave.MGLT
        else generic3.visibility = View.GONE

        if (!nave.velocidadeMaxima.isNullOrEmpty()) generic4.text = "Max Speed: "+ nave.velocidadeMaxima
        else generic4.visibility = View.GONE

        if (!nave.avaliacao.isNullOrEmpty()) generic5.text = "Hyperdrive Rating: "+ nave.avaliacao
        else generic5.visibility = View.GONE

        if (!nave.comprimento.isNullOrEmpty()) generic6.text = "Lenght: "+ nave.comprimento
        else generic6.visibility = View.GONE

        if (!nave.consumiveis.isNullOrEmpty()) generic7.text = "Consumables: "+ nave.consumiveis
        else generic7.visibility = View.GONE

        if (!nave.capacidade.isNullOrEmpty()) generic8.text = "Capacity: " + nave.capacidade
        else generic8.visibility = View.GONE

        if (!nave.capacidadeDePessoas.isNullOrEmpty()) generic9.text = "Crew Capacity: " + nave.capacidade
        else generic9.visibility = View.GONE

        if (!nave.preco.isNullOrEmpty()) generic10.text = "Price: " + nave.preco
        else generic10.visibility = View.GONE

        if (!nave.manufatorador.isNullOrEmpty()) generic11.text = "Manufacturer: " + nave.manufatorador
        else generic11.visibility = View.GONE
        
        generic12.visibility = View.GONE
    }


}