@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.navigasiku.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.navigasiku.R

@Composable
fun FormIsian(
    jenisK: List<String> = listOf("Laki-Laki", "Perempuan"),
    onSubmitBtnClick: () -> Unit
) {
    // 🔹 State untuk input form
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var selectedJK by remember { mutableStateOf(jenisK.first()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.home),
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(isiRuang)
                .padding(20.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // 🔹 Input Nama
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                singleLine = true,
                modifier = Modifier.width(250.dp),
                label = { Text("Nama Lengkap") }
            )

            Divider(
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .width(250.dp),
                thickness = 1.dp,
                color = Color.Red
            )

            // 🔹 Pilihan Jenis Kelamin
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                jenisK.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = selectedJK == item,
                            onClick = { selectedJK = item }
                        )
                        Text(text = item)
                    }
                }
            }

            Divider(
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .width(250.dp),
                thickness = 1.dp,
                color = Color.Red
            )

            // 🔹 Input Alamat
            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                singleLine = true,
                modifier = Modifier.width(250.dp),
                label = { Text("Alamat") }
            )

            Spacer(modifier = Modifier.height(30.dp))

            // 🔹 Tombol Submit
            Button(
                modifier = Modifier.width(250.dp),
                onClick = onSubmitBtnClick
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
    }
}
