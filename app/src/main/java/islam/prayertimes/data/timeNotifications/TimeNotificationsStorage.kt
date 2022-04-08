package islam.prayertimes.data.timeNotifications

import islam.prayertimes.domain.TimeNames
import islam.prayertimes.domain.model.TimeNotificationParam

interface TimeNotificationsStorage {

    fun get(): HashMap<TimeNames, TimeNotificationParam>

    fun set(params: HashMap<TimeNames, TimeNotificationParam>?)

    fun setChannel(value: String)

    fun getChannel(): String?
}