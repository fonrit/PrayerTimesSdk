package islam.prayertimes.domain

import android.content.res.Resources
import androidx.annotation.Keep
import islam.prayertimes.R
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
enum class TimeNames(val value: String) {

    @SerialName("Imsak")
    IMSAK("Imsak"),

    @SerialName("Fajr")
    FAJR("Fajr"),

    @SerialName("Sunrise")
    SUNRISE("Sunrise"),

    @SerialName("Dhuhr")
    DHUHR("Dhuhr"),

    @SerialName("Asr")
    ASR("Asr"),

    @SerialName("Sunset")
    SUNSET("Sunset"),

    @SerialName("Maghrib")
    MAGHRIB("Maghrib"),

    @SerialName("Isha")
    ISHA("Isha"),

    @SerialName("Midnight")
    MIDNIGHT("Midnight"),

    @SerialName("Qiyam")
    QIYAM("Qiyam");

    companion object {
        @JvmStatic
        fun TimeNames.localizedString(resources: Resources): String {
            return when (this) {
                IMSAK -> resources.getString(R.string.imsak)
                FAJR -> resources.getString(R.string.fajr)
                SUNRISE -> resources.getString(R.string.sunrise)
                DHUHR -> resources.getString(R.string.dhuhr)
                ASR -> resources.getString(R.string.asr)
                SUNSET -> resources.getString(R.string.sunset)
                MAGHRIB -> resources.getString(R.string.maghrib)
                ISHA -> resources.getString(R.string.isha)
                MIDNIGHT -> resources.getString(R.string.midnight)
                QIYAM -> resources.getString(R.string.qiyam)
            }
        }

        @JvmStatic
        fun TimeNames.localizedNotificationString(resources: Resources): String {
            return when (this) {
                IMSAK -> resources.getString(R.string.imsakNotifyTitle)
                FAJR -> resources.getString(R.string.fajrNotifyTitle)
                SUNRISE -> resources.getString(R.string.sunriseNotifyTitle)
                DHUHR -> resources.getString(R.string.dhuhrNotifyTitle)
                ASR -> resources.getString(R.string.asrNotifyTitle)
                SUNSET -> resources.getString(R.string.sunsetNotifyTitle)
                MAGHRIB -> resources.getString(R.string.maghribNotifyTitle)
                ISHA -> resources.getString(R.string.ishaNotifyTitle)
                MIDNIGHT -> resources.getString(R.string.midnightNotifyTitle)
                QIYAM -> resources.getString(R.string.qiyamNotifyTitle)
            }
        }

        @JvmStatic
        fun getEnum(value: String): TimeNames? {
            return when (value) {
                IMSAK.value -> IMSAK
                FAJR.value -> FAJR
                SUNRISE.value -> SUNRISE
                DHUHR.value -> DHUHR
                ASR.value -> ASR
                SUNSET.value -> SUNSET
                MAGHRIB.value -> MAGHRIB
                ISHA.value -> ISHA
                MIDNIGHT.value -> MIDNIGHT
                QIYAM.value -> QIYAM
                else -> null
            }
        }
    }

}

@Keep
@Serializable
enum class Madhhab(val value: String) {

    @SerialName("Shafii")
    SHAFII("Shafii"),

    @SerialName("Hanafi")
    HANAFI("Hanafi"),

    @SerialName("Maliki")
    MALIKI("Maliki"),

    @SerialName("Hanbali")
    HANBALI("Hanbali"),

    @SerialName("Jafari")
    JAFARI("Jafari");

    companion object {
        @JvmStatic
        fun getJuristicMethod(juristicMethod: String?): Madhhab? {
            return when (juristicMethod) {
                "Shafii" -> SHAFII
                "Hanafi" -> HANAFI
                "Maliki" -> MALIKI
                "Hanbali" -> HANBALI
                "Jafari" -> JAFARI
                else -> null
            }
        }
    }

}

@Keep
@Serializable
enum class HigherLatitudeAdjustment(val value: String) {

    @SerialName("None")
    NONE("None"),

    @SerialName("MidNight")
    MID_NIGHT("MidNight"),

    @SerialName("OneSeventh")
    ONE_SEVENTH("OneSeventh"),

    @SerialName("AngleBased")
    ANGLE_BASED("AngleBased");

    companion object {
        @JvmStatic
        fun get(higherLatitudeAdjustment: String?): HigherLatitudeAdjustment? {
            return when (higherLatitudeAdjustment) {
                "None" -> NONE
                "Middle of night" -> MID_NIGHT
                "One seventh" -> ONE_SEVENTH
                "Angle based" -> ANGLE_BASED
                else -> null
            }
        }
    }

}

@Keep
@Serializable
enum class ParamType(val value: String) {

    @SerialName("Dynamic")
    DYNAMIC("Dynamic"),

    @SerialName("TimeTable")
    TIMETABLE("TimeTable");

    companion object {
        @JvmStatic
        fun getParamType(paramType: String?): ParamType? {
            return when (paramType) {
                "Dynamic" -> DYNAMIC
                "TimeTable" -> TIMETABLE
                else -> null
            }
        }
    }

}

@Keep
@Serializable
enum class CalendarIdentifier(val value: String) {

    @SerialName("Gregorian")
    GREGORIAN("Gregorian"),

    @SerialName("IslamicUmmAlQura")
    ISLAMIC_UMM_AL_QURA("IslamicUmmAlQura");

    companion object {
        @JvmStatic
        fun getCalendar(calendar: String?): CalendarIdentifier? {
            return when (calendar) {
                "Gregorian" -> GREGORIAN
                "IslamicUmmAlQura" -> ISLAMIC_UMM_AL_QURA
                else -> null
            }
        }
    }

}