package br.com.caiogandra.carcatalog.network.serializer

import br.com.caiogandra.carcatalog.model.response.Brands
import com.google.gson.*
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class BrandsDeserializer : JsonDeserializer<Brands> {
    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Brands {

        val gson = Gson()
        val jsonArray = json.asJsonArray
        val listType = object : TypeToken<Brands>(){}.type

        return gson.fromJson(jsonArray.toString(), listType)
    }
}