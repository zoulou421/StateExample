package com.formationkilo.stateexample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

//remember -> persist the state on recomposition
////rememberSaveable -> persist even on configuration changes
//ViewModel and LiveData ->Hoist the state for re-usability
/*@Composable
fun StateTestScreen(){
    var name by rememberSaveable{
        mutableStateOf("")
    }
  Column(modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally){
      MyText(name)
      MyTextField(name, onNameChange = {
          name=it
      })
  }
}*/

@Composable
fun StateTestScreen(viewModel: StateTestViewModel){
    val name by viewModel.name.observeAsState(initial = "")

    val surname by viewModel.surname.observeAsState(initial = "")

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        MyText("$name $surname")
        MyTextField(name, onNameChange = {
            viewModel.onNameUpdate(it)
        })

        MyTextField(surname, onNameChange = {
            viewModel.onSurnameUpdate(it)
        })
    }
}

@Composable
fun MyText(name:String){
    Text(text = "Hello $name", style = TextStyle(fontSize = 30.sp))
}

@Composable
fun MyTextField(name:String,onNameChange: (String)->Unit){

    OutlinedTextField(
        value =name,
        onValueChange ={
           // name=it
            onNameChange(it)
        },
        label = { Text(text = "Enter name")})
}



