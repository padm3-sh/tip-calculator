package com.example.tipcalculator.ui.screens.tip.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeadingText(modifier: Modifier = Modifier) {
    Text(
        text = "Tip Calculator",
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
    )
}

@Composable
fun TipTextField(
    label: String,
    textValue: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = textValue,
        onValueChange = onTextChange,
        maxLines = 1,
        label = {
            Text(
                text = label,
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            )
        }
    )
}

@Composable
fun RoundOff(
    isChecked: Boolean,
    onCheckChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        modifier = modifier
            .width((configuration.screenWidthDp / 2).dp)
            .clickable(enabled = true, onClick = { onCheckChange(!isChecked) })
    ) {
        Text(
            text = "Round Off?",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Switch(
            checked = isChecked,
            onCheckedChange = onCheckChange,
            modifier = Modifier
                .scale(0.7f)
        )
    }
}

@Composable
fun TipSpacer(
    modifier: Modifier = Modifier,
    width: Int = 0,
    height: Int = 0
) {
    Spacer(
        modifier = modifier
            .width(width.dp)
            .height(height.dp)
    )
}

@Composable
fun NormalText(textHere: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = textHere,
            style = TextStyle(
                fontWeight = Bold,
                fontSize = 20.sp
            )
        )
    }
}

@Composable
fun TipButton(
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onButtonClick
    ) {
        Text(
            text = "Calculate"
        )
    }
}
