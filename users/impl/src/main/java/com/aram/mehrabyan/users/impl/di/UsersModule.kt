package com.aram.mehrabyan.users.impl.di

import com.aram.mehrabyan.network.api.RestApiCreator
import com.aram.mehrabyan.users.api.UsersNavGraphProvider
import com.aram.mehrabyan.users.impl.internal.RealUsersNavGraphProvider
import com.aram.mehrabyan.users.impl.internal.data.RealUsersRepo
import com.aram.mehrabyan.users.impl.internal.data.UsersApiService
import com.aram.mehrabyan.users.impl.internal.data.UsersRepo
import com.aram.mehrabyan.users.impl.internal.data.mapper.RealUserApiModelsToUiModelsMapper
import com.aram.mehrabyan.users.impl.internal.data.mapper.RealUserDBModelsToUiModelsMapper
import com.aram.mehrabyan.users.impl.internal.data.mapper.RealUserUiModelToDBModelMapper
import com.aram.mehrabyan.users.impl.internal.data.mapper.UserApiModelsToUiModelsMapper
import com.aram.mehrabyan.users.impl.internal.data.mapper.UserDBModelsToUiModelsMapper
import com.aram.mehrabyan.users.impl.internal.data.mapper.UserUiModelToDBModelMapper
import com.aram.mehrabyan.users.impl.internal.userItems.bookmarks.BookMarksViewModel
import com.aram.mehrabyan.users.impl.internal.userItems.bookmarks.manager.AllBookmarksManager
import com.aram.mehrabyan.users.impl.internal.userItems.bookmarks.manager.RealAllBookmarksManager
import com.aram.mehrabyan.users.impl.internal.userItems.bookmarks.ui.BookmarksUiController
import com.aram.mehrabyan.users.impl.internal.userItems.bookmarks.ui.RealBookmarksUiController
import com.aram.mehrabyan.users.impl.internal.userItems.manager.BookmarksManager
import com.aram.mehrabyan.users.impl.internal.userItems.manager.RealBookmarksManager
import com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.RandomUsersViewModel
import com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.manager.RandomUsersManager
import com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.manager.RealRandomUsersManager
import com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.ui.RandomUsersUiController
import com.aram.mehrabyan.users.impl.internal.userItems.randomUsers.ui.RealRandomUsersUiController
import com.aram.mehrabyan.users.impl.internal.users.ui.RealUsersViewPagerUiController
import com.aram.mehrabyan.users.impl.internal.users.ui.UsersViewPagerUiController
import com.aram.mehrabyan.users.impl.internal.users.ui.pager.RealUsersViewPageCreator
import com.aram.mehrabyan.users.impl.internal.users.ui.pager.UsersViewPageCreator
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun usersModule() = module {
    single<UsersApiService> {
        get<RestApiCreator>().createApiService(UsersApiService::class.java)
    }

    single<UsersRepo> {
        RealUsersRepo(localUsersService = get(), apiUsersService = get())
    }

    factory<UserApiModelsToUiModelsMapper> { RealUserApiModelsToUiModelsMapper() }

    factory<UserDBModelsToUiModelsMapper> { RealUserDBModelsToUiModelsMapper() }

    factory<UserUiModelToDBModelMapper> { RealUserUiModelToDBModelMapper() }

    factory<BookmarksManager> {
        RealBookmarksManager(usersRepo = get(), mapper = get(), dispatchers = get())
    }

    factory<AllBookmarksManager> {
        RealAllBookmarksManager(usersRepo = get(), mapper = get(), dispatchers = get())
    }

    factory<RandomUsersManager> {
        RealRandomUsersManager(usersRepo = get(), mapper = get(), dispatchers = get())
    }

    factory<UsersNavGraphProvider> { RealUsersNavGraphProvider() }

    factory<UsersViewPageCreator> { RealUsersViewPageCreator() }

    factory<UsersViewPagerUiController> {
        RealUsersViewPagerUiController(pageCreator = get())
    }

    factory<RandomUsersUiController> { RealRandomUsersUiController() }

    factory<BookmarksUiController> { RealBookmarksUiController() }

    viewModel { RandomUsersViewModel(manager = get(), bookmarksManager = get()) }

    viewModel { BookMarksViewModel(manager = get(), bookmarksManager = get()) }
}