package ak.oss.kunitconverter

import ak.oss.kunitconverter.categories.*
import kotlin.math.pow
import kotlin.math.round
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * This class doesn't check the behaviour of the converter but rather the values of the units.
 * Each function is converting the main unit to all the different units and compares the result to the
 * a conversion done online (mostly Google) rounded to 4 decimal digits (because sometimes the results on Google are rounded
 * or less accurate).
 * In addition all local functions of a specific converter are tested to see that the functionality is working.
 */
internal class UnitConverterUnitValuesTest {

    private val unitConverter = UnitConverter()

    private fun assertRounded(expected: Double, actual: Double, message: String, precision: Int = 4){
        fun round(num: Double, precision:Int) = round(num*10.0.pow(precision))/10.0.pow(precision)
        assertEquals(round(expected, precision), round(actual, precision), message)
    }

    @Test
    fun distance() {
        val distance = unitConverter.distance
        assertRounded(2.0, distance.fromMeters(2000.0,Distance.DistanceUnits.Km), "m -> km")
        assertRounded(200.0, distance.fromMeters(2.0, Distance.DistanceUnits.Cm), "m -> cm")
        assertRounded(0.310686, distance.fromMeters(500.0, Distance.DistanceUnits.Mile), "m -> mile")
        assertRounded(2.699784, distance.fromMeters(5000.0, Distance.DistanceUnits.NauticalMile), "m -> NM")
        assertRounded(5.46807, distance.fromMeters(5.0, Distance.DistanceUnits.Yard), "m -> yard")
        assertRounded(16.40421, distance.fromMeters(5.0, Distance.DistanceUnits.Ft), "m -> ft")
        assertRounded(196.8503937, distance.fromMeters(5.0, Distance.DistanceUnits.In), "m -> in")

        assertRounded(2000.0, distance.toMeters(2.0,Distance.DistanceUnits.Km), "km -> m")
    }

    @Test
    fun pressure(){
        val pressure = unitConverter.pressure
        assertRounded(17.265778833751, pressure.fromInchesOfMercury(500.0, Pressure.PressureUnits.KgPerSqrCm), "Hg -> in/cm^2")
        assertRounded(24.55771, pressure.fromInchesOfMercury(50.0, Pressure.PressureUnits.LbPerSqrInch), "Hg -> lb/in^2")
        assertRounded(1270.0, pressure.fromInchesOfMercury(50.0, Pressure.PressureUnits.MmOfMercury), "Hg -> mmHg")
        assertRounded(16931.945, pressure.fromInchesOfMercury(500.0, Pressure.PressureUnits.Millibar), "Hg -> mbar")
        assertRounded(16.931945, pressure.fromInchesOfMercury(500.0, Pressure.PressureUnits.Bar), "Hg -> bar")

        assertRounded(50.0, pressure.toInchesOfMercury(1270.0, Pressure.PressureUnits.MmOfMercury), "mmHg -> Hg")
    }

    @Test
    fun mass(){
        val mass = unitConverter.mass
        assertEquals(mass, unitConverter.weight)

        assertRounded(22.0462, mass.fromKilograms(10.0, Mass.MassUnits.Lb), "kg -> lb")
        assertRounded(10_000.0, mass.fromKilograms(10.0, Mass.MassUnits.Gram), "kg -> g")
        assertRounded(100_000.0, mass.fromKilograms(0.1, Mass.MassUnits.Milligram), "kg -> mg")
        assertRounded(0.01, mass.fromKilograms(10.0, Mass.MassUnits.Tonne), "kg -> tn")

        assertRounded(10.0, mass.toKilograms(0.01, Mass.MassUnits.Tonne), "tn -> kg")
    }

    @Test
    fun volume(){
        val volume = unitConverter.volume
        assertRounded(1.32086, volume.fromLiters(5.0, Volume.VolumeUnits.Gallon), "l -> gal")
        assertRounded(0.05, volume.fromLiters(50.0, Volume.VolumeUnits.CubicMeter), "l -> m3")
        assertRounded(5000.0, volume.fromLiters(5.0, Volume.VolumeUnits.CubicCm), "l -> cc")

        assertRounded(5.0, volume.toLiters(5000.0, Volume.VolumeUnits.CubicCm), "cc -> l")
    }

    @Test
    fun area(){
        val area = unitConverter.area
        assertRounded(0.001, area.fromSqrMeter(1000.0, Area.AreaUnits.SqrKm), "m2 -> km2")
        assertRounded(0.029155335, area.fromSqrMeter(100_000.0, Area.AreaUnits.SqrNM), "m2 -> nm2")
        assertRounded(53.8196, area.fromSqrMeter(5.0, Area.AreaUnits.SqrFt), "m2 -> ft2")
        assertRounded(100.0, area.fromSqrMeter(0.01, Area.AreaUnits.SqrCm), "m2 -> cm2")

        assertRounded(0.01, area.toSqrMeter(100.0, Area.AreaUnits.SqrCm), "cm2 -> m2")
    }

    @Test
    fun frequency(){
        val frequency = unitConverter.frequency
        assertRounded(5000.0, frequency.fromKHz(5.0, Frequency.FrequencyUnits.Hz), "kHz -> Hz")
        assertRounded(5.0, frequency.fromKHz(5000.0, Frequency.FrequencyUnits.MHz), "kHz -> MHz")
        assertRounded(0.005, frequency.fromKHz(5000.0, Frequency.FrequencyUnits.GHz), "kHz -> GHz")

        assertRounded(5000.0, frequency.toKHz(0.005, Frequency.FrequencyUnits.GHz), "GHz -> kHz")
    }

    @Test
    fun jetFuel(){
        //TODO: find out the correct values
        /*val jetFuelAmount = unitConverter.jetFuelAmount

        // based on http://mye6b.com/Fuel/
        assertRounded(1.49253731343283568833, jetFuelAmount.fromLb(10.0, JetFuelAmount.JetFuelUnits.Gallon), "lb -> gal")
        assertRounded(5.64986834198810594643, jetFuelAmount.fromLb(10.0, JetFuelAmount.JetFuelUnits.Liter), "lb -> l")
        assertRounded(4.53592369968886188758, jetFuelAmount.fromLb(10.0, JetFuelAmount.JetFuelUnits.Kg), "lb -> kg")
        assertRounded(408.23, jetFuelAmount.fromLb(900_000.0, JetFuelAmount.JetFuelUnits.Kg), "lb -> k", 2)*/
    }

    @Test
    fun angle(){
        val angle = unitConverter.angle
        assertEquals(angle, unitConverter.azimuth)

        assertRounded(0.174533, angle.fromDegrees(10.0, Angle.AngleUnits.Rad), "deg -> rad")
        assertRounded(11.1111, angle.fromDegrees(10.0, Angle.AngleUnits.Grad), "deg -> grad")
        assertRounded(600.0, angle.fromDegrees(10.0, Angle.AngleUnits.Minute), "deg -> min")
        assertRounded(36000.0, angle.fromDegrees(10.0, Angle.AngleUnits.Second), "deg -> sec")

        // based on https://www.rapidtables.com/convert/number/degrees-to-degrees-minutes-seconds.html
        assertEquals("12°7'22.8\"", angle.toDegreesMinutesSecondsString(12.123), "deg -> DSM")
        assertEquals("171°51'57.55\"", angle.toDegreesMinutesSecondsString(171.865987463, 2), "deg -> DSM")
        assertRounded(36.74417, angle.degreesMinutesSecondsToDegrees(35,103,99.18), "DSM -> deg")
        assertRounded(36.74417, angle.degreesMinutesSecondsStringToDegrees("35°103'99.18"), "DSM string -> deg")
    }

    @Test
    fun temperature() {
        val temperature = unitConverter.temperture
        assertRounded(50.0, temperature.celsiusToFahrenheit(10.0), "c -> f")
        assertRounded(10.0, temperature.fahrenheitToCelsius(50.0), "f -> c")
        assertRounded(90.194, temperature.celsiusToFahrenheit(32.33), "c -> f")
        assertRounded(32.33, temperature.fahrenheitToCelsius(90.194), "f -> c")
        assertRounded(90.194, temperature.mainToUnit(32.33, Temperture.TemperatureUnits.Fahrenheit), "c -> f")
        assertRounded(32.33, temperature.unitToMain(90.194, Temperture.TemperatureUnits.Fahrenheit), "f -> c")

        assertRounded(283.15, temperature.celsiusToKelvin(10.0), "c -> K")
        assertRounded(10.0, temperature.kelvinToCelsius(283.15), "K -> c")
        assertRounded(305.48, temperature.celsiusToKelvin(32.33), "c -> K")
        assertRounded(32.33, temperature.kelvinToCelsius(305.48), "K -> c")
        assertRounded(305.48, temperature.mainToUnit(32.33, Temperture.TemperatureUnits.Kelvin), "c -> K")
        assertRounded(32.33, temperature.unitToMain(305.48, Temperture.TemperatureUnits.Kelvin), "K -> c")
    }
}