package com.example.tipcalculator.ui.screens.tip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tipcalculator.ui.screens.tip.components.HeadingText
import com.example.tipcalculator.ui.screens.tip.components.NormalText
import com.example.tipcalculator.ui.screens.tip.components.RoundOff
import com.example.tipcalculator.ui.screens.tip.components.TipButton
import com.example.tipcalculator.ui.screens.tip.components.TipSpacer
import com.example.tipcalculator.ui.screens.tip.components.TipTextField

@Composable
fun TipScreen(modifier: Modifier = Modifier) {
    var isChecked by remember { mutableStateOf(false) }
    var showResult by remember { mutableStateOf(false) }
    var amountInput by remember { mutableStateOf("") }
    var percentInput by remember { mutableStateOf("") }
    var tip by remember { mutableDoubleStateOf(0.0) }

    fun calculate(amount: Double, percent: Double) {
        tip = (amount * percent) / 100
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        HeadingText()
        TipSpacer(height = 16)
        TipTextField(
            label = "Enter amount",
            textValue = amountInput,
            onTextChange = {
                amountInput = it
                val amount = amountInput.toDoubleOrNull()
                val percent = percentInput.toDoubleOrNull()
                if (amount != null && percent != null)
                    calculate(amount = amount, percent = percent)
            }
        )
        TipSpacer(height = 12)
        TipTextField(
            label = "Enter percentage",
            textValue = percentInput,
            onTextChange = {
                percentInput = it
                val amount = amountInput.toDoubleOrNull()
                val percent = percentInput.toDoubleOrNull()
                if (amount != null && percent != null)
                    calculate(amount = amount, percent = percent)
            }
        )
        TipSpacer(height = 16)
        TipButton(
            onButtonClick = {
                showResult = true
            }
        )
        TipSpacer(height = 12)
        if (showResult) {
            if (isChecked) {
                NormalText(
                    textHere = "Tip is ${tip.toInt()}"
                )
            } else {
                NormalText(
                    textHere = "Tip is $tip"
                )
            }
        }

        RoundOff(
            isChecked = isChecked,
            onCheckChange = {
                isChecked = it
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TipScreenPreview() {
    TipScreen()
}
