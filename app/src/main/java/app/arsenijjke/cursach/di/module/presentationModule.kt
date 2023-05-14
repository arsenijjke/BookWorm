package app.arsenijjke.cursach.di.module

import android.os.Bundle
import app.arsenijjke.cursach.model.AudioBook
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import app.arsenijjke.cursach.viewmodel.auth.WelcomScreenViewModel
import app.arsenijjke.cursach.viewmodel.auth.LoginScreenViewModel
import app.arsenijjke.cursach.viewmodel.auth.RegistrationViewModel
import app.arsenijjke.cursach.viewmodel.profile.ProfileScreenViewModel
import app.arsenijjke.cursach.viewmodel.profile.InterestingScreenViewModel
import app.arsenijjke.cursach.viewmodel.profile.MyBooksScreenViewModel
import app.arsenijjke.cursach.viewmodel.profile.CatalogScreenViewModel
import app.arsenijjke.cursach.viewmodel.ActivityViewModel
import app.arsenijjke.cursach.viewmodel.MediaPlayerScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

/** TODO: При добавлении экрана с viewModel, её ты прописываешь здесь*/
val presentationModule = module {

    viewModelOf(::ActivityViewModel)

    viewModelOf(::WelcomScreenViewModel)

    viewModelOf(::LoginScreenViewModel)

    viewModelOf(::RegistrationViewModel)

    viewModelOf(::ProfileScreenViewModel)

    viewModelOf(::InterestingScreenViewModel)

    viewModelOf(::MyBooksScreenViewModel)

    viewModelOf(::CatalogScreenViewModel)

    viewModel {(args: Bundle) ->
        MediaPlayerScreenViewModel(
            coordinator = get(),
            book = args.getParcelable(AudioBook.KEY)!!
        )
    }
}
