package br.com.caiogandra.carcatalog.datasource

import br.com.caiogandra.carcatalog.datasource.fipe.FipeRepositoryImpl
import br.com.caiogandra.carcatalog.model.response.Brand
import br.com.caiogandra.carcatalog.model.response.CompleteCar
import br.com.caiogandra.carcatalog.model.response.CompleteModel
import br.com.caiogandra.carcatalog.network.FipeApi
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call

@RunWith(MockitoJUnitRunner::class)
class FipeRepositoryTest {

    private val CAR_TEST_BRAND = "Car Test Brand"
    private val CAR_TEST_YEAR = "2000"
    private val CAR_TEST_FIPECODE = "Car Test Fipe Code"

    @InjectMocks private lateinit var fipeRepository: FipeRepositoryImpl

    @Mock private lateinit var fipeApi: FipeApi

    @Mock private lateinit var callBrandsInput: Call<List<Brand>>
    @Mock private lateinit var callModelsInput: Call<List<CompleteModel>>
    @Mock private lateinit var callCompleteCarInput: Call<List<CompleteCar>>

    @Test
    fun testFetchBrandsSuccess() {
        //GIVEN
        given(fipeApi.fetchBrands()).willReturn(callBrandsInput)

        //WHEN
        val result = fipeRepository.fetchBrands()

        //THEN
        Assert.assertNotNull(result)
    }

    @Test
    fun testFetchModelsSuccess() {
        //GIVEN
        given(fipeApi.fetchModels(CAR_TEST_BRAND)).willReturn(callModelsInput)

        //WHEN
        val result = fipeRepository.fetchModels(CAR_TEST_BRAND)

        //THEN
        Assert.assertNotNull(result)
    }

    @Test
    fun testFetchCompleteCarSuccess() {
        //GIVEN
        given(fipeApi.fetchValue(CAR_TEST_FIPECODE, CAR_TEST_YEAR)).willReturn(callCompleteCarInput)

        //WHEN
        val result = fipeRepository.fetchCompleteCar(CAR_TEST_FIPECODE, CAR_TEST_YEAR)

        //THEN
        Assert.assertNotNull(result)
    }
}