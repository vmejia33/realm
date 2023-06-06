/*
 * Copyright 2023 Realm Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.realm.curatedsyncexamples.fieldencryption

import io.realm.curatedsyncexamples.fieldencryption.ui.NavGraphViewModel
import io.realm.curatedsyncexamples.fieldencryption.ui.keystore.KeyStoreViewModel
import io.realm.curatedsyncexamples.fieldencryption.ui.login.LoginViewModel
import io.realm.curatedsyncexamples.fieldencryption.ui.records.SecretRecordsViewModel
import io.realm.kotlin.mongodb.App
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val fieldEncryptionModule = module {
    val keyAlias = "fieldLevelEncryptionKey"

    viewModel { KeyStoreViewModel(get(), keyAlias) }
    viewModel { LoginViewModel(get()) }
    viewModel { SecretRecordsViewModel(get(), keyAlias) }

    viewModel { NavGraphViewModel(get(), keyAlias) }

    single { App.create("cypher-scjvs") }
}