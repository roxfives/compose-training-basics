package com.example.myapplication.ui.theme

import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = AbsoluteCutCornerShape(0.dp, 4.dp, 4.dp, 0.dp), //RoundedCornerShape(4.dp),
    medium = AbsoluteCutCornerShape(0.dp, 4.dp, 4.dp, 0.dp), //RoundedCornerShape(4.dp),
    large = AbsoluteCutCornerShape(0.dp, 4.dp, 4.dp, 0.dp), //RoundedCornerShape(0.dp)
)