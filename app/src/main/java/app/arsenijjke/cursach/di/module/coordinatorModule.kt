package app.arsenijjke.cursach.di.module

import app.arsenijjke.cursach.coordinator.flow.IAppFlowCoordinator
import app.arsenijjke.cursach.coordinator.flow.AppFlowCoordinator
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module


/** TODO: Если надо добавить новый маршрут(не понадобится тебе, то его писать сюда)*/
val coordinatorModule = module {

    factoryOf(::AppFlowCoordinator) bind IAppFlowCoordinator::class
}
