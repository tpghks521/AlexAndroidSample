package com.example.androidmvvmsample.data

data class KakaoImage(
    var collection: String? = null,
    var display_sitename: String? = null,
    var doc_url: String? = null,
    var height: Int = 0,
    var image_url: String? = null,
    var thumbnail_url: String? = null,
    var width: Int = 0
)


data class Meta(
    var is_end: Boolean = false,
    var pageable_coun: Int = 0,
    var total_count: Int = 0,
)

data class KakaoImageList(
    var documents: List<KakaoImage>? = null,
    var meta: Meta? = null
)