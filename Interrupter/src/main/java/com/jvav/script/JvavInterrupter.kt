package com.jvav.script

import com.jvav.script.core.EngineBuilder
import com.jvav.script.core.JvavConstants
import java.io.File

class JvavInterrupter(val args: Array<String>) {
    fun launch() {
        val builder = EngineBuilder()

        val engine = builder.build()

        // Load stdlib
        for (j in File(JvavConstants.stdLibPath).listFiles()) {
            if (j.name.endsWith(".js")) engine.eval(j.reader(Charsets.UTF_8))
        }

        engine.eval(File(args[0]).reader(Charsets.UTF_8))

    }
}