package ak.oss.kunitconverter.categories

import ak.oss.kunitconverter.Name

class Frequency : UnitCategory<Frequency.FrequencyUnits>() {
    override val mainUnitName: String
        get() = "Kilo Hz"

    enum class FrequencyUnits(private val kHz: Double) : Unit {
        /**
         * Herz
         */
        Hz(0.001),
        /**
         * Mega Herz
         */
        MHz(1000.0),
        /**
         * Giga Herz
         */
        GHz(1_000_000.0);

        override val inMainUnit: Double
            get() = kHz
    }

    @Name("toKHz")
    fun toKHz(value: Double, unit: FrequencyUnits): Double = unitToMain(value, unit)
    @Name("fromKHz")
    fun fromKHz(meters: Double, unit: FrequencyUnits): Double = mainToUnit(meters, unit)
}

