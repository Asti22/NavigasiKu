@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.navigasiku.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.material3.DividerDefaults.Thickness
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.navigasiku.R
import kotlin.time.Duration.Companion.days

@Composable
fun FormIsian(
    jenisK: List<String> = listOf("Laki-Laki", "Perempuan"),
    onSubmitBtnClick: () -> Unit
) {
    Scaffold(
        modifier = Modifier,
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
            ) }
    ){isiRuang ->
        Column (modifier = Modifier.padding(paddingValues = isiRuang),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally){
            OutlinedTextField(
                value = "",
                singleLine = true,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(width = 250.dp),
                label = {Text(text = "Nama Lengkap")},
                onValueChange = {}
            )
            HorizontalDivider(modifier = Modifier
                .padding(all = 20.dp)
                .width(width = 250.dp), thickness = Thickness, color =Color.Red)
            Row {
                jenisK.forEach {
                    item->
                    Row (verticalAlignment = Alignment.CenterHorizontally){
                        RadioButton(
                            selected = false,
                            onClick = {item}
                        )
                        Text(text = item)
                    }
                }
            }
        }

    }