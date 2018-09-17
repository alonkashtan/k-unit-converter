package ak.oss.kunitconverter.categories

import ak.oss.kunitconverter.categories.Distance.DistanceUnits.*
import kotlin.math.*

class Speed : UnitCategory<Speed.SpeedUnits>() {


    override val mainUnitName: String
        get() = "Degrees"

    enum class SpeedUnits(private val metersPerSecond: Double) : Unit {
        /**
         * Nautical mile per hour
         */
        Knot(NauticalMile.inMainUnit/3600),
        /**
         * International mile per hour
         */
        Mph(Mile.inMainUnit/3600),
        /**
         * Kilometer per hour
         */
        Kph(1/3.6),
        /**
         * Speed of sound in **average conditions**
         */
        Mach(NauticalMile.inMainUnit*644.622/3600);

        override val inMainUnit: Double
            get() = metersPerSecond
    }

    fun toMetersPerSecond(value: Double, unit: SpeedUnits): Double = unitToMain(value, unit)
    fun fromMetersPerSecond(metersPerSecond: Double, unit: SpeedUnits): Double = mainToUnit(metersPerSecond, unit)
}

