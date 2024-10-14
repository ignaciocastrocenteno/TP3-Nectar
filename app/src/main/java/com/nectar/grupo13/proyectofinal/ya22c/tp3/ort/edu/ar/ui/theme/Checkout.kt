package com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nectar.grupo13.proyectofinal.ya22c.tp3.ort.edu.ar.R


@Composable
fun CheckoutModal() {
        CheckoutContent()
}

@Composable
fun CheckoutContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)


    ) {
        Row {
            Text(
                text = "Checkout",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Ver más"
            )
        }
        HorizontalDivider()

        CheckoutOptionRow(title = "Delivery", detail = "Select Method")

        HorizontalDivider()

        CheckoutOptionRowIcon(title = "Payment")

        HorizontalDivider()

        CheckoutOptionRow(title = "Promo Code", detail = "Pick discount")

        HorizontalDivider()

        CheckoutOptionRow(title = "Total Cost", detail = "$13.97")

        HorizontalDivider()

        Row {
            val text = buildAnnotatedString {
                append("By placing an order you agree to our\n")
                append(AnnotatedString("Terms ", spanStyle = SpanStyle(fontWeight = FontWeight.Bold)))
                append("And ")
                append(AnnotatedString("Conditions", spanStyle = SpanStyle(fontWeight = FontWeight.Bold)))
            }
            Text(text)
        }
        Button("Place Order")
    }
}

@Composable
fun CheckoutOptionRow(title: String, detail: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.weight(1f))
        Text(
            textAlign = TextAlign.End,
            text = detail,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
            )
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "Ver más"
        )
    }
}

@Composable
fun CheckoutOptionRowIcon(title: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.creditcard),
            contentDescription = "Increase",
        )
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "Ver más"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCheckoutModal() {
    CheckoutModal()
}