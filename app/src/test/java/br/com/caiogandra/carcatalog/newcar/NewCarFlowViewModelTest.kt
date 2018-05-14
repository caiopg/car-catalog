package br.com.caiogandra.carcatalog.newcar

import br.com.caiogandra.carcatalog.model.Car
import br.com.caiogandra.carcatalog.newcar.viewmodel.NewCarFlowViewModel
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals

class NewCarFlowViewModelTest {

    private val CAR_TEST_ID = 0
    private val CAR_TEST_BRAND = "Car Test Brand"
    private val CAR_TEST_MODEL = "Car Test Model"
    private val CAR_TEST_YEAR = "2000"
    private val CAR_TEST_VALUE = 9999
    private val CAR_TEST_FIPECODE = "Car Test Fipe Code"

    private lateinit var testCar: Car
    private lateinit var testNewCarFlowViewModel: NewCarFlowViewModel

//    @Before
//    fun setup() {
//        testNewCarFlowViewModel = NewCarFlowViewModel()
//    }
//
//    @Test
//    fun testUpdateBrandSucess() {
//        //WHEN
//        testNewCarFlowViewModel.updateBrand(CAR_TEST_BRAND)
//
//        //THEN
//        assertEquals(testNewCarFlowViewModel.car.brand, CAR_TEST_BRAND)
//    }

}