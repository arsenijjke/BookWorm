package app.arsenijjke.cursach.di.module

import androidx.appcompat.app.AppCompatActivity
import app.arsenijjke.cursach.navigation.INavigator
import com.github.terrakok.cicerone.Cicerone
import app.arsenijjke.cursach.navigation.FragmentNavigator
import com.github.terrakok.cicerone.Router
import org.koin.dsl.module

/** TODO: Не трогать*/
val navigationModule = module {
    single { Cicerone.create(Router()) }

    factory { get<Cicerone<Router>>().getNavigatorHolder() }

    factory { get<Cicerone<Router>>().router }

    factory<INavigator<AppCompatActivity>> { (appContainerId: Int) ->
        FragmentNavigator(
            navigatorHolder = get(),
            appContainerId = appContainerId,
        )
    }
}
