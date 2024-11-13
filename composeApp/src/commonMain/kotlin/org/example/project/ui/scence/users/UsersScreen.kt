package org.example.project.ui.scence.users

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.mmk.kmpnotifier.notification.NotifierManager
import com.mmk.kmpnotifier.notification.PayloadData
import composemultiplatformlabproject.composeapp.generated.resources.Res
import composemultiplatformlabproject.composeapp.generated.resources.ic_language
import composemultiplatformlabproject.composeapp.generated.resources.users_title
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.example.project.ui.core.MyAppTopBar
import org.example.project.ui.theme.DynamicTextColor
import org.example.project.utils.changeAppLocaleToArabic
import org.example.project.utils.changeAppLocaleToEnglish
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(viewModel: UserViewModel, handleNotificationActions:() -> Unit, navigateToAddNew: () -> Unit){
    val users = viewModel.usersList.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState()
    val appLang = viewModel.appLang.collectAsState("ar")
    val showUserDetails = remember { mutableStateOf<Boolean>(false) }

    val sheetState = rememberModalBottomSheetState()
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START ->  handleNotificationActions()
                else -> {}
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }


    Scaffold(modifier = Modifier, topBar = {
        MyAppTopBar(titleRes = Res.string.users_title, actions = {
            Row (modifier = Modifier, horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically){
                Icon(painter = rememberVectorPainter(Icons.Default.Add), contentDescription = "Add New", modifier = Modifier.clickable { navigateToAddNew() }, tint = DynamicTextColor)
                Icon(painter = painterResource(Res.drawable.ic_language), contentDescription = "SwitchLanguage", modifier = Modifier.clickable {
                    switchLanguage(appLang.value == "ar",viewModel)
                }.size(28.dp), tint = DynamicTextColor)

            }
        })
    }){
        Box(modifier = Modifier.fillMaxSize().padding(it)){
            if(isLoading.value){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }else{
                LazyColumn {
                    items(users.value){user ->
                        UserCell(Modifier.clickable {
                            viewModel.currentUser = user
                            showUserDetails.value = true },user)

                        HorizontalDivider(
                            color = Color.Gray,
                            thickness = 1.5.dp,
                        )
                    }
                }
            }
        }

        if(showUserDetails.value){
            ModalBottomSheet(
                onDismissRequest = {
                    showUserDetails.value = false
                },
                sheetState = sheetState
            ) {
                UserSheet(user = viewModel.currentUser!!)
            }
        }
    }

}

private fun switchLanguage(isAr:Boolean, viewModel: UserViewModel) {
    if (isAr) {
        changeAppLocaleToEnglish()
        viewModel.updateAppLang("en")
    } else {
        changeAppLocaleToArabic()
        viewModel.updateAppLang("ar")
    }
}