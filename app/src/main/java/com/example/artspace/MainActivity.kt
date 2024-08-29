package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

// Main activity that sets up the content view of the app
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Apply the ArtSpace theme to the content
            ArtSpaceTheme {
                // Set up the surface for the UI components
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    // Display the ArtSpaceScreen composable
                    ArtSpaceScreen()
                }
            }
        }
    }
}

// Composable function that represents the main screen of the app
@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    // Artwork resources
    val firstArtwork = R.drawable.artwork1
    val secondArtwork = R.drawable.artwork2
    val thirdArtwork = R.drawable.artwork3
    val fourthArtwork = R.drawable.sample_artwork

    // State variables for managing the current artwork and its details
    var title by remember { mutableStateOf(R.string.Italy) }
    var year by remember { mutableStateOf(R.string.Italy_year) }
    var currentArtwork by remember { mutableStateOf(firstArtwork) }
    var imageResource by remember { mutableStateOf(currentArtwork) }

    // Layout for the screen
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Display the current artwork
        ArtworkDisplay(currentArtwork = currentArtwork)
        Spacer(modifier = Modifier.size(16.dp))
        // Display the title and year of the artwork
        ArtworkTitle(title = title, year = year)
        Spacer(modifier = Modifier.size(25.dp))
        Row(
            modifier = modifier.padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            // Button to navigate to the previous artwork
            Button(
                onClick = {
                    // Update the current artwork and its details
                    when (currentArtwork) {
                        firstArtwork -> {
                            currentArtwork = fourthArtwork
                            title = R.string.France
                            year = R.string.France_year
                        }
                        secondArtwork -> {
                            currentArtwork = firstArtwork
                            title = R.string.Italy
                            year = R.string.Italy_year
                        }
                        thirdArtwork -> {
                            currentArtwork = secondArtwork
                            title = R.string.germany
                            year = R.string.Germany_year
                        }
                        else -> {
                            currentArtwork = thirdArtwork
                            title = R.string.Europe
                            year = R.string.Europe_year
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.white)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                // Text for the "Previous" button
                Text(
                    text = "Previous",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.blue_300)
                )
            }
            // Button to navigate to the next artwork
            Button(
                onClick = {
                    // Update the current artwork and its details
                    when (currentArtwork) {
                        firstArtwork -> {
                            currentArtwork = secondArtwork
                            title = R.string.germany
                            year = R.string.Germany_year
                        }
                        secondArtwork -> {
                            currentArtwork = thirdArtwork
                            title = R.string.Europe
                            year = R.string.Europe_year
                        }
                        thirdArtwork -> {
                            currentArtwork = fourthArtwork
                            title = R.string.France
                            year = R.string.France_year
                        }
                        else -> {
                            currentArtwork = firstArtwork
                            title = R.string.Italy
                            year = R.string.Italy_year
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.blue_300)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                // Text for the "Next" button
                Text(
                    text = "Next",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}

// Composable function to display the artwork image
@Composable
fun ArtworkDisplay(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int
) {
    Image(
        painter = painterResource(currentArtwork),
        contentDescription = stringResource(id = R.string.germany),
        modifier = modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth
    )
}

// Composable function to display the title and year of the artwork
@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes year: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Artwork title
        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.blue_100),
            fontSize = 32.sp
        )

        // Artwork year
        Text(
            text = "— ${stringResource(id = year)} —",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_300)
        )
    }
}

// Preview function to display the UI in the Android Studio preview
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}

