package com.arstagaev.testkmm10.util

import java.util.*
import java.util.Locale

fun String.displayCountry() : String? = Locale.getISOCountries()
    .find { Locale("en", it.toString()).displayCountry == this }