package com.jvav.script.io

import com.jvav.script.core.AbstractJvavObject
import org.openjdk.nashorn.api.scripting.NashornScriptEngine
import java.io.File

class JvavFile(engine: NashornScriptEngine) : AbstractJvavObject(engine) {
    fun read(filename: String): String {
        val file = File(filename)
        return file.readText(Charsets.UTF_8)
    }

    fun write(filename: String, content: String) {
        val file = File(filename)
        file.writeBytes(content.toByteArray(Charsets.UTF_8))
    }
}