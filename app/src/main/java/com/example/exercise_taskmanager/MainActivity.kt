package com.example.exercise_taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exercise_taskmanager.ui.theme.ExerciseTaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExerciseTaskManagerTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                        MainWindowView(taskCompletedInfo = stringResource(R.string.taskCopleted), motivatedInfo = stringResource(
                            R.string.motivationInfo) )
                }
            }
        }
    }
}

@Composable
fun InformationSection(taskCompletedInfo: String, motivatedInfo: String, modifier: Modifier = Modifier) {
    Column (        modifier = modifier.fillMaxWidth()){
        Text(
            text = taskCompletedInfo,
            modifier = modifier
                .padding(top = 24.dp)
                .padding(bottom = 8.dp)
                .align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold,
        )

        Text(
            text = motivatedInfo,
            modifier = modifier
                .align(Alignment.CenterHorizontally),
            fontSize = 16.sp
        )
    }
}

@Composable
fun ImageSuccess (modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.ic_task_completed)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Inside,
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun MainWindowView(taskCompletedInfo: String, motivatedInfo: String, modifier: Modifier = Modifier) {
    Column (verticalArrangement = Arrangement.Center){
        ImageSuccess()
        InformationSection(taskCompletedInfo = taskCompletedInfo, motivatedInfo = motivatedInfo )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExerciseTaskManagerTheme {
       MainWindowView(taskCompletedInfo = stringResource(R.string.taskCopleted), motivatedInfo = stringResource(
            R.string.motivationInfo) )
    }
}