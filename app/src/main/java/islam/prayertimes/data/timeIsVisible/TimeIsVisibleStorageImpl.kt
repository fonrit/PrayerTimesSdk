package islam.prayertimes.data.timeIsVisible

import android.content.Context
import android.content.SharedPreferences
import islam.prayertimes.domain.TimeNames

class TimeIsVisibleStorageImpl(context: Context): TimeIsVisibleStorage {
    private val sp: SharedPreferences = context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sp.edit()

    override fun get(): LinkedHashMap<TimeNames, Boolean> {
        val result = LinkedHashMap<TimeNames, Boolean>()
        result[TimeNames.IMSAK] = sp.getBoolean(TimeNames.IMSAK.value, false)
        result[TimeNames.FAJR] = sp.getBoolean(TimeNames.FAJR.value, true)
        result[TimeNames.SUNRISE] = sp.getBoolean(TimeNames.SUNRISE.value, true)
        result[TimeNames.DHUHR] = sp.getBoolean(TimeNames.DHUHR.value, true)
        result[TimeNames.ASR] = sp.getBoolean(TimeNames.ASR.value, true)
        result[TimeNames.SUNSET] = sp.getBoolean(TimeNames.SUNSET.value, false)
        result[TimeNames.MAGHRIB] = sp.getBoolean(TimeNames.MAGHRIB.value, true)
        result[TimeNames.ISHA] = sp.getBoolean(TimeNames.ISHA.value, true)
        result[TimeNames.MIDNIGHT] = sp.getBoolean(TimeNames.MIDNIGHT.value, false)
        result[TimeNames.QIYAM] = sp.getBoolean(TimeNames.QIYAM.value, false)
        return result
    }

    override fun set(timeIsVisible: LinkedHashMap<TimeNames, Boolean>) {
        editor.putBoolean(TimeNames.IMSAK.value, timeIsVisible[TimeNames.IMSAK]!!)
        editor.putBoolean(TimeNames.FAJR.value, timeIsVisible[TimeNames.FAJR]!!)
        editor.putBoolean(TimeNames.SUNRISE.value, timeIsVisible[TimeNames.SUNRISE]!!)
        editor.putBoolean(TimeNames.DHUHR.value, timeIsVisible[TimeNames.DHUHR]!!)
        editor.putBoolean(TimeNames.ASR.value, timeIsVisible[TimeNames.ASR]!!)
        editor.putBoolean(TimeNames.SUNSET.value, timeIsVisible[TimeNames.SUNSET]!!)
        editor.putBoolean(TimeNames.MAGHRIB.value, timeIsVisible[TimeNames.MAGHRIB]!!)
        editor.putBoolean(TimeNames.ISHA.value, timeIsVisible[TimeNames.ISHA]!!)
        editor.putBoolean(TimeNames.MIDNIGHT.value, timeIsVisible[TimeNames.MIDNIGHT]!!)
        editor.putBoolean(TimeNames.QIYAM.value, timeIsVisible[TimeNames.QIYAM]!!)
        editor.apply()
    }

    companion object {
        private const val STORAGE_NAME = "TimeIsVisible"
    }
}