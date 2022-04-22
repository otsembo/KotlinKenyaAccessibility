package com.example.accessibilitydemo_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TopAppBar
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.accessibilitydemo_compose.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                AppPage()
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun AppPage() {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) {

        Column(modifier = Modifier.fillMaxSize()) {

            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = MaterialTheme.colorScheme.primaryContainer) {
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = stringResource(id = R.string.app_name),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,)
            }

            MyImage(modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(top = 16.dp, start = 16.dp, end = 16.dp))
            
            
            OutlinedTextField(value = "",
                onValueChange = {},
                label = {
                Text(text = stringResource(id = R.string.username),)
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp))

            OutlinedTextField(value = "",
                onValueChange = {},
                label = {
                    Text(text = stringResource(id = R.string.password),)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            )

            MyCheckBox(modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp, top = 16.dp, end = 16.dp
                ), text = stringResource(id = R.string.remember_me))

            Button(onClick = {}, modifier = Modifier
                .align(CenterHorizontally)
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)) {

                Text(text = stringResource(id = R.string.log_in), )

            }


            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center){
                Text(text = stringResource(id = R.string.create_an_account),
                    modifier = Modifier
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp))

            }


        }

    }

}

@Composable
fun MyImage(modifier: Modifier) {

    AsyncImage(
        modifier = modifier,
        model = R.drawable.login_image,
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
    
}

@Composable
@ExperimentalMaterial3Api
fun MyCheckBox(modifier: Modifier, text:String = "") {

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {

        Checkbox(checked = false,
            onCheckedChange = {},
        )

        Text(text = text, )

    }

}
