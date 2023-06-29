package com.project.radiusagentassignment.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.radiusagentassignment.adapters.FacilitiesRecyclerViewAdapter
import com.project.radiusagentassignment.coontracts.ListFragmentContract
import com.project.radiusagentassignment.databinding.FragmentListBinding
import com.project.radiusagentassignment.models.BaseFacilitiesItem
import com.project.radiusagentassignment.presenters.FacilitiesListPresenter
import com.project.radiusagentassignment.repositories.FacilitiesListRepository


class ListFragment : Fragment(), ListFragmentContract.View {

    private lateinit var binding: FragmentListBinding
    private lateinit var mContext: Context
    private var presenter: FacilitiesListPresenter? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater)
        presenter = FacilitiesListPresenter(mContext, this, FacilitiesListRepository())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.onLoadData()
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }

    override fun displayData(baseFacilitiesItem: BaseFacilitiesItem) {
        val recyclerViewAdapter = FacilitiesRecyclerViewAdapter(mContext, baseFacilitiesItem)
        binding.listRecyclerview.layoutManager = LinearLayoutManager(mContext)
        binding.listRecyclerview.adapter = recyclerViewAdapter
    }

    override fun showErrorView() {

    }

    override fun showHideLoader(isShow: Boolean) {
        if (isShow) {
            binding.progressCircular.visibility = View.VISIBLE
        } else {
            binding.progressCircular.visibility = View.GONE
        }
    }

    override fun showHideList(isShow: Boolean) {

    }

    private fun initRecyclerView() {
        binding.listRecyclerview.layoutManager = LinearLayoutManager(mContext)
    }
}