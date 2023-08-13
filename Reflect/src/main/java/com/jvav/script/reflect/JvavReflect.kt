package com.jvav.script.reflect

import com.jvav.script.core.IJvavModule
import org.openjdk.nashorn.api.scripting.NashornScriptEngine

object JvavReflect: IJvavModule {
    override fun process(engine: NashornScriptEngine) {
        engine.run {
            put("jvav_reflect_Accessor", JvavAccessor(engine))
        }
    }
}