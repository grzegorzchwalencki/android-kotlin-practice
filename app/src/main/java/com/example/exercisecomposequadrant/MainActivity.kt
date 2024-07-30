package com.example.exercisecomposequadrant


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.exercisecomposequadrant.ui.theme.ExerciseComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExerciseComposeQuadrantTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                FinalCompositionElementsOnScreen(textBox1 = stringResource(R.string.textBox1),
                    textBox2 = stringResource(R.string.textBox2),
                    textBox3 = stringResource(R.string.textBox3),
                    textBox4 = stringResource(R.string.textBox4),
                    head1 = stringResource(R.string.head1),
                    head2 = stringResource(R.string.head2),
                    head3 = stringResource(R.string.head3),
                    head4 = stringResource(R.string.head4))
                }
            }
        }
    }
}

@Composable
fun TextArrangementOnCard(head:String, textbox: String, modifier: Modifier=Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ){
        Text(text = head,
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
            )

        Text(text = textbox,
            modifier = modifier
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun CardFootprint(head: String, textbox:String, color: Color, modifier: Modifier = Modifier) {
    Card(modifier = Modifier
            .fillMaxSize(),
        colors = CardDefaults.cardColors(
            containerColor = color
        )
    ) {

        TextArrangementOnCard(head = head, textbox = textbox)
}}

@Composable
fun FinalCompositionElementsOnScreen(textBox1: String, textBox2: String,
                                     textBox3: String, textBox4: String,
                                     head1: String, head2: String,
                                     head3: String, head4: String,
                                     modifier: Modifier = Modifier) {

       Column (modifier = modifier
           .fillMaxWidth()
           .padding(top = 16.dp)
       ) {
           Row (modifier = modifier
               .weight(0.5f)
           ){
               Column (modifier = modifier
                   .weight(0.25f)
                   ,
               ){
                  CardFootprint(
                      head = head1,
                      textbox = textBox1,
                      color = Color(0xFFEADDFF)
                  )
               }
               Column (modifier = modifier
                   .weight(0.25f),
               ){
                   CardFootprint(
                       head = head2,
                       textbox = textBox2,
                       color = Color(0xFFD0BCFF))
               }
           }
           Row (modifier = modifier
                   .weight(0.5f)
           ){
               Column (modifier = modifier
                       .weight(0.25f)
               ){
                   CardFootprint(
                       head = head3,
                       textbox = textBox3,
                       color = Color(0xFFB69DF8))
               }
               Column (modifier = modifier
                   .weight(0.25f),
                   ){
                   CardFootprint(
                       head = head4,
                       textbox = textBox4,
                       color = Color(0xFFF6EDFF)
                   )
               }
           }
       }
    }


@Preview(showBackground = true)
@Composable
fun FinalCompositionElementsOnScreenPreview() {
    ExerciseComposeQuadrantTheme {
        FinalCompositionElementsOnScreen(
            textBox1 = stringResource(R.string.textBox1),
            textBox2 = stringResource(R.string.textBox2),
            textBox3 = stringResource(R.string.textBox3),
            textBox4 = stringResource(R.string.textBox4),
            head1 = stringResource(R.string.head1),
            head2 = stringResource(R.string.head2),
            head3 = stringResource(R.string.head3),
            head4 = stringResource(R.string.head4)
        )
    }
}