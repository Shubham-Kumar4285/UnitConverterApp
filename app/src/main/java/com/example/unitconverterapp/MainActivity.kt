package com.example.unitconverterapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverterapp.ui.theme.UnitConverterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}


//rows and columns
@Composable
fun UnitConverter(){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement=Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Unit Converter", fontSize = 25.sp)
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(value = "", onValueChange = {

            //code to execute when value changes
            })
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                val context= LocalContext.current;
                Box {
                    Button(onClick = {
                        //onlick
                    },colors = ButtonDefaults.buttonColors(containerColor = Color(131, 116, 140)))
                    {
                        Text(text = "Select")
                        Icon(Icons.Default.ArrowDropDown ,contentDescription = "Drop down arrow")
                    }
                    DropdownMenu(expanded = false, onDismissRequest = {
                    /*TODO*/
                    }) {
                        
                    }
                }
                Spacer(modifier = Modifier.width(16.dp))
                Box {
                    Button(onClick = {
                        //onlick
                    }, colors = ButtonDefaults.buttonColors(containerColor = Color(131, 116, 140)))
                    {
                        Text(text = "Select")
                        Icon(Icons.Default.ArrowDropDown ,contentDescription = "Drop down arrow")
                    }
                }

            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Result ")

        }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}


