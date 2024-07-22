package com.anggie.coffepedia.presentations.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.anggie.coffepedia.R
import com.anggie.coffepedia.presentations.navigation.NavigationItem
import com.anggie.coffepedia.presentations.theme.Coffe
import com.anggie.coffepedia.presentations.theme.CoffeDark
import com.anggie.coffepedia.presentations.theme.ComposeMaterialTheme

@Composable
fun WelcomeScreen(navController: NavHostController?) {
    Scaffold(
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(
                        start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                        end = paddingValues.calculateEndPadding(LayoutDirection.Ltr),
                        bottom = paddingValues.calculateBottomPadding(),
                    )
                    .padding(top = 0.dp)
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.mipmap.bg_coffe),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 24.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 24.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Stay Focused",
                                style = TextStyle(fontSize = 24.sp, color = CoffeDark)
                            )
                            Text(
                                text = "Get the cup filled of your choice to stay focused and awake. See many option of coffe bean you need.",
                                style = TextStyle(fontSize = 16.sp, color = Color.Gray, textAlign = TextAlign.Center)
                            )
                            Button(
                                modifier = Modifier.fillMaxWidth(),
                                onClick = {
                                    navController?.navigate(NavigationItem.Dashboard.route)
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = Coffe)
                            ) {
                                Text(text = "Explore ...", color = Color.White)
                            }
                        }
                    }
                }
            }
        }
    )
}

@Preview
@Composable
fun PreviewWelcome() {
    ComposeMaterialTheme {
        WelcomeScreen(navController = null)
    }
}