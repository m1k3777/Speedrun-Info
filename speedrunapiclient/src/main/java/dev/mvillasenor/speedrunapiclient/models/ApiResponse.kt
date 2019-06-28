package dev.mvillasenor.speedrunapiclient.models

data class ApiResponse<out T>(
    val data: List<T>,
    val pagination: Pagination
)

data class Pagination(
    val offset: Int,
    val max: Int,
    val size: Int,
    val links: List<Link>
)

data class Link(
    val rel: String,
    val uri: String
)
