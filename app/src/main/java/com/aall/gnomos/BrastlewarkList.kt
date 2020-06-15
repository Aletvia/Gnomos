import com.aall.gnomos.BrastlewarkSerialized
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
