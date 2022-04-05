package models.token

data class TokenResponse(
    val accessToken: String,
    val expiresIn: Long
)
