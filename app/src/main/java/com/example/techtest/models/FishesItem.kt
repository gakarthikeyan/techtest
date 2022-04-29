package com.example.techtest.models


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class FishesItem(
    @SerializedName("Animal Health")
    @Expose
    val animalHealth: String?,
    @SerializedName("Availability")
    @Expose
    val availability: String?,
    @SerializedName("Biology")
    @Expose
    val biology: String?,
    @SerializedName("Bycatch")
    @Expose
    val bycatch: String?,
    @SerializedName("Calories")
    @Expose
    val calories: String?,
    @SerializedName("Carbohydrate")
    @Expose
    val carbohydrate: String?,
    @SerializedName("Cholesterol")
    @Expose
    val cholesterol: String?,
    @SerializedName("Color")
    @Expose
    val color: String?,
    @SerializedName("Disease Treatment and Prevention")
    @Expose
    val diseaseTreatmentAndPrevention: Any?,
    @SerializedName("Diseases in Salmon")
    @Expose
    val diseasesInSalmon: String?,
    @SerializedName("Displayed Seafood Profile Illustration")
    @Expose
    val displayedSeafoodProfileIllustration: Any?,
    @SerializedName("Ecosystem Services")
    @Expose
    val ecosystemServices: String?,
    @SerializedName("Environmental Considerations")
    @Expose
    val environmentalConsiderations: String?,
    @SerializedName("Environmental Effects")
    @Expose
    val environmentalEffects: String?,
    @SerializedName("Farming Methods")
    @Expose
    val farmingMethods: String?,
    @SerializedName("Farming Methods_")
    @Expose
    val farmingMethod: String?,
    @SerializedName("Fat, Total")
    @Expose
    val fatTotal: String?,
    @SerializedName("Feeds_")
    @Expose
    val feeds: String?,
    @SerializedName("Feeds")
    @Expose
    val feed: String?,
    @SerializedName("Fiber, Total Dietary")
    @Expose
    val fiberTotalDietary: String?,
    @SerializedName("Fishery Management")
    @Expose
    val fisheryManagement: String?,
    @SerializedName("Fishing Rate")
    @Expose
    val fishingRate: String?,
    @SerializedName("Habitat")
    @Expose
    val habitat: String?,
    @SerializedName("Habitat Impacts")
    @Expose
    val habitatImpacts: String?,
    @SerializedName("Harvest")
    @Expose
    val harvest: String?,
    @SerializedName("Harvest Type")
    @Expose
    val harvestType: String?,
    @SerializedName("Health Benefits")
    @Expose
    val healthBenefits: String?,
    @SerializedName("Human_Health_")
    @Expose
    val humanHealth: String?,
    @SerializedName("Human Health")
    @Expose
    val humanHealthImage: String?,
    @SerializedName("Image Gallery")
    @Expose
    val imageGallery: List<ImageGallery>?,
    @SerializedName("last_update")
    @Expose
    val lastUpdate: String?,
    @SerializedName("Location")
    @Expose
    val location: String?,
    @SerializedName("Management")
    @Expose
    val management: String?,
    @SerializedName("NOAA Fisheries Region")
    @Expose
    val nOAAFisheriesRegion: String?,
    @SerializedName("Path")
    @Expose
    val path: String?,
    @SerializedName("Physical Description")
    @Expose
    val physicalDescription: String?,
    @SerializedName("Population")
    @Expose
    val population: String?,
    @SerializedName("Population Status")
    @Expose
    val populationStatus: String?,
    @SerializedName("Production")
    @Expose
    val production: String?,
    @SerializedName("Protein")
    @Expose
    val protein: String?,
    @SerializedName("Quote")
    @Expose
    val quote: String?,
    @SerializedName("Quote Background Color")
    @Expose
    val quoteBackgroundColor: String?,
    @SerializedName("Research")
    @Expose
    val research: String?,
    @SerializedName("Saturated Fatty Acids, Total")
    @Expose
    val saturatedFattyAcidsTotal: String?,
    @SerializedName("Scientific Name")
    @Expose
    val scientificName: String?,
    @SerializedName("Selenium")
    @Expose
    val selenium: String?,
    @SerializedName("Serving Weight")
    @Expose
    val servingWeight: String?,
    @SerializedName("Servings")
    @Expose
    val servings: String?,
    @SerializedName("Sodium")
    @Expose
    val sodium: String?,
    @SerializedName("Source")
    @Expose
    val source: String?,
    @SerializedName("Species Aliases")
    @Expose
    val speciesAliases: String?,
    @SerializedName("Species Illustration Photo")
    @Expose
    val speciesIllustrationPhoto: SpeciesIllustrationPhoto?,
    @SerializedName("Species Name")
    @Expose
    val speciesName: String?,
    @SerializedName("Sugars, Total")
    @Expose
    val sugarsTotal: String?,
    @SerializedName("Taste")
    @Expose
    val taste: String?,
    @SerializedName("Texture")
    @Expose
    val texture: String?
)