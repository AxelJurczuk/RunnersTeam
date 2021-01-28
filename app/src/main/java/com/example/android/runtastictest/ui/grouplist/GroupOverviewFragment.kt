package com.example.android.runtastictest.ui.grouplist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.android.runtastictest.data.Result
import com.example.android.runtastictest.databinding.FragmentGroupOverviewBinding
import com.example.android.runtastictest.ui.adapter.GroupAdapter
import com.example.android.runtastictest.viewmodel.GroupViewModel


class GroupOverviewFragment : Fragment(), GroupAdapter.OnItemClick {
    private lateinit var binding: FragmentGroupOverviewBinding
    private val viewModel: GroupViewModel by viewModels()
    private lateinit var groupAdapter: GroupAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentGroupOverviewBinding.inflate(layoutInflater)
        val groupObserver = Observer<Result>{
            binding.progressBar.visibility = View.GONE
            when (it){
                is Result.Success->{
                    groupAdapter.groupList= it.list
                    groupAdapter.notifyDataSetChanged()
                }
                is Result.Failure->
                    Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.getHouseListLiveData().observe(viewLifecycleOwner, groupObserver)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerView
        groupAdapter= GroupAdapter(requireContext(), this)
        recyclerView.adapter = groupAdapter
        recyclerView.setHasFixedSize(true)
    }

    override fun onItemClickListener(position: Int) {
        val group= groupAdapter.groupList[position]
        val action = GroupOverviewFragmentDirections.actionGroupOverviewFragmentToMembersOverviewFragment(group)
        findNavController().navigate(action)
    }
}