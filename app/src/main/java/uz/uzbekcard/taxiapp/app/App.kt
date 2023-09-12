package uz.uzbekcard.taxiapp.app

import android.app.Application
import uz.uzbekcard.taxiapp.di.navigationModule
import uz.uzbekcard.taxiapp.di.networkModule
import uz.uzbekcard.taxiapp.di.presenterModule
import uz.uzbekcard.taxiapp.di.repositoryModule
import uz.uzbekcard.taxiapp.di.storageModule
import uz.uzbekcard.taxiapp.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import uz.uzbekcard.taxiapp.di.directionModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                navigationModule,
                useCaseModule,
                presenterModule,
                storageModule,
                networkModule,
                repositoryModule,
                directionModule
            )
        }
    }
}