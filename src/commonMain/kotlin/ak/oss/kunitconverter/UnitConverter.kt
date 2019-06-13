package ak.oss.kunitconverter

import ak.oss.kunitconverter.categories.*

class UnitConverter{
    /**
     * Distance units, including altitude and length
     */
    val distance = Distance()

    /**
     * Pressure units
     */
    val pressure = Pressure()

    /**
     * Mass (broadly called weight) units
     */
    val mass = Mass()
    /**
     * Mass (broadly called weight) units. Same as [mass]
     */
    val weight = mass

    /**
     * Volume (the amount of space occupied by a 3-dimensional object, not related to sound) units
     */
    val volume = Volume()

    /**
     * Area (the amount of space occupied by a 3-dimensional object) units
     */
    val area = Area()

    /**
     * Frequency units
     */
    val frequency = Frequency()

    /**
     * Amount of jet fuel. Around the world, different people use different units, some of them
     * don't make much sense such as 'libra' or 'Kg'. So all the conversion here is only true for the
     * physical properties of jet fuel, and would not be true for any other liquid.
     */
    val jetFuelAmount = JetFuelAmount()

    /**
     * Angle units
     */
    val angle = Angle()

    /**
     * Angle units. Same as [angle]
     */
    val azimuth = angle

    /**
     * Temperature units
     */
    val temperature = Temperature()

    /**
     * Speed units
     */
    val speed = Speed()

    /**
     * Speed units. same as [speed]
     */
    val velocity = speed

}