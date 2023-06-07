package com.arstagaev.testkmm10.android.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import cafe.adriel.voyager.core.screen.Screen
import com.arstagaev.testkmm10.android.component.Loading
import org.koin.androidx.compose.inject
import org.koin.androidx.compose.koinViewModel


object MainScreen: Screen {

    @Composable
    override fun Content() {
        var vm : MainViewModel = koinViewModel()
        val state by vm.uiState.collectAsState()
        val textState = remember { vm.cityName }

        if (state?.isLoading == true) {
            Loading()
        }

        Column(Modifier.fillMaxWidth().background(Color.White)) {
            Text(text = "Weather Forecast \n please choose city:", modifier = Modifier.fillMaxWidth(1f) ,  fontSize=22.sp, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp))
            //Text(text = "Weather Forecast")

            TextField(modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .height(90.dp), value = textState.value, onValueChange = {
                    textState.value = it
                    //vm.cityName.value = it
                }
            )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(5.dp)
                .background(Color.Blue)
                .clickable {
                    vm.getAllCharacters()
                }
            )

            state?.success?.let {
                Text(modifier = Modifier.fillMaxWidth(), text = "Success forecast: ${it.toString()}", fontSize = 20.sp)
            }
            state?.error?.let {
                Text(modifier = Modifier.fillMaxWidth(), text = "Error forecast", fontSize = 20.sp)
            }
            Text(modifier = Modifier.fillMaxWidth(), text = "no forecast: ", fontSize = 20.sp)




        }
    }
}