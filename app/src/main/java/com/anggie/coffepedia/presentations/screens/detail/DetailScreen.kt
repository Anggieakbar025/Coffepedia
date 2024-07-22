package com.anggie.coffepedia.presentations.screens.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.anggie.coffepedia.presentations.theme.Americano
import com.anggie.coffepedia.presentations.theme.BlackCoffe
import com.anggie.coffepedia.presentations.theme.Coffe
import com.anggie.coffepedia.presentations.theme.Milk
import com.anggie.coffepedia.presentations.theme.SteamedMilk

@Composable
fun DetailScreen(navController: NavHostController, viewModel: DetailViewModel, id: String) {
    val context = LocalContext.current
    val coffe by viewModel.coffe.collectAsState()

    LaunchedEffect(id) {
        viewModel.getCoffeDetail(id.toInt())
    }

    Scaffold(
        content = { paddingValues ->
            Column(modifier = Modifier
                .padding(
                    start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                    end = paddingValues.calculateEndPadding(LayoutDirection.Ltr),
                    bottom = paddingValues.calculateBottomPadding(),
                )
                .background(BlackCoffe)
            ) {
                // Image at the top with no padding
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)) {
                    AsyncImage(
                        model = coffe?.imageUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp) // Adjust height as needed
                    )
                    IconButton(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.TopStart)
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background) // Set background color
                        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                        .background(BlackCoffe) // Background color for the column
                ) {
                    Column(
                        modifier = Modifier
                            .padding(vertical = 16.dp)
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState())
                            .align(Alignment.TopCenter)
                    ) {
                        coffe?.name?.ifBlank { "-" }?.let {
                            Text(
                                text = it,
                                style = TextStyle(fontSize = 24.sp, color = Milk, fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                        Text(
                            text = "Origin",
                            style = TextStyle(fontSize = 20.sp, color = Milk, fontWeight = FontWeight.Bold),
                            modifier = Modifier
                                .padding(horizontal =  16.dp)
                                .padding(top = 8.dp)
                        )
                        coffe?.region?.ifBlank { "-" }?.let {
                            Text(
                                text = it,
                                style = TextStyle(fontSize = 16.sp, color = SteamedMilk, fontWeight = FontWeight.Bold),
                                modifier = Modifier
                                    .padding(horizontal =  16.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Roast Level",
                            style = TextStyle(fontSize = 20.sp, color = Milk, fontWeight = FontWeight.Bold),
                            modifier = Modifier
                                .padding(horizontal =  16.dp)
                                .padding(top = 8.dp)
                        )
                        Text(
                            text = coffe?.roastLevel.toString(),
                            style = TextStyle(fontSize = 16.sp, color = SteamedMilk, fontWeight = FontWeight.Bold),
                            modifier = Modifier.padding(horizontal =  16.dp)
                        )
//                    for (i in 1..coffe?.roastLevel!!) {
//                        Row {
//                            Icon(
//                                imageVector = Icons.Rounded.Star,
//                                contentDescription = null,
//                                modifier = Modifier.size(24.dp),
//                                tint = MaterialTheme.colorScheme.primary
//                            )
//                        }
//                    }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Profile Flavour",
                            style = TextStyle(fontSize = 20.sp, color = Milk, fontWeight = FontWeight.Bold),
                            modifier = Modifier
                                .padding(horizontal =  16.dp)
                                .padding(top = 8.dp)
                        )
                        coffe?.flavorProfile?.map { flavor ->
                            Text(
                                text = flavor,
                                style = TextStyle(fontSize = 16.sp, color = SteamedMilk, fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(horizontal =  16.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Grind Option",
                            style = TextStyle(fontSize = 20.sp, color = Milk, fontWeight = FontWeight.Bold),
                            modifier = Modifier
                                .padding(horizontal =  16.dp)
                                .padding(top = 8.dp)

                        )
                        coffe?.grindOption?.map { grind ->
                            Text(
                                text = grind,
                                style = TextStyle(fontSize = 16.sp, color = SteamedMilk, fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(horizontal =  16.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "Description",
                            style = TextStyle(fontSize = 20.sp, color = Milk, fontWeight = FontWeight.Bold),
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .padding(top = 8.dp)
                        )
                        coffe?.description?.ifBlank { "-" }?.let {
                            Text(
                                text = it,
                                style = TextStyle(fontSize = 16.sp, color = SteamedMilk, fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(horizontal =  16.dp)
                            )
                        }
                    }
                    Button(
                        onClick = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tokopedia.com/search?q=$coffe.name"))
                            context.startActivity(intent)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .align(Alignment.BottomCenter),
                        colors = ButtonDefaults.buttonColors(containerColor = Coffe)
                    ) {
                        Text(text = "Open Link")
                    }
                }
            }
        }
    )
}