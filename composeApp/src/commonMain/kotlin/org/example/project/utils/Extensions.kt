package org.example.project.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.flow.StateFlow


@Composable
fun <T> StateFlow<T>.collectAsMutableState(): MutableState<T> {
    val state = remember { mutableStateOf(value) }
    LaunchedEffect(this) {
        collect { newValue ->
            state.value = newValue
        }
    }
    return state
}