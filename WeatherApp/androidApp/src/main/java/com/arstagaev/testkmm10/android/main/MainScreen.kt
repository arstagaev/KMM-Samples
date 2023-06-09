package com.arstagaev.testkmm10.android.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import coil.compose.AsyncImage
import com.arstagaev.testkmm10.android.component.Loading
import org.koin.androidx.compose.koinViewModel


object MainScreen: Screen {

    @Composable
    override fun Content() {
        var vm : MainViewModel = koinViewModel()
        val state by vm.uiState.collectAsState()
        val textState = remember { vm.cityName }

        if (state?.isLoading == true) {
            Loading()
        }else {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Color.White)) {
                Text(text = "Weather Forecast \n please choose city:", modifier = Modifier.fillMaxWidth(1f) ,  fontSize=22.sp, textAlign = TextAlign.Center)

                state?.success?.let {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        AsyncImage(
                            model = it.condition.icon,
                            contentDescription = "image",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .size(100.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp))

                TextField(modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
                    .height(50.dp),
                    label = { Text("Enter city name") },
                    value = textState.value, onValueChange = {
                        textState.value = it
                    }
                )
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp))
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 35.dp, vertical = 5.dp)
                    .clip(RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
                    .background(Color(255, 192, 203))
                    .clickable {
                        vm.getAllCharacters()
                    }, contentAlignment = Alignment.Center,

                    ){
                    Text(modifier = Modifier, text = "Request forecast", textAlign = TextAlign.Center, fontSize = 20.sp, color = Color.Red)
                }
                if (state?.success != null) {
                    state?.success?.let {
                        Row(Modifier.fillMaxWidth()) {
                            Column(Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(modifier = Modifier
                                    .padding(vertical = 3.dp), text = "Success forecast:", fontSize = 20.sp)
                                Text(modifier = Modifier
                                    .padding(vertical = 3.dp), text = "Location: ${it.name} ${it.country}", fontSize = 20.sp)
                                Text(modifier = Modifier
                                    .padding(vertical = 3.dp), text = "Temp: ${it.feelslike_c}", fontSize = 20.sp)
                                Text(modifier = Modifier
                                    .padding(vertical = 3.dp), text = "Local time: ${it.localtime}", fontSize = 20.sp)
                            }
                        }
                    }
                } else {
                    state?.error?.let {
                        Text(modifier = Modifier.fillMaxWidth(), text = "Error forecast", fontSize = 20.sp)
                    }
                }
            }
        }
    }
}
