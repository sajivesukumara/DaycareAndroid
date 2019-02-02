package com.daycare.daycare1

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import android.support.annotation.NonNull
import android.support.annotation.IdRes
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem

class
HomeActivity : AppCompatActivity() {


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                setFragment(R.id.containerBottom, HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                setFragment(R.id.containerBottom, NotificationFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_events -> {
                setFragment(R.id.containerBottom, EventFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_sneak -> {
                setFragment(R.id.containerBottom, SneakPeakFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                setFragment(R.id.containerBottom, ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        true
    }

    private fun setFragment(containerViewId:Int, fragment: Fragment) {
        supportFragmentManager.
                beginTransaction().
                replace(containerViewId, fragment).commit()
    }

    protected fun addFragment(@IdRes containerViewId: Int,
                              fragment: Fragment,
                              fragmentTag: String) {
        supportFragmentManager
                .beginTransaction()
                .add(containerViewId, fragment, fragmentTag)
                .disallowAddToBackStack()
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

/*        setSupportActionBar(toolbar2)
        val actionBar = supportActionBar

        actionBar!!.title = "Klay Daycare "
        actionBar.subtitle = "Mahadevpura"
        actionBar.setDisplayShowHomeEnabled(true)
        actionBar.setLogo(R.drawable.ic_arrow_right)
        actionBar.setDisplayUseLogoEnabled(true)

        setSupportActionBar(toolbar as Toolbar)
        supportActionBar?.title = "Klay Today"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu_black)
        supportActionBar?.setLogo(R.drawable.school_logo_small)
        supportActionBar?.setDisplayUseLogoEnabled(true)

        navigationView.setCheckedItem(R.id.action_share)
        navigationView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_share -> {
                    item.setChecked(true)
                    drawerLayout.closeDrawers()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
*/
        //addFragment(R.id.containerBottom, HomeFragment(), "")
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.setSelectedItemId(R.id.navigation_home)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> drawerLayout.openDrawer(GravityCompat.START)
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
