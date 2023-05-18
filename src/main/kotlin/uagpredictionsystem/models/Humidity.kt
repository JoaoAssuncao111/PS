package uagpredictionsystem.models

import org.jdbi.v3.core.mapper.reflect.ColumnName
import java.time.LocalDate

data class Humidity(
    @ColumnName("date_hour")
    val dateHour: LocalDate,

    @ColumnName("location")
    val location: Int,

    @ColumnName("prediction_id")
    val predictionId: Int,

    @ColumnName("value")
    val value: Double
)
