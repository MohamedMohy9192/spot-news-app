package com.androidera.spotnews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.androidera.spotnews.databinding.FragmentTopHeadlinesNewsBinding

class TopHeadlinesNewsFragment : Fragment() {

    private var _binding: FragmentTopHeadlinesNewsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TopHeadlinesViewModel by viewModels {
        ViewModelFactory(
            (activity?.application as NewsApplication).repository
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTopHeadlinesNewsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.topHeadlinesNews.observe(viewLifecycleOwner) { newsResponse ->
            binding.resultTextView.text = newsResponse.status
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}