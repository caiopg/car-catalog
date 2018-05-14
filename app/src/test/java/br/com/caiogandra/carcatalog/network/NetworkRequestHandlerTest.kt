package br.com.caiogandra.carcatalog.network

import br.com.caiogandra.carcatalog.model.response.Brand
import br.com.caiogandra.carcatalog.network.request.NetworkRequestHandler
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call

@RunWith(MockitoJUnitRunner::class)
class NetworkRequestHandlerTest {

    @Mock private lateinit var callInput: Call<Brand>

    @Test
    fun testCreateRequestSuccess() {

        //WHEN
        val result = NetworkRequestHandler.doRequest(callInput)

        //THEN
        assertNotNull(result)
    }
}