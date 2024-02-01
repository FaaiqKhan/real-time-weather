package com.practice.realtimeweather.model.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import com.practice.realtimeweather.R

@Composable
fun TableView(title: String, description: String) {
    Row(modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.content_padding_extra_small))) {
        Text(
            text = title,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = description,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold)
        )
    }
}