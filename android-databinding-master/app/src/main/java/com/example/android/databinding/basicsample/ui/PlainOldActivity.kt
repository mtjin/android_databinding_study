/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.databinding.basicsample.ui

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.android.databinding.basicsample.R
import com.example.android.databinding.basicsample.data.Popularity
import com.example.android.databinding.basicsample.data.SimpleViewModel
import com.example.android.databinding.basicsample.data.SimpleViewModelSolution
import com.example.android.databinding.basicsample.databinding.PlainActivityBinding

/**
 * Plain old activity with lots of problems to fix.
 */
class PlainOldActivity : AppCompatActivity() {

    // Obtain ViewModel from ViewModelProviders
    private val viewModel by lazy { ViewModelProviders.of(this).get(SimpleViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 데이터 바인딩
        var binding: PlainActivityBinding = DataBindingUtil.setContentView(this, R.layout.plain_activity)

        // - lifecycleOwner를 통해서 ViewModel을 LifeCycle에 종속시켜서, 다양한 라이프사이클 문제를 해결할 수 있다.
        // - ViewModel을 통해서 관심사 분리를 통해 클래스들의 의존성을 낮출 수 있다.
        // - ViewModel을 통해서 액티비티, 프레그먼트 등의 데이터를 공유할 수 있다.
        // [출처] https://gamjatwigim.tistory.com/88
        binding.lifecycleOwner = this  // use Fragment.viewLifecycleOwner for fragments

        // ViewModel binding
        binding.viewmodel = viewModel
    }
}
