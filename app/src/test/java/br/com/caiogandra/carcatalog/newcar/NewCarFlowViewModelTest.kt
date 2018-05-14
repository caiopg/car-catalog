package br.com.caiogandra.carcatalog.newcar

import br.com.caiogandra.carcatalog.datasource.car.CarRepository
import br.com.caiogandra.carcatalog.model.Car
import br.com.caiogandra.carcatalog.newcar.viewmodel.NewCarFlowViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator

@RunWith(MockitoJUnitRunner::class)
class NewCarFlowViewModelTest {

    private val CAR_TEST_BRAND = "Car Test Brand"
    private val CAR_TEST_MODEL = "Car Test Model"
    private val CAR_TEST_YEAR = "2000"
    private val CAR_TEST_VALUE = 9999
    private val CAR_TEST_FIPECODE = "Car Test Fipe Code"

    @Mock private lateinit var carRepository: CarRepository
    @Mock private lateinit var testCar: Car

    private lateinit var testNewCarFlowViewModel: NewCarFlowViewModel

    @Before
    fun setup() {
        testNewCarFlowViewModel = NewCarFlowViewModel(carRepository)
    }


    @Test
    fun testUpdateBrandSuccess() {

        //WHEN
        testNewCarFlowViewModel.updateBrand(CAR_TEST_BRAND)

        //THEN
        assertEquals(testNewCarFlowViewModel.car.brand, CAR_TEST_BRAND)
    }

    @Test
    fun testUpdateCarSuccess() {

        //WHEN
        testNewCarFlowViewModel.updateCar(CAR_TEST_MODEL, CAR_TEST_YEAR, CAR_TEST_VALUE, CAR_TEST_FIPECODE)

        //THEN
        assertEquals(testNewCarFlowViewModel.car.model, CAR_TEST_MODEL)
        assertEquals(testNewCarFlowViewModel.car.year, CAR_TEST_YEAR)
        assertEquals(testNewCarFlowViewModel.car.value, CAR_TEST_VALUE)
        assertEquals(testNewCarFlowViewModel.car.fipeCode, CAR_TEST_FIPECODE)
    }

    @Test
    fun testGetBrandSuccess() {
        //GIVEN
        testNewCarFlowViewModel.car.brand = CAR_TEST_MODEL

        //WHEN
        val result = testNewCarFlowViewModel.getBrand()

        //THEN
        assertEquals(result, CAR_TEST_MODEL)
    }

}