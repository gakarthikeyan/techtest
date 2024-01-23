package com.example.common.extension

import com.example.common.model.DataModel
import com.example.common.model.DomainModel

interface DataToDomainMapper<DA: DataModel, DO: DomainModel> {
    fun mapDataModelToDomainModel(dataModel: DA): DO
}