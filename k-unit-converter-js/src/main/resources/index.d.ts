declare module 'k-unit-converter' {
export default UnitConverter
declare interface Angle {
	degreesMinutesSecondsStringToDegrees(string: String): number
	degreesMinutesSecondsToDegrees(deg: number, min: number, sec: number): number
	fromDegrees(degrees: number, unit: categories.Angle.AngleUnits): number
	toDegrees(value: number, unit: categories.Angle.AngleUnits): number
	toDegreesMinutesSecondsString(degrees: number, digitsAfterDecimalPoint: number): String
	convert(value: number, fromUnit: t, toUnit: t): number
	mainToUnit(value: number, unit: t): number
	unitToMain(value: number, unit: t): number
}

declare interface Area {
	fromSqrMeter(meters: number, unit: categories.Area.AreaUnits): number
	toSqrMeter(value: number, unit: categories.Area.AreaUnits): number
	convert(value: number, fromUnit: t, toUnit: t): number
	mainToUnit(value: number, unit: t): number
	unitToMain(value: number, unit: t): number
}

declare interface Distance {
	fromMeters(meters: number, unit: categories.Distance.DistanceUnits): number
	toMeters(value: number, unit: categories.Distance.DistanceUnits): number
	convert(value: number, fromUnit: t, toUnit: t): number
	mainToUnit(value: number, unit: t): number
	unitToMain(value: number, unit: t): number
}

declare interface Frequency {
	fromKHz(meters: number, unit: categories.Frequency.FrequencyUnits): number
	toKHz(value: number, unit: categories.Frequency.FrequencyUnits): number
	convert(value: number, fromUnit: t, toUnit: t): number
	mainToUnit(value: number, unit: t): number
	unitToMain(value: number, unit: t): number
}

declare interface JetFuelAmount {
	fromLb(meters: number, unit: categories.JetFuelAmount.JetFuelUnits): number
	toLb(value: number, unit: categories.JetFuelAmount.JetFuelUnits): number
	convert(value: number, fromUnit: t, toUnit: t): number
	mainToUnit(value: number, unit: t): number
	unitToMain(value: number, unit: t): number
}

declare interface Mass {
	fromKilograms(meters: number, unit: categories.Mass.MassUnits): number
	toKilograms(value: number, unit: categories.Mass.MassUnits): number
	convert(value: number, fromUnit: t, toUnit: t): number
	mainToUnit(value: number, unit: t): number
	unitToMain(value: number, unit: t): number
}

declare interface Pressure {
	fromInchesOfMercury(meters: number, unit: categories.Pressure.PressureUnits): number
	toInchesOfMercury(value: number, unit: categories.Pressure.PressureUnits): number
	convert(value: number, fromUnit: t, toUnit: t): number
	mainToUnit(value: number, unit: t): number
	unitToMain(value: number, unit: t): number
}

declare interface Speed {
	fromMetersPerSecond(metersPerSecond: number, unit: categories.Speed.SpeedUnits): number
	toMetersPerSecond(value: number, unit: categories.Speed.SpeedUnits): number
	convert(value: number, fromUnit: t, toUnit: t): number
	mainToUnit(value: number, unit: t): number
	unitToMain(value: number, unit: t): number
}

declare interface Temperature {
	celsiusToFahrenheit(celsius: number): number
	celsiusToKelvin(celsius: number): number
	fahrenheitToCelsius(fahrenheit: number): number
	kelvinToCelsius(kelvin: number): number
	mainToUnit(value: number, unit: categories.Temperature.TemperatureUnits): number
	unitToMain(value: number, unit: categories.Temperature.TemperatureUnits): number
	convert(value: number, fromUnit: t, toUnit: t): number
}

declare interface Volume {
	fromLiters(meters: number, unit: categories.Volume.VolumeUnits): number
	toLiters(value: number, unit: categories.Volume.VolumeUnits): number
	convert(value: number, fromUnit: t, toUnit: t): number
	mainToUnit(value: number, unit: t): number
	unitToMain(value: number, unit: t): number
}

export declare class UnitConverter {
	constructor()
	angle: Angle
	area: Area
	azimuth: Angle
	distance: Distance
	frequency: Frequency
	jetFuelAmount: JetFuelAmount
	mass: Mass
	pressure: Pressure
	speed: Speed
	temperature: Temperature
	velocity: Speed
	volume: Volume
	weight: Mass
}

/**
* All the available units
*/
export declare namespace categories{
	export namespace Angle{
		export declare enum AngleUnits {
			Rad,
			Grad,
			Minute,
			Second
		}
	}

	export namespace Area{
		export declare enum AreaUnits {
			SqrKm,
			SqrNM,
			SqrFt,
			SqrCm
		}
	}

	export namespace Distance{
		export declare enum DistanceUnits {
			Km,
			Cm,
			Mile,
			NauticalMile,
			Yard,
			Ft,
			In
		}
	}

	export namespace Frequency{
		export declare enum FrequencyUnits {
			Hz,
			MHz,
			GHz
		}
	}

	export namespace JetFuelAmount{
		export declare enum JetFuelUnits {
			Gallon,
			Liter,
			Kg,
			Tonne
		}
	}

	export namespace Mass{
		export declare enum MassUnits {
			Lb,
			Gram,
			Milligram,
			Tonne
		}
	}

	export namespace Pressure{
		export declare enum PressureUnits {
			KgPerSqrCm,
			LbPerSqrInch,
			MmOfMercury,
			Millibar,
			Bar
		}
	}

	export namespace Speed{
		export declare enum SpeedUnits {
			Knot,
			Mph,
			Kph
		}
	}

	export namespace Temperature{
		export declare enum TemperatureUnits {
			Fahrenheit,
			Kelvin
		}
	}

	export namespace Volume{
		export declare enum VolumeUnits {
			Gallon,
			CubicMeter,
			CubicCm
		}
	}

}
}