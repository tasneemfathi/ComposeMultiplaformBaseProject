package org.example.project.scence.users

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import com.mmk.kmpnotifier.notification.NotifierManager
import composemultiplatformlabproject.composeapp.generated.resources.Res
import composemultiplatformlabproject.composeapp.generated.resources.users_title
import org.example.project.ui.core.MyAppTopBar
import org.example.project.ui.theme.DynamicTextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(viewModel: UserViewModel, navigateToAddNew: () -> Unit){
    val users = viewModel.usersList.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState()
    val showUserDetails = remember { mutableStateOf<Boolean>(false) }
    val sheetState = rememberModalBottomSheetState()
    Scaffold(modifier = Modifier, topBar = {
        MyAppTopBar(titleRes = Res.string.users_title, actions = {
            Icon(painter = rememberVectorPainter(Icons.Default.Add), contentDescription = "Add New", modifier = Modifier.clickable { navigateToAddNew() }, tint = DynamicTextColor)
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