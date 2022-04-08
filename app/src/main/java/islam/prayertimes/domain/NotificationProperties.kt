package islam.prayertimes.domain.model

import android.content.Context
import android.net.Uri
import androidx.annotation.Keep
import androidx.core.net.toUri
import kotlinx.serialization.Serializable
import java.io.File

enum class TimeNotificationType {
    NONE,
    SILENT,
    DEFAULT,
    ALARM,
    ADHAN
}

@Keep
@Serializable
data class TimeNotificationParam(
    var type: TimeNotificationType,
    var audio: String? = null
) {
    fun getUri(packageName: String, fajr: Boolean = false): Uri {
        val audioName: String = if (fajr) audio.plus("_fajr") else audio.orEmpty()
        return Uri.parse("android.resource://$packageName/raw/$audioName")
    }


    /**
     * Получение Uri файла в папке assets
     * */
    fun getFileFromAssets(context: Context, fajr: Boolean = false): Uri {
        val fileName: String = if (fajr) audio.plus("_fajr.mp3") else audio.plus(".mp3")

        return File(context.cacheDir, fileName)
            .also {
                if (!it.exists()) {
                    it.outputStream().use { cache ->
                        context.assets.open(fileName).use { inputStream ->
                            inputStream.copyTo(cache)
                        }
                    }
                }
            }.toUri()
    }
}