package co.demo.core.data.source

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject

class FileReader @Inject constructor(@ApplicationContext private val context: Context) {
    fun getFileContent(fileName: String): String {
        val resourceId = getResourceId(fileName)
        val inputStream = context.resources.openRawResource(resourceId)
        return String(toByteArray(inputStream))
    }

    @Throws(IOException::class)
    private fun getResourceId(filename: String): Int {
        return context.resources.getIdentifier(filename, "raw", context.packageName)
    }

    companion object {
        private const val BUFFER_SIZE = 1024 * 4

        @Throws(IOException::class)
        private fun toByteArray(`is`: InputStream): ByteArray {
            val output = ByteArrayOutputStream()
            return output.use { out ->
                val b = ByteArray(BUFFER_SIZE)
                var n = 0
                while (`is`.read(b).also { n = it } != -1) {
                    out.write(b, 0, n)
                }
                out.toByteArray()
            }
        }
    }
}