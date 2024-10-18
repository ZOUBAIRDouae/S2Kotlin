package com.example.cartevisite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartevisite.ui.theme.CarteVisiteTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.Button

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarteVisiteTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    ComposeVilleApp()
                }
            }
        }
    }
}

@Composable
fun ComposeVilleApp() {
    VilleImage(
        backgroundImg = painterResource(R.drawable.nfcux83rg0b62nkis_zkv4yaarf5idrthtmchufq2ou),
    )
}

@Composable
private fun VilleImage(
    backgroundImg: Painter,
    modifier: Modifier = Modifier
) {
    data class Place(
        val imageResource: Int,
        val title: String,
        val description: String
    )

    var result by remember {mutableStateOf(1)}
    val (imageResource, titleResource, descriptionResource) = when (result){

        1 -> Place(
            R.drawable.adobestock_206673585,
            stringResource(R.string.title_2),
            stringResource(R.string.description_place_2)
        )
        2 -> Place(
            R.drawable.mariembensaid_chaouen_symbol,
            stringResource(R.string.title_3),
            stringResource(R.string.description_place_3)
        )

        else -> Place(
            R.drawable.raselmas,
            stringResource(R.string.title_1),
            stringResource(R.string.description_place_1)
        )
    }

    Box {
        Image(
            painter = backgroundImg,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = result.toString(),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 50.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .size(width = 300.dp, height = 200.dp)
                    .shadow(elevation = 10.dp, shape = RoundedCornerShape(16.dp))
                    .border(
                        width = 2.dp,
                        color = Color(0xFF006994),
                    )
            )
            Text(
                text = titleResource,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .shadow(elevation = 4.dp)
                    .padding(horizontal = 10.dp)
            )
            Text(
                text = descriptionResource,
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 10.dp)
                    .shadow(4.dp)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Black.copy(alpha = 0.3f), Color.Transparent)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(12.dp)
            )
            Button(onClick = { result = (1..3).random()}) {
                Text(stringResource(R.string.change))
            }

        }
    }
}



@Preview(showBackground = true)
@Composable
fun CartePreview() {
    CarteVisiteTheme {
        ComposeVilleApp()
    }
}
