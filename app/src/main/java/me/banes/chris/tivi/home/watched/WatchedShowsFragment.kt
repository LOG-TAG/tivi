/*
 * Copyright 2017 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.banes.chris.tivi.home.watched

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_rv_grid.*
import me.banes.chris.tivi.R
import me.banes.chris.tivi.data.entities.WatchedListItem
import me.banes.chris.tivi.home.HomeNavigator
import me.banes.chris.tivi.home.HomeNavigatorViewModel
import me.banes.chris.tivi.util.EntryGridFragment

class WatchedShowsFragment : EntryGridFragment<WatchedListItem, WatchedShowsViewModel>(WatchedShowsViewModel::class.java) {

    private lateinit var homeNavigator: HomeNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeNavigator = ViewModelProviders.of(activity!!, viewModelFactory).get(HomeNavigatorViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        grid_toolbar.apply {
            title = getString(R.string.library_watched)
            setNavigationOnClickListener {
                viewModel.onUpClicked(homeNavigator)
            }
        }
    }

}
