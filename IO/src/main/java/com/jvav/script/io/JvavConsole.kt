package com.jvav.script.io

import com.jvav.script.core.AbstractJvavObject
import org.openjdk.nashorn.api.scripting.NashornScriptEngine

class JvavConsole(engine: NashornScriptEngine) : AbstractJvavObject(engine) {
    fun print(content: String) {
        kotlin.io.print(content)
    }

    fun println(content: String) {
        kotlin.io.println(content)
    }
}