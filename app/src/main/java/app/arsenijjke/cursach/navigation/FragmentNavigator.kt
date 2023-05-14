package app.arsenijjke.cursach.navigation

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator

/** TODO: Механизм прикрепления фрагментов на основе жизненного цикла. Не трогать!*/
open class FragmentNavigator<T : AppCompatActivity>(
    private val navigatorHolder: NavigatorHolder,
    @IdRes private val appContainerId: Int,
) : INavigator<T> {

    override fun attach(subject: T) = with(subject) {
        lifecycle.addObserver(object : DefaultLifecycleObserver {

            override fun onStart(owner: LifecycleOwner) {
                super.onStart(owner)
                val navigator = AppNavigator(subject, appContainerId)
                navigatorHolder.setNavigator(navigator)
            }

            override fun onStop(owner: LifecycleOwner) {
                super.onStop(owner)
                navigatorHolder.removeNavigator()
            }
        })
    }
}
