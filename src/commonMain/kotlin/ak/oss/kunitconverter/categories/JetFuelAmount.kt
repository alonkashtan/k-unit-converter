package ak.oss.kunitconverter.categories

import ak.oss.kunitconverter.Name

/**
 * This unit is the amount of jet fuel. Around the world, different people use different units, some of them
 * don't make much sense such as 'libra' or 'Kg'. So all the conversion here is only true for the
 * physical properties of jet fuel, and would not be true for any other liquid.
 */
class JetFuelAmount : UnitCategory<JetFuelAmount.JetFuelUnits>() {
    override val mainUnitName: String
        get() = "Libras of jet fuel"

    enum class JetFuelUnits(private val lb: Double) : Unit {
        /**
         * Gallon of jet fuel
         */
        Gallon(3.05672001558/Mass.MassUnits.Lb.inMainUnit),
        /**
         * Liter of jet fuel
         */
        Liter(0.802838/Mass.MassUnits.Lb.inMainUnit),
        /**
         * Kilogram of jet fuel
         */
        Kg(1/Mass.MassUnits.Lb.inMainUnit),
        /**
         * Metric tonne of jet fuel
         */
        Tonne(1000/Mass.MassUnits.Lb.inMainUnit);

        override val inMainUnit: Double
            get() = lb
    }

    @Name("toLb")
    fun toLb(value: Double, unit: JetFuelUnits): Double = unitToMain(value, unit)
    @Name("fromLb")
    fun fromLb(meters: Double, unit: JetFuelUnits): Double = mainToUnit(meters, unit)
}