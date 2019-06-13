package ak.oss.kunitconverter.categories

import ak.oss.kunitconverter.Name
import ak.oss.kunitconverter.categories.Distance.DistanceUnits.*

class Area : UnitCategory<Area.AreaUnits>() {
    override val mainUnitName: String
        get() = "Square Meter"

    enum class AreaUnits(private val sqrMeter: Double) : Unit {
        /**
         * Square Kilometers
         */
        SqrKm(Km.inMainUnit * Km.inMainUnit),

        /**
         * Square nautical miles
         */
        SqrNM(NauticalMile.inMainUnit * NauticalMile.inMainUnit),
        /**
         * Square feet
         */
        SqrFt(Ft.inMainUnit * Ft.inMainUnit),
        /**
         * Square centimeters
         */
        SqrCm(Cm.inMainUnit * Cm.inMainUnit);

        override val inMainUnit: Double
            get() = sqrMeter
    }

    @Name("toSqrMeter")
    fun toSqrMeter(value: Double, unit: AreaUnits): Double = unitToMain(value, unit)
    @Name("fromSqrMeter")
    fun fromSqrMeter(meters: Double, unit: AreaUnits): Double = mainToUnit(meters, unit)
}

