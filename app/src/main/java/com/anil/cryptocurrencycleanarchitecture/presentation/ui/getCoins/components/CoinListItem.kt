package com.anil.cryptocurrencycleanarchitecture.presentation.ui.getCoins.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anil.cryptocurrencycleanarchitecture.domain.model.Coin

@Composable
fun CoinListItem(coin: Coin,onItemClick:(Coin)->Unit){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${coin.rank} .  ${coin.name}   ${coin.symbol}",
            fontSize = 16.sp,
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        //Text(text = coin.name, fontSize = 16.sp, style = MaterialTheme.typography.body1, overflow = TextOverflow.Ellipsis)
        Text(text = if(coin.isActive)"Active" else "InActive",
            color=if(coin.isActive) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.body2,
            fontSize = 16.sp,  textAlign = TextAlign.End)
    }
}

@Preview
@Composable
fun DisplayingPreview(){
    CoinListItem(coin = Coin("1",true,true,"BitCoin",1,""), onItemClick ={} )
}