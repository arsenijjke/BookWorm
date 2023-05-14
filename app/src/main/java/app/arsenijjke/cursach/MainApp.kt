package app.arsenijjke.cursach

import android.app.Application
import app.arsenijjke.cursach.di.app
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/** TODO Класс который собирает все зависимости, и запускает остальные части приложения*/
/** Не трогать*/
class MainApp : Application() {

    override fun onCreate() {
        initKoin(this)
        super.onCreate()
    }

    private fun initKoin(application: Application) {
        startKoin {
            androidContext(application)
            modules(app)
        }
    }
}