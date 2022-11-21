package com.android.desafiofinalstarwars.ui.home.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.android.desafiofinalstarwars.R
import com.android.desafiofinalstarwars.databinding.FragmentCharactersBinding
import com.android.desafiofinalstarwars.model.Character
import com.android.desafiofinalstarwars.ui.DetalhesView
import com.android.desafiofinalstarwars.ui.home.HomeFragment
import com.android.desafiofinalstarwars.ui.home.viewmodels.CharactersViewModel
import com.android.desafiofinalstarwars.ui.home.adapters.CharactersAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : Fragment() {

    private var _binding: FragmentCharactersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val charactersList : ArrayList<Character> = arrayListOf()

    private val viewModel by viewModel<CharactersViewModel>()

    private var isClicked = 0

    private val adapter by lazy {
        CharactersAdapter()
    }

    private val fromVisible : Animation by lazy {AnimationUtils.loadAnimation(context, R.anim.fromvisible)}
    private val toVisible : Animation by lazy {AnimationUtils.loadAnimation(context, R.anim.tovisible)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragmentCharactersRecyclerview.adapter = adapter

        setObserver()

        viewModel.getApiCharacters()

        adapter.itemClickListener = {
            isClicked = 1
            descriptionTabCall(it)
        }
        HomeFragment.onTabReselectedCharactersListener = {
            isClicked -= 1
            descriptionTabCall()
        }

        Log.i(TAG, "onViewCreated: ")
    }

    private fun descriptionTabCall(character: Character? = null) {
        if (isClicked == 1){
            binding.fragmentCharactersRecyclerview.startAnimation(fromVisible)
            binding.fragmentCharactersRecyclerview.visibility = View.GONE
            binding.fragmentViewDetails.root.startAnimation(toVisible)
            binding.fragmentViewDetails.root.visibility = View.VISIBLE
            DetalhesView(binding.fragmentViewDetails).bind(character!!)
        } else if (isClicked == 0) {
            binding.fragmentCharactersRecyclerview.startAnimation(toVisible)
            binding.fragmentCharactersRecyclerview.visibility = View.VISIBLE
            binding.fragmentViewDetails.root.startAnimation(fromVisible)
            binding.fragmentViewDetails.root.visibility = View.GONE
        }
    }

    private fun setObserver() {
        Log.i(TAG, "setObserver: ")
        viewModel.characterResponse.observe(viewLifecycleOwner){
            it?.let {
                charactersList.addAll(it.results!!)
                adapter.update(charactersList)
            }
        }
        viewModel.loadStateLiveData.observe(viewLifecycleOwner){
            handleProgressBar(it)
        }
        viewModel.characterError.observe(viewLifecycleOwner){
            Toast.makeText(context, "Api Error.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun handleProgressBar(state: CharactersViewModel.State?) {
        when(state){
            CharactersViewModel.State.LOADING -> binding.progressCircular.visibility = View.VISIBLE
            CharactersViewModel.State.LOADING_FINISHED -> binding.progressCircular.visibility = View.GONE
            else -> {}
        }
    }

}