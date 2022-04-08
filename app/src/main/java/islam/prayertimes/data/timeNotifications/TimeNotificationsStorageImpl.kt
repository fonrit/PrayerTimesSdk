package islam.prayertimes.data.timeNotifications

import android.content.Context
import android.content.SharedPreferences
import islam.prayertimes.domain.TimeNames
import islam.prayertimes.domain.model.TimeNotificationParam
import islam.prayertimes.domain.model.TimeNotificationType
import kotlinx.serialization.SerializationException
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class TimeNotificationsStorageImpl(context: Context) : TimeNotificationsStorage {

    private val sp = context.getSharedPreferences("TimeIsNotification", Context.MODE_PRIVATE)

    private val editor: SharedPreferences.Editor = sp.edit()

    override fun get(): HashMap<TimeNames, TimeNotificationParam> {
        sp.getString(KEY, null)?.let {
            try {
                return Json.decodeFromString(it)
            } catch (e: SerializationException) {}
        }

        val none = TimeNotificationParam(TimeNotificationType.NONE)
        val alarm = TimeNotificationParam(TimeNotificationType.ALARM, "sonar")

        return hashMapOf(
            TimeNames.IMSAK to alarm,
            TimeNames.FAJR to alarm,
            TimeNames.SUNRISE to none,
            TimeNames.DHUHR to alarm,
            TimeNames.ASR to alarm,
            TimeNames.SUNSET to none,
            TimeNames.MAGHRIB to alarm,
            TimeNames.ISHA to alarm,
            TimeNames.MIDNIGHT to none,
            TimeNames.QIYAM to alarm
        )
    }

    override fun set(params: HashMap<TimeNames, TimeNotificationParam>?) {
        val json = Json { encodeDefaults = true }
        val codedPrayerParams = json.encodeToString(params)

        editor.putString(KEY, codedPrayerParams).apply()
    }
    override fun setChannel(value: String) =
        editor.putString(NOTIFICATION_TIME_CHANNEL_ID, value).apply()

    override fun getChannel(): String? = sp.getString(NOTIFICATION_TIME_CHANNEL_ID, null)

    companion object {
        private const val KEY = "TimeNotificationParams"
        private const val NOTIFICATION_TIME_CHANNEL_ID = "TimeNotificationChannel"
    }
}