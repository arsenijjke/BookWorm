package app.arsenijjke.cursach

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
import app.arsenijjke.cursach.coordinator.screens.AppScreens
import app.arsenijjke.cursach.databinding.ActivityMainBinding
import app.arsenijjke.cursach.navigation.INavigator
import app.arsenijjke.cursach.viewmodel.ActivityViewModel
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)
    private val viewModel by viewModel<ActivityViewModel>()

    /** Создание глобального навигатора */
    private val navigator by inject<INavigator<AppCompatActivity>> {
        parametersOf(R.id.navigation_container)
    }

    /** Внедрение в координатор */
    private val router by inject<Router>()

    /** Установка стартовой точки(welcomeScreen) */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigator.attach(this@MainActivity)
        if (savedInstanceState == null) router.navigateTo(AppScreens.welcomeScreen)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setNavigation()
    }

    fun setNavigationVisibilisty(condition: Boolean) {
        binding.bottomNavMenu.isVisible = condition
    }

    private fun setNavigation() {
        binding.bottomNavMenu.selectedItemId = R.id.profile
        binding.bottomNavMenu.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.interesting -> { viewModel.navigateToInteresting()
                    true
                }
                R.id.my_books -> {
                    viewModel.navigateToMyBooks()
                    true
                }
                R.id.catalog -> {
                    viewModel.navigateToCatalog()
                    true
                }
                R.id.profile -> {
                    viewModel.navigateToProfile()
                    true
                }
                else -> {false}
            }
        }
    }

}