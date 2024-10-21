package edu.iesam.dam2024.features.superhero.data.remote

import com.google.gson.annotations.SerializedName
import edu.iesam.dam2024.features.superhero.domain.Appearance
import edu.iesam.dam2024.features.superhero.domain.Biography
import edu.iesam.dam2024.features.superhero.domain.Connections
import edu.iesam.dam2024.features.superhero.domain.Images
import edu.iesam.dam2024.features.superhero.domain.PowerStats
import edu.iesam.dam2024.features.superhero.domain.Work

data class SuperHeroApiModel(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("powerstats") val powerStats: PowerStats,
    @SerializedName("appearance") val appearance: Appearance,
    @SerializedName("biography") val biography: Biography,
    @SerializedName("work") val work: Work,
    @SerializedName("connections") val connections: Connections,
    @SerializedName("images") val images: Images
)