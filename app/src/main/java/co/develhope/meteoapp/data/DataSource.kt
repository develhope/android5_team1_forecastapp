package co.develhope.meteoapp.data

import org.threeten.bp.OffsetDateTime

object DataSource {
    private var specificData : OffsetDateTime? = null

    fun getData(date : OffsetDateTime) {
        specificData = date
    }
}
