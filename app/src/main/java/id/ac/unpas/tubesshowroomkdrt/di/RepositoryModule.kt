package id.ac.unpas.tubesshowroomkdrt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.ac.unpas.tubesshowroomkdrt.networks.MobilApi
import id.ac.unpas.tubesshowroomkdrt.persistences.MobilDao
import id.ac.unpas.tubesshowroomkdrt.repositories.MobilRepository
import id.ac.unpas.tubesshowroomkdrt.networks.SepedaMotorApi
import id.ac.unpas.tubesshowroomkdrt.persistences.SepedaMotorDao
import id.ac.unpas.tubesshowroomkdrt.repositories.SepedaMotorRepository
import id.ac.unpas.tubesshowroomkdrt.networks.PromoApi
import id.ac.unpas.tubesshowroomkdrt.persistences.PromoDao
import id.ac.unpas.tubesshowroomkdrt.repositories.PromoRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideMobilRepository(
        api: MobilApi,
        dao: MobilDao
    ): MobilRepository {
        return MobilRepository(api, dao)
    }
    @Provides
    @ViewModelScoped
    fun provideSepedaMotorRepository (
        api: SepedaMotorApi,
        dao: SepedaMotorDao
    ): SepedaMotorRepository {
        return SepedaMotorRepository(api, dao)
    }
    @Provides
    @ViewModelScoped
    fun providePromoRepository(
        api: PromoApi,
        dao: PromoDao
    ): PromoRepository {
        return PromoRepository(api, dao)
    }
}