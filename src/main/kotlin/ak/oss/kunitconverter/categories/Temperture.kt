package ak.oss.kunitconverter.categories

class Temperture : UnitCategory<Temperture.TemperatureUnits>() {


    override val mainUnitName: String
        get() = "Celsius"

    enum class TemperatureUnits(private val celsius: Double) : Unit {
        Fahrenheit(-32.0*5/9),
        Kelvin(-273.15);

        override val inMainUnit: Double
            get() = celsius
    }

    fun celsiusToFahrenheit(celsius: Double) : Double = celsius*9/5+32
    fun fahrenheitToCelsius(fahrenheit: Double) : Double = (fahrenheit-32)*5/9
    fun celsiusToKelvin(celsius: Double) : Double = celsius + 273.15
    fun kelvinToCelsius(kelvin: Double) : Double = kelvin - 273.15

    override fun mainToUnit(value: Double, unit: TemperatureUnits): Double {
        return when (unit) {
            TemperatureUnits.Fahrenheit -> celsiusToFahrenheit(value)
            TemperatureUnits.Kelvin -> celsiusToKelvin(value)
        }
    }

    override fun unitToMain(value: Double, unit: TemperatureUnits): Double {
        return when (unit) {
            TemperatureUnits.Fahrenheit -> fahrenheitToCelsius(value)
            TemperatureUnits.Kelvin -> kelvinToCelsius(value)
        }
    }
}