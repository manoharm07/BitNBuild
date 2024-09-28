package com.example.wisewear.ui.theme.UserInfo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wisewear.R

@Composable
fun userProfile() {
    // State variables to store user inputs
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    var gender by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val genderOptions = listOf("Male", "Female", "Other")

    // Column to arrange elements vertically
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Profile Image (placeholder for now)
        Box(
            modifier = Modifier.size(128.dp),
            contentAlignment = Alignment.BottomEnd // Align the icon at the bottom right
        ) {
            // Profile Image (placeholder for now)
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background), // Add a placeholder image in your resources
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(128.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )
            // Icon to add an image (overlay)
            Icon(
                painter = painterResource(R.drawable.ic_launcher_foreground), // Use an appropriate resource for the add image icon
                contentDescription = "Add Image",
                modifier = Modifier
                    .size(32.dp)
                    .background(Color.White, CircleShape) // Add background to make it stand out
                    .padding(4.dp)
                    .clip(CircleShape)
                    .clickable {
                        // Handle image picking action here
                    }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Name Input
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Age Input
        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Gmail Input
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email ID") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Gender Input
        Box { // Wrapping the DropdownMenu inside a Box
            OutlinedTextField(
                value = gender,
                onValueChange = { gender = it}, // No need to handle text change
                readOnly = true, // Makes it read-only for selection only
                label = { Text("Gender") },
                modifier = Modifier.fillMaxWidth(),

                trailingIcon = {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Dropdown Arrow",
                        modifier = Modifier.clickable {
                            expanded = true
                        }
                    )
                }
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }, // Close dropdown when user clicks outside
                modifier = Modifier
                    .align(Alignment.BottomCenter)


            ) {
                genderOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            gender = option
                            expanded = false // Close the menu after selecting
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Submit Button
        Button(onClick = {
            // Handle the submit action here
        }) {
            Text(text = "Submit")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun User() {
    userProfile()
}
