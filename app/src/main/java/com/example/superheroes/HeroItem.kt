package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.ui.theme.SuperheroesTheme

/**
 * Composable displaying a hero list item
 *
 * @param Hero data class with Hero information
 * @param modifier modifier modifiers to set to this composable
 */
@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.card_elevation)
        ),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .sizeIn(minHeight = dimensionResource(R.dimen.item_height))
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_medium)))
            Box(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.item_height))
                    .clip(RoundedCornerShape(dimensionResource(R.dimen.padding_small)))
            ) {
                Image(
                    painterResource(id = hero.imageRes),
                    contentDescription = null,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}

@Composable
@Preview
fun HeroItemPreview() {
    SuperheroesTheme {
        HeroItem(
            HeroesRepository.heroes.first()
        )
    }
}