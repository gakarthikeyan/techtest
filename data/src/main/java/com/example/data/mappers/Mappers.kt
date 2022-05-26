package com.example.data.mappers

import com.example.data.network.model.FishesItemDTO
import com.example.data.network.model.SpeciesIllustrationPhotoDTO
import com.example.domain.model.FishesItem
import com.example.domain.model.SpeciesIllustrationPhoto

fun List<FishesItemDTO>.toDomain(): List<FishesItem>{

    return map{
        FishesItem(
           animalHealth = it.animalHealth, availability = it.availability, biology = it.biology,
            bycatch = it.bycatch, calories = it.calories, carbohydrate = it.carbohydrate, cholesterol = it.cholesterol,
            color = it.color, diseaseTreatmentAndPrevention = it.diseaseTreatmentAndPrevention, diseasesInSalmon = it.diseasesInSalmon,
            displayedSeafoodProfileIllustration = it.displayedSeafoodProfileIllustration, ecosystemServices = it.ecosystemServices,
            environmentalConsiderations = it.environmentalConsiderations, environmentalEffects = it.environmentalEffects,
            farmingMethods = it.farmingMethods, farmingMethod = it.farmingMethod, fatTotal = it.fatTotal, feeds = it.feeds,
            feed = it.feed, fiberTotalDietary = it.fiberTotalDietary, fisheryManagement = it.fisheryManagement, fishingRate = it.fishingRate,
            habitat = it.habitat, habitatImpacts = it.habitatImpacts, harvest = it.harvest, harvestType = it.harvestType,
            healthBenefits = it.healthBenefits, humanHealth = it.humanHealth, humanHealths = it.humanHealths, lastUpdate = it.lastUpdate,
            location = it.location, management = it.management, nOAAFisheriesRegion = it.nOAAFisheriesRegion, path = it.path,
            physicalDescription = it.physicalDescription, population = it.population, populationStatus = it.populationStatus,
            production = it.production, protein = it.protein, quote = it.quote, quoteBackgroundColor = it.quoteBackgroundColor,
            research = it.research, saturatedFattyAcidsTotal = it.saturatedFattyAcidsTotal, scientificName = it.scientificName,
            selenium = it.selenium, servingWeight = it.servingWeight, servings = it.servings, sodium = it.sodium, source = it.source,
            speciesAliases = it.speciesAliases, speciesIllustrationPhoto = it.speciesIllustrationPhoto.toDomain(), speciesName = it.speciesName,
            sugarsTotal = it.sugarsTotal, taste = it.taste, texture = it.texture


        )


    }

}

fun SpeciesIllustrationPhotoDTO.toDomain(): SpeciesIllustrationPhoto {
    return SpeciesIllustrationPhoto(
        alt, src, title
    )
}