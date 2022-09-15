package co.demo.app

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import co.demo.app.databinding.ActivityMainBinding
import co.demo.home.presenter.HomeFragment
import co.demo.home.presenter.HomeViewModel
import co.demo.home.presenter.ViewState
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var fragmentAdapter: FragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBar)

        fragmentAdapter = FragmentAdapter(supportFragmentManager, lifecycle)

        fragmentAdapter.addFragment(HomeFragment.newInstance(ViewState.New))
        fragmentAdapter.addFragment(HomeFragment.newInstance(ViewState.Approved))
        fragmentAdapter.addFragment(HomeFragment.newInstance(ViewState.Due))
        fragmentAdapter.addFragment(HomeFragment.newInstance(ViewState.Paid))

        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.viewPager.adapter = fragmentAdapter

        binding.viewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                    if (positionOffset == 0f)
                        when (position) {
                            0 -> viewModel.getLoanAccountDetails(ViewState.New)
                            1 -> viewModel.getLoanAccountDetails(ViewState.Approved)
                            2 -> viewModel.getLoanAccountDetails(ViewState.Due)
                            3 -> viewModel.getLoanAccountDetails(ViewState.Paid)
                        }
                }
            }
        )

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.kenya -> {
                viewModel.getLoanAccountDetails("ke", ViewState.New)
                true
            }
            R.id.mexico -> {
                viewModel.getLoanAccountDetails("mx", ViewState.New)
                true
            }
            R.id.philippines -> {
                viewModel.getLoanAccountDetails("ph", ViewState.New)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}