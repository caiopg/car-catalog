package br.com.caiogandra.carcatalog.datasource

import br.com.caiogandra.carcatalog.model.response.Brand
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call

@RunWith(MockitoJUnitRunner::class)
class FipeRepositoryTest {

    @Mock private lateinit var brands: List<Brand>
    @Mock private lateinit var callInput: Call<Brand>

    @Test
    fun testFetchBrandsSuccess() {
        
    }
}