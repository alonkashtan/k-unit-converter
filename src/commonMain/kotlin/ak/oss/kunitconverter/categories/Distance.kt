package ak.oss.kunitconverter.categories

import ak.oss.kunitconverter.Name

class Distance : UnitCategory<Distance.DistanceUnits>() {
    override val mainUnitName: String
        get() = "Meter"

    enum class DistanceUnits(private val inMeters: Double) : Unit {
        /**
         * Kilometers
         */
        Km(1000.0),
        /**
         * Centimeters
         */
        Cm(0.01),
        /**
         * International mile
         */
        Mile(1609.344),
        /**
         * Nautical Miles
         */
        NauticalMile(1852.0),
        /**
         * Yard
         */
        Yard(0.9144),
        /**
         * Feet
         */
        Ft(0.3048),
        /**
         * Inch
         */
        In(0.0254);

        override val inMainUnit: Double
            get() = inMeters
    }

    @Name("toMeters")
    fun toMeters(value: Double, unit: DistanceUnits): Double { return unitToMain(value, unit) }

    @Name("fromMeters")
    fun fromMeters(meters: Double, unit: DistanceUnits): Double = mainToUnit(meters, unit)
}