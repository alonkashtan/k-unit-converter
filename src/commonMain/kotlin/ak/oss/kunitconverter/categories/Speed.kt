package ak.oss.kunitconverter.categories

import ak.oss.kunitconverter.Name
import ak.oss.kunitconverter.categories.Distance.DistanceUnits.*
import kotlin.math.*

class Speed : UnitCategory<Speed.SpeedUnits>() {


    override val mainUnitName: String
        get() = "Meter per second"

    enum class SpeedUnits(private val metersPerSecond: Double) : Unit {
        /**
         * Nautical mile per hour (knot)
         */
        Knot(NauticalMile.inMainUnit/3600),
        /**
         * International mile per hour (mph)
         */
        Mph(Mile.inMainUnit/3600),
        /**
         * Kilometer per hour (kph)
         */
        Kph(1/3.6);

        override val inMainUnit: Double
            get() = metersPerSecond
    }

    @Name("toMetersPerSecond")
    fun toMetersPerSecond(value: Double, unit: SpeedUnits): Double = unitToMain(value, unit)
    @Name("fromMetersPerSecond")
    fun fromMetersPerSecond(metersPerSecond: Double, unit: SpeedUnits): Double = mainToUnit(metersPerSecond, unit)
}

