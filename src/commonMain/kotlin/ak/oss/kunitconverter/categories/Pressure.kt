package ak.oss.kunitconverter.categories

import ak.oss.kunitconverter.Name

/**
 * Inches of mercury is also called 'Hg'
 */
class Pressure : UnitCategory<Pressure.PressureUnits>() {
    override val mainUnitName: String
        get() = "Inches Of Mercury"

    enum class PressureUnits(private val inchesOfMercury: Double) : Unit {
        /**
         * Kilogram per square centimeter (in/cm^2)
         */
        KgPerSqrCm(98066.5/3386.3881579),
        /**
         * Libras per square inch (lb/in^2 or psi)
         */
        LbPerSqrInch(2.036020374505114),
        /**
         * Millimeter of mercury (mmHg)
         */
        MmOfMercury(1/25.4),
        /**
         * Millibar
         */
        Millibar(1/33.86389),
        /**
         * Bar
         */
        Bar(1/0.03386389);


        override val inMainUnit: Double
            get() = inchesOfMercury
    }

    @Name("toInchesOfMercury")
    fun toInchesOfMercury(value: Double, unit: PressureUnits): Double = unitToMain(value, unit)
    @Name("fromInchesOfMercury")
    fun fromInchesOfMercury(meters: Double, unit: PressureUnits): Double = mainToUnit(meters, unit)
}