package com.example.android.runtastictest.ui.memberslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.android.runtastictest.databinding.FragmentMembersOverviewBinding
import com.example.android.runtastictest.ui.adapter.MemberAdapter


class MembersOverviewFragment : Fragment() {

    private lateinit var binding: FragmentMembersOverviewBinding
    private lateinit var adapter: MemberAdapter
    private val args: MembersOverviewFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMembersOverviewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val group = args.group
        adapter = MemberAdapter(requireContext())
        adapter.memberList = group.members
        val recyclerView = binding.recyclerViewMembers
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
    }


}