package islam.prayertimes.domain.model

import androidx.annotation.Keep
import islam.prayertimes.domain.*
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class DynamicParams(
    var fajrAngle: Double = 18.0,
    var maghribAngle: Double? = null,
    var ishaAngle: Double = 17.0,
    var fajrMinuteOffset: Double? = null,
    var ishaMinuteOffset: Double? = null,
    var dhuhrFixedTime: String? = null,
    var juristicMethod: Madhhab = Madhhab.SHAFII,
    var higherLatitudeAdjustment: HigherLatitudeAdjustment = HigherLatitudeAdjustment.ANGLE_BASED,
    var offsets: MutableMap<TimeNames, Double> = getOffsets()
)

fun getOffsets(): MutableMap<TimeNames, Double> = mutableMapOf(
    TimeNames.IMSAK to 0.0,
    TimeNames.FAJR to 0.0,
    TimeNames.SUNRISE to 0.0,
    TimeNames.DHUHR to 0.0,
    TimeNames.ASR to 0.0,
    TimeNames.SUNSET to 0.0,
    TimeNames.MAGHRIB to 0.0,
    TimeNames.ISHA to 0.0,
    TimeNames.MIDNIGHT to 0.0,
    TimeNames.QIYAM to 0.0
)

@Keep
@Serializable
data class PrayerParams(
    var paramType: ParamType,
    var timeTable: Map<String, List<String>>? = null,
    var dynamicParams: MutableMap<String, DynamicParams>? = mutableMapOf("1/1-12/31" to DynamicParams()),
    var calendar: CalendarIdentifier = CalendarIdentifier.GREGORIAN
)
