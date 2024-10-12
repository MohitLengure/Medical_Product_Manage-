package com.example.ui_layer.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle


@Composable
fun MutlicolorText(firstText:String,secondText:String,modifier:Modifier=Modifier)
{
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Red)) {
            append(firstText)
        }
        withStyle(style = SpanStyle(color= Color.White)){
            append(secondText)
        }

    }
    Text(text = annotatedString, modifier = modifier)
}