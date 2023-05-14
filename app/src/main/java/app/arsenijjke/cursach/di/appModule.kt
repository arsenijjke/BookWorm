package app.arsenijjke.cursach.di

import app.arsenijjke.cursach.di.module.coordinatorModule
import app.arsenijjke.cursach.di.module.navigationModule
import app.arsenijjke.cursach.di.module.presentationModule
import org.koin.core.module.Module

/** TODO: Не трогать! здесь объеденяются модули*/
internal val app: List<Module> = presentationModule + coordinatorModule + navigationModule