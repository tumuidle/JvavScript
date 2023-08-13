package com.jvav.script.core

import org.openjdk.nashorn.api.scripting.NashornScriptEngine
import org.openjdk.nashorn.api.scripting.NashornScriptEngineFactory

class EngineBuilder {
    private val engine: NashornScriptEngine = NashornScriptEngineFactory().scriptEngine as NashornScriptEngine

    init {
        for (m in ModuleManager.getModules()) {
            m.process(engine)
        }
    }

    fun build(): NashornScriptEngine = engine
}