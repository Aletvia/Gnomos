import com.google.gson.annotations.SerializedName

data class BrastlewarkList (

	val brastlewark : List<Brastlewark>
)


data class Brastlewark (

	val id : Int,
	val name : String,
	val thumbnail : String,
	val age : Int,
	val weight : Double,
	val height : Double,
	val hair_color : String,
	val professions : List<String>,
	val friends : List<String>
)


data class SerializedBrastlewarkList (

	@SerializedName("Brastlewark") val brastlewark : List<BrastlewarkSerialized>
)


data class BrastlewarkSerialized (

	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("thumbnail") val thumbnail : String,
	@SerializedName("age") val age : Int,
	@SerializedName("weight") val weight : Double,
	@SerializedName("height") val height : Double,
	@SerializedName("hair_color") val hair_color : String,
	@SerializedName("professions") val professions : List<String>,
	@SerializedName("friends") val friends : List<String>
)