package com.example.compose.modules.staff.model

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class ProductPreviewParameterProvider : PreviewParameterProvider<Product> {
    override val values = sequenceOf(
        Product(
            "Product name",
            "Wholesaler "
        ),
        Product(
            "Product naeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",
            "Wholesaler naaaaaaaaaaaaaaaaaaaaaaaaaame"
        )
    )
}
