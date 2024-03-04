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
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverterapp.ui.theme.UnitConverterAppTheme
import java.math.RoundingMode
import kotlin.math.roundToInt

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


    var inputValue by remember {mutableStateOf("")}
    var outputValue by remember {mutableStateOf("")}
    var inputUnit by remember {mutableStateOf("Centimeters")}
    var outputUnit by remember {mutableStateOf("Centimeters")}

    val conversionFactor = remember {
        mutableStateOf(0.01)
    }
    val oConversionFactor = remember {
        mutableStateOf(0.01)
    }

    var iExpanded by remember {mutableStateOf(false)}
    var oExpanded by remember {mutableStateOf(false)}

    fun calculateResult(){
        val inputValueDouble= inputValue.toDoubleOrNull() ?:0.0
        val Value=((inputValueDouble*conversionFactor.value*100)/(oConversionFactor.value*100)).toBigDecimal().setScale(6,RoundingMode.UP).toDouble()
        outputValue=Value.toString()
    }




        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement=Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Unit Converter", fontSize = 25.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace)
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = inputValue, 
                onValueChange = { 
                    inputValue=it
                    calculateResult() },
                label = { Text(text = "Enter Value")}
                )
            Spacer(modifier = Modifier.height(10.dp))
            Row {

                val context= LocalContext.current;

                Box {
                    Button(onClick = {
                        iExpanded=true

                    },colors = ButtonDefaults.buttonColors(containerColor = Color(131, 116, 140)))
                    {
                        Text(text = inputUnit)
                        Icon(Icons.Default.ArrowDropDown ,contentDescription = "Drop down arrow")
                    }
                    DropdownMenu(expanded = iExpanded, onDismissRequest = {
                        iExpanded=false;
                    }) {
                        DropdownMenuItem(
                            text = {Text(text = "Centimeters") },
                            onClick = {
                                iExpanded=false
                                inputUnit="Centimeters"
                                conversionFactor.value=0.01;
                                calculateResult()
                            }

                        )
                        DropdownMenuItem(
                            text = {Text(text = "Meters") },
                            onClick = {
                                iExpanded=false
                                inputUnit="Meters"
                                conversionFactor.value=1.00;
                                calculateResult()
                            }
                        )
                        DropdownMenuItem(
                            text = {Text(text = "Feet") },
                            onClick = {
                                iExpanded=false
                                inputUnit="Feet"
                                conversionFactor.value=0.3048;
                                calculateResult()
                            }
                        )
                        DropdownMenuItem(
                            text = {Text(text = "Millimeters") },
                            onClick = {
                                iExpanded=false
                                inputUnit="Millimeters"
                                conversionFactor.value=0.001
                                calculateResult()
                            }
                        )

                    }
                }

                Spacer(modifier = Modifier.width(16.dp))


                Box {
                    Button(onClick = {
                        oExpanded=true
                    }, colors = ButtonDefaults.buttonColors(containerColor = Color(131, 116, 140)))
                    {
                        Text(text = outputUnit)
                        Icon(Icons.Default.ArrowDropDown ,contentDescription = "Drop down arrow")
                    }
                    DropdownMenu(expanded = oExpanded, onDismissRequest = {
                        oExpanded=false;
                    }) {
                        DropdownMenuItem(
                            text = {Text(text = "Centimeters") },
                            onClick = {
                                oExpanded=false
                                outputUnit="Centimeters"
                                oConversionFactor.value=0.01
                                calculateResult()
                            }
                        )
                        DropdownMenuItem(
                            text = {Text(text = "Meters") },
                            onClick = {
                                oExpanded=false
                                outputUnit="Meters"
                                oConversionFactor.value=1.0
                                calculateResult()
                            }
                        )
                        DropdownMenuItem(
                            text = {Text(text = "Feet") },
                            onClick = {
                                oExpanded=false
                                outputUnit="Feet"
                                oConversionFactor.value=0.3048
                                calculateResult()
                            }
                        )
                        DropdownMenuItem(
                            text = {Text(text = "Millimeters") },
                            onClick = {
                                oExpanded=false
                                outputUnit="Millimeters"
                                oConversionFactor.value=0.001
                                calculateResult()
                            }
                        )

                    }
                }

            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Result : $outputValue $outputUnit")

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


