package com.elopez.pokedex.util

import androidx.compose.ui.graphics.Color
import com.elopez.pokedex.data.remote.responses.Stat
import com.elopez.pokedex.data.remote.responses.Type
import com.elopez.pokedex.ui.theme.AtkColor
import com.elopez.pokedex.ui.theme.DefColor
import com.elopez.pokedex.ui.theme.HPColor
import com.elopez.pokedex.ui.theme.SpAtkColor
import com.elopez.pokedex.ui.theme.SpDefColor
import com.elopez.pokedex.ui.theme.SpdColor
import com.elopez.pokedex.ui.theme.TypeBug
import com.elopez.pokedex.ui.theme.TypeDark
import com.elopez.pokedex.ui.theme.TypeDragon
import com.elopez.pokedex.ui.theme.TypeElectric
import com.elopez.pokedex.ui.theme.TypeFairy
import com.elopez.pokedex.ui.theme.TypeFighting
import com.elopez.pokedex.ui.theme.TypeFire
import com.elopez.pokedex.ui.theme.TypeFlying
import com.elopez.pokedex.ui.theme.TypeGhost
import com.elopez.pokedex.ui.theme.TypeGrass
import com.elopez.pokedex.ui.theme.TypeGround
import com.elopez.pokedex.ui.theme.TypeIce
import com.elopez.pokedex.ui.theme.TypeNormal
import com.elopez.pokedex.ui.theme.TypePoison
import com.elopez.pokedex.ui.theme.TypePsychic
import com.elopez.pokedex.ui.theme.TypeRock
import com.elopez.pokedex.ui.theme.TypeSteel
import com.elopez.pokedex.ui.theme.TypeWater
import java.util.Locale

fun parseTypeToColor(type: Type): Color {
    return when(type.type.name.toLowerCase(Locale.ROOT)) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "electric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}

fun parseStatToColor(stat: Stat): Color {
    return when(stat.stat.name.toLowerCase()) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.White
    }
}

fun parseStatToAbbr(stat: Stat): String {
    return when(stat.stat.name.toLowerCase()) {
        "hp" -> "HP"
        "attack" -> "Atk"
        "defense" -> "Def"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "Spd"
        else -> ""
    }
}