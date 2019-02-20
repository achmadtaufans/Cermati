/*
 * @copyright ©2019 Onoff Insurance All rights reserved. Trade Secret, Confidential and Proprietary.
 *            Any dissemination outside of Onoff Insurance is strictly prohibited.
 */
package insure.onoff.views.fragments.loreg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import insure.onoff.adapter.IllustrationAdapter
import insure.onoff.databinding.FragmentLoRegBinding
import kotlinx.android.synthetic.main.fragment_lo_reg.*

/**
 * LoRegFragment
 *
 * This class responsible to create page for loreg first view
 *
 * @author    Charles S  <charlessetiadi@onoff.insure>
 */
class LoRegFragment : Fragment() {
    // Generate binding class from layout
    private lateinit var binding: FragmentLoRegBinding

    // list of CDN data
    private val imageUrls = arrayOf(
        "il-en-lowcost.png",
        "il-en-easyclaim.png",
        "il-en-hourlyprotection.png"
    )

    /**
     *  create view by inflating layout using navigation via binding
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoRegBinding.inflate(inflater, container, false)
        val context = context ?: return binding.root
        return binding.root
    }

    /**
     *  To run function after view created
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapter: PagerAdapter = IllustrationAdapter(context!!, imageUrls)
        viewPager.adapter = adapter
        tabLayout2.setupWithViewPager(viewPager, true)
    }
}