package co.develhope.meteoapp.utils

import android.os.Build
import androidx.annotation.RequiresApi
import org.threeten.bp.OffsetDateTime
import java.time.format.DateTimeFormatter

object DataSource {
    private var specificData : OffsetDateTime? = null

    fun getData(date : OffsetDateTime) {
        specificData = date
    }
}
