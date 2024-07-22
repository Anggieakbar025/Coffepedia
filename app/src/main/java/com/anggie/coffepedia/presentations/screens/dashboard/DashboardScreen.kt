package com.anggie.coffepedia.presentations.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.anggie.coffepedia.domain.model.CoffeModel
import com.anggie.coffepedia.presentations.navigation.NavigationItem
import com.anggie.coffepedia.presentations.theme.BlackCoffe
import com.anggie.coffepedia.presentations.theme.Milk

@Composable
fun DashboardScreen(navController: NavHostController, viewModel: DashboardViewModel) {
    val coffeList by viewModel.coffeList.collectAsState()

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(BlackCoffe) // Background color for the dashboard
        ) {
            // Greeting
            Text(
                text = "Find the best\ncoffe for you",
                style = TextStyle(fontSize = 24.sp, color = Milk, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(vertical = 32.dp, horizontal = 16.dp)
            )

            // Coffee List
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(coffeList) { coffee ->
                    CoffeeCard(coffee = coffee, onDetailClick = {
                        navController.navigate(
                            NavigationItem.Detail.createRoute(
                                coffee.id
                            )
                        )
                    })
                }
            }
        }
    }
}

@Composable
fun CoffeeCard(coffee: CoffeModel, onDetailClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = coffee.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxHeight()
                    .size(width = 100.dp, height = 140.dp)
                    .clip(RectangleShape),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = coffee.name,
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = coffee.description,
                    style = TextStyle(fontSize = 14.sp, color = Color.Gray),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = onDetailClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6F4F28)),
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(text = "View Details", color = Color.White)
                }
            }
        }
    }
}