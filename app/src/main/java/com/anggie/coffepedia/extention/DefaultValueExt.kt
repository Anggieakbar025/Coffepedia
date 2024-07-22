package com.anggie.coffepedia.extention

import java.math.BigInteger
import java.util.Date

fun String?.orBlank(): String {
    return this ?: ""
}
fun String?.orStrip(): String {
    return this ?: "-"
}
fun Int?.orZero(): Int {
    return this ?: 0
}
fun Float?.orZeroFloat(): Float {
    return this ?: 0F
}
fun Int?.orMinusOne(): Int {
    return this ?: -1
}
fun BigInteger?.orZero(): BigInteger {
    return this ?: 0.toBigInteger()
}
fun BigInteger?.orMinusOne(): BigInteger {
    return this ?: (-1).toBigInteger()
}
fun Double?.orZero(): Double {
    return this ?: 0.0
}
fun Long?.orZero(): Long {
    return this ?: 0L
}
fun Long?.orMinusOne(): Long {
    return this ?: -1L
}
fun Boolean?.orFalse(): Boolean {
    return this ?: false
}
fun Boolean?.orTrue(): Boolean {
    return this ?: true
}
fun Date?.orNewDate(): Date {
    return this ?: Date()
}
fun String?.orZeroString(): String {
    return this ?: "0"
}