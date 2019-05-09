package Persistence;

import com.google.gson.annotations.SerializedName;

public enum EtatTache {
	@SerializedName("0")
	 done,
	 @SerializedName("1")
	 undone,
	 @SerializedName("2")
	 inprogress 
   
}
