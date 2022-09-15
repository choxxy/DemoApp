package co.demo.core.util

import java.text.DecimalFormat

fun String?.currencyFormat(currency: String): String {
    if (this == null)
        return ""
    val formatter = DecimalFormat("###,###,###.##")
    val formatted = formatter.format(this.toDouble())
    return "$currency$formatted"
}
