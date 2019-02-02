package com.daycare.daycare1


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.view.ViewPager
import com.daycare.daycare1.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SneakPeakFragment : Fragment(), ViewPager.OnPageChangeListener {

    lateinit var array: ArrayList<Int>;
    override fun onPageScrollStateChanged(p0: Int) {

    }

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

    }

    override fun onPageSelected(position: Int) {

    }


    lateinit var viewLayout: View;
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewLayout = inflater.inflate(R.layout.fragment_sneak_peak, container, false)

        var mPager = viewLayout.findViewById(R.id.viewPager) as ViewPager

        array = ArrayList();
        array.add(R.drawable.image1)
        array.add(R.drawable.image2)
        array.add(R.drawable.image3)
        mPager.setAdapter(SlidingImage_Adapter(activity, array))

        mPager.addOnPageChangeListener(this)

        return viewLayout
    }



}
