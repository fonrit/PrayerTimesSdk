package islam.prayertimes.data.timeIsVisible

import islam.prayertimes.domain.TimeNames

interface TimeIsVisibleStorage {

    fun get(): LinkedHashMap<TimeNames, Boolean>

    fun set(timeIsVisible: LinkedHashMap<TimeNames, Boolean>)
}