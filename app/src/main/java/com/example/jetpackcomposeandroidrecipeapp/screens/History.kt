package com.example.jetpackcomposeandroidrecipeapp.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

/*
* Created a composable function that holds a text
* to differentiate between different tabs for the bottom navigation - HISTORY
* -> Basically the same layout as the RecipeList for now
* */
@Composable
fun History() {
    /*
    Box is a layout in Jetpack that aligns the content
    and background max size of the android template
     */
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.Center)
    {
        /*
        Text currently holds Recipe List that has header 1
        size and aligned center of the screen
         */
        Text(
            text = "History List",
            fontSize = MaterialTheme.typography.h1.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black
        )

    }
}

/*
* Add a composable preview that takes the RecipeList function
* and displays the text on the screen
*/
@Composable
@Preview
fun HistoryPreview() {
    History()
}