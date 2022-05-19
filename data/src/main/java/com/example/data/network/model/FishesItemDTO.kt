package com.example.data.network.model


import com.google.gson.annotations.SerializedName

data class FishesItemDTO(
    @SerializedName("Animal Health")
    val animalHealth: String? = null,
    @SerializedName("Availability")
    val availability: String = "",
    @SerializedName("Biology")
    val biology: String = "",
    @SerializedName("Bycatch")
    val bycatch: String? = null,
    @SerializedName("Calories")
    val calories: String = "",
    @SerializedName("Carbohydrate")
    val carbohydrate: String = "",
    @SerializedName("Cholesterol")
    val cholesterol: String? = null,
    @SerializedName("Color")
    val color: String? = null,
    @SerializedName("Disease Treatment and Prevention")
    val diseaseTreatmentAndPrevention: Any? = null,
    @SerializedName("Diseases in Salmon")
    val diseasesInSalmon: String? = null,
    @SerializedName("Displayed Seafood Profile Illustration")
    val displayedSeafoodProfileIllustration: Any? = null,
    @SerializedName("Ecosystem Services")
    val ecosystemServices: String? = null,
    @SerializedName("Environmental Considerations")
    val environmentalConsiderations: String? = null,
    @SerializedName("Environmental Effects")
    val environmentalEffects: String? = null,
    @SerializedName("Farming Methods")
    val farmingMethods: String? = null,
    @SerializedName("Farming Methods_")
    val farmingMethod: String? = null,
    @SerializedName("Fat, Total")
    val fatTotal: String = "",
    @SerializedName("Feeds_")
    val feeds: String? = null,
    @SerializedName("Feeds")
    val feed: String? = null,
    @SerializedName("Fiber, Total Dietary")
    val fiberTotalDietary: String = "",
    @SerializedName("Fishery Management")
    val fisheryManagement: String? = null,
    @SerializedName("Fishing Rate")
    val fishingRate: String? = null,
    @SerializedName("Habitat")
    val habitat: String? = null,
    @SerializedName("Habitat Impacts")
    val habitatImpacts: String? = null,
    @SerializedName("Harvest")
    val harvest: String? = null,
    @SerializedName("Harvest Type")
    val harvestType: String = "",
    @SerializedName("Health Benefits")
    val healthBenefits: String? = null,
    @SerializedName("Human_Health_")
    val humanHealth: String? = null,
    @SerializedName("Human Health")
    val humanHealths: String? = null,
    @SerializedName("last_update")
    val lastUpdate: String = "",
    @SerializedName("Location")
    val location: String? = null,
    @SerializedName("Management")
    val management: String? = null,
    @SerializedName("NOAA Fisheries Region")
    val nOAAFisheriesRegion: String = "",
    @SerializedName("Path")
    val path: String = "",
    @SerializedName("Physical Description")
    val physicalDescription: String = "",
    @SerializedName("Population")
    val population: String? = null,
    @SerializedName("Population Status")
    val populationStatus: String? = null,
    @SerializedName("Production")
    val production: String? = null,
    @SerializedName("Protein")
    val protein: String = "",
    @SerializedName("Quote")
    val quote: String = "",
    @SerializedName("Quote Background Color")
    val quoteBackgroundColor: String = "",
    @SerializedName("Research")
    val research: String? = null,
    @SerializedName("Saturated Fatty Acids, Total")
    val saturatedFattyAcidsTotal: String = "",
    @SerializedName("Scientific Name")
    val scientificName: String = "",
    @SerializedName("Selenium")
    val selenium: String? = null,
    @SerializedName("Serving Weight")
    val servingWeight: String = "",
    @SerializedName("Servings")
    val servings: String = "",
    @SerializedName("Sodium")
    val sodium: String = "",
    @SerializedName("Source")
    val source: String = "",
    @SerializedName("Species Aliases")
    val speciesAliases: String = "",
    @SerializedName("Species Illustration Photo")
    val speciesIllustrationPhoto: SpeciesIllustrationPhotoDTO = SpeciesIllustrationPhotoDTO(),
    @SerializedName("Species Name")
    val speciesName: String = "",
    @SerializedName("Sugars, Total")
    val sugarsTotal: String = "",
    @SerializedName("Taste")
    val taste: String? = null,
    @SerializedName("Texture")
    val texture: String? = null
)