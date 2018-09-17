package ak.oss.kunitconverter.categories

import kotlin.math.*

class Angle : UnitCategory<Angle.AngleUnits>() {


    override val mainUnitName: String
        get() = "Degrees"

    enum class AngleUnits(private val degrees: Double) : Unit {
        /**
         * Radians
         */
        Rad(180/PI),
        Grad(0.9),
        Minute(1/60.0),
        Second(1/3600.0);

        override val inMainUnit: Double
            get() = degrees
    }

    fun toDegrees(value: Double, unit: AngleUnits): Double = unitToMain(value, unit)
    fun fromDegrees(degrees: Double, unit: AngleUnits): Double = mainToUnit(degrees, unit)

    /**
     * Prints degrees in the format of DD°MM'SS"
     */
    fun toDegreesMinutesSecondsString(degrees: Double, digitsAfterDecimalPoint: Int = 1): String {
        val deg = floor(degrees).roundToInt()
        val remain = (degrees%1)*60
        val minutes = floor(remain).roundToInt()
        val factor = 10.0.pow(digitsAfterDecimalPoint) //used to round to a specific precision
        val seconds = round((remain%1)*60*factor)/factor

        return "$deg°$minutes'$seconds\""
    }

    fun degreesMinutesSecondsStringToDegrees(string: String): Double {
        val components = string.split('°', '\'')
        return degreesMinutesSecondsToDegrees(components[0].toInt(), components[1].toInt(), components[2].toDouble())
    }

    fun degreesMinutesSecondsToDegrees(deg: Int, min: Int, sec: Double): Double = deg + min/60.0 + sec/3600.0
}

