package app.arsenijjke.cursach.coordinator.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import app.arsenijjke.cursach.model.AudioBook
import app.arsenijjke.cursach.view.MediaPlayerScreen
import app.arsenijjke.cursach.view.auth.LoginScreen
import app.arsenijjke.cursach.view.profile.ProfileScreen
import app.arsenijjke.cursach.view.auth.RegistrationScreen
import app.arsenijjke.cursach.view.auth.WelcomeScreen
import app.arsenijjke.cursach.view.profile.CatalogScreen
import app.arsenijjke.cursach.view.profile.InterestingScreen
import app.arsenijjke.cursach.view.profile.MyBooksScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen

/** TODO: Здесь а-ля фабрики экранов, чтобы перейти на экран, его надо создать*/
object AppScreens {

    val welcomeScreen = FragmentScreen {
        WelcomeScreen()
    }

    val loginScreen = FragmentScreen {
        LoginScreen()
    }

    val registrationScreen = FragmentScreen {
        RegistrationScreen()
    }

    val profileScreem = FragmentScreen {
        ProfileScreen()
    }

    val catalogScreen = FragmentScreen {
        CatalogScreen()
    }

    val interestingScreen = FragmentScreen {
        InterestingScreen()
    }

    val myBooksScreen = FragmentScreen {
        MyBooksScreen()
    }

    fun buildMediaPlayerScreen(audioBook: AudioBook) =
        FragmentScreen {
            MediaPlayerScreen().withArguments {
                it.putParcelable(AudioBook.KEY, audioBook)
            }
        }
}

inline fun Fragment.withArguments(configure: (Bundle) -> Unit) =
    apply { arguments = Bundle().apply(configure) }