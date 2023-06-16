package id.ac.unpas.tubesshowroomkdrt.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.ac.unpas.tubesshowroomkdrt.persistences.AppDatabase
import id.ac.unpas.tubesshowroomkdrt.persistences.MobilDao
import id.ac.unpas.tubesshowroomkdrt.persistences.SepedaMotorDao
import id.ac.unpas.tubesshowroomkdrt.persistences.PromoDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(
                application,
                AppDatabase::class.java,
                "penglolaan-showroom"
            )
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideMobilDao(appDatabase: AppDatabase): MobilDao {
        return appDatabase.mobilDao()
    }
    @Provides
    @Singleton
    fun provideSepedaMotorDao(appDatabase: AppDatabase): SepedaMotorDao {
        return appDatabase.sepedaMotorDao()
    }
    @Provides
    @Singleton
    fun providePromoDao(appDatabase: AppDatabase): PromoDao {
        return appDatabase.promoDao()
    }
}