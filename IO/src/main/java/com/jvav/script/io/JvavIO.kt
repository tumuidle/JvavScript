package com.jvav.script.io

import com.jvav.script.core.IJvavModule
import com.jvav.script.io.net.JvavHttp
import org.openjdk.nashorn.api.scripting.NashornScriptEngine

object JvavIO: IJvavModule {
    override fun process(engine: NashornScriptEngine) {
        engine.run {
            put("jvav_io_File", JvavFile(this))
            put("jvav_io_Console", JvavConsole(this))
            put("jvav_net_Http", JvavHttp(this))
        }
    }
}