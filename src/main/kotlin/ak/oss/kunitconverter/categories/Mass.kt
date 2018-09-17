package ak.oss.kunitconverter.categories

class Mass : UnitCategory<Mass.MassUnits>() {
    override val mainUnitName: String
        get() = "Kilogram"

    enum class MassUnits(private val kilograms: Double) : Unit {
        /**
         * Libras
         */
        Lb(0.45359237),
        /**
         * Grams
         */
        Gram(0.001),
        /**
         * Milligrams
         */
        Milligram(0.000001),
        /**
         * Metric tonne
         */
        Tonne(1000.0);

        override val inMainUnit: Double
            get() = kilograms
    }

    fun toKilograms(value: Double, unit: MassUnits): Double = unitToMain(value, unit)
    fun fromKilograms(meters: Double, unit: MassUnits): Double = mainToUnit(meters, unit)
}

