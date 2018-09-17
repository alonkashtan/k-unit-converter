package ak.oss.kunitconverter

import ak.oss.kunitconverter.categories.UnitCategory
import ak.oss.kunitconverter.categories.Unit
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse

internal class UnitCategoryBehaviourTest{

    class MockUnit : UnitCategory<MockUnit.MockUnits>() {
        override val mainUnitName: String
            get() = "Mock"

        enum class MockUnits(private val mainUnitValue: kotlin.Double) : Unit{
            Double(2.0),
            Triple(3.0),
            Half(0.5);

            override val inMainUnit: kotlin.Double
                get() = mainUnitValue
        }
    }

    private val mock: MockUnit = MockUnit()

    @Test
    fun testUnitToMain() {
        assertEquals(2.0, mock.unitToMain(1.0, MockUnit.MockUnits.Double), "Double")
        assertEquals(3.0, mock.unitToMain(1.0, MockUnit.MockUnits.Triple), "Triple")
        assertEquals(0.5, mock.unitToMain(1.0, MockUnit.MockUnits.Half), "Half")
    }

    @Test
    fun testMainToUnit() {
        assertEquals(0.5, mock.mainToUnit(1.0, MockUnit.MockUnits.Double), "Double")
        assertEquals(1.0/3.0, mock.mainToUnit(1.0, MockUnit.MockUnits.Triple), "Triple")
        assertEquals(2.0, mock.mainToUnit(1.0, MockUnit.MockUnits.Half), "Half")
    }

    @Test
    fun testConvert(){
        assertEquals(1.5, mock.convert(1.0, MockUnit.MockUnits.Triple, MockUnit.MockUnits.Double), "Triple -> Double")
        assertEquals(6.0, mock.convert(1.0, MockUnit.MockUnits.Triple, MockUnit.MockUnits.Half), "Triple -> Half")
        assertEquals(1.0/6.0, mock.convert(1.0, MockUnit.MockUnits.Half, MockUnit.MockUnits.Triple), "Half -> Triple")
        assertEquals(2.0/3.0, mock.convert(1.0, MockUnit.MockUnits.Double, MockUnit.MockUnits.Triple), "Double -> Triple")
        assertEquals(0.25, mock.convert(1.0, MockUnit.MockUnits.Half, MockUnit.MockUnits.Double), "Half -> Double")
        assertEquals(4.0, mock.convert(1.0, MockUnit.MockUnits.Double, MockUnit.MockUnits.Half), "Double -> Half")
    }

    @Test
    fun testOutOfBounds(){
       assertEquals(Double.POSITIVE_INFINITY, mock.mainToUnit(Double.MAX_VALUE-1, MockUnit.MockUnits.Half), "+∞")
       assertEquals(Double.NEGATIVE_INFINITY, mock.mainToUnit(-Double.MAX_VALUE+1, MockUnit.MockUnits.Half), "-∞")
       assertEquals(0.0, mock.mainToUnit(Double.MIN_VALUE, MockUnit.MockUnits.Double), "0")
    }
}