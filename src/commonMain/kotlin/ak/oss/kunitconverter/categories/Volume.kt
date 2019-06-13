package ak.oss.kunitconverter.categories

import ak.oss.kunitconverter.Name

class Volume : UnitCategory<Volume.VolumeUnits>() {
    override val mainUnitName: String
        get() = "Liter"

    enum class VolumeUnits(private val liters: Double) : Unit {
        /**
         * Gallon
         */
        Gallon(3.785412),
        /**
         * Cubic Meter (m3)
         */
        CubicMeter(1000.0),
        /**
         * Cubic centimeter (cm3 or cc)
         */
        CubicCm(0.001);

        override val inMainUnit: Double
            get() = liters
    }

    @Name("toLiters")
    fun toLiters(value: Double, unit: VolumeUnits): Double = unitToMain(value, unit)
    @Name("fromLiters")
    fun fromLiters(meters: Double, unit: VolumeUnits): Double = mainToUnit(meters, unit)
}

