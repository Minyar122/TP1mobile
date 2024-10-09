package com.example.tp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tp1.ui.theme.TP1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TP1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageSwitcherExample(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ImageSwitcherExample(modifier: Modifier = Modifier) {
    // State to store the current image resource ID
    var imageResId by remember { mutableStateOf(R.drawable.photo1) }  // Default image

    Column(modifier = Modifier.fillMaxSize()) {
        // Display the selected image
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier.fillMaxSize().weight(1f),  // Image takes available space
            contentScale = ContentScale.Fit
        )

        // Button 1: Show Photo 1
        Button(
            onClick = { imageResId = R.drawable.photo1 },

        ) {
            Text(text = "Show Photo 1")
        }

        // Button 2: Show Photo 2
        Button(
            onClick = { imageResId = R.drawable.photo},

        ) {
            Text(text = "Show Photo 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImageSwitcherPreview() {
    TP1Theme {
        ImageSwitcherExample()
    }
}
