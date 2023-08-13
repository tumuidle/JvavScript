package com.jvav.script.core

import org.openjdk.nashorn.api.scripting.NashornScriptEngine

interface IJvavModule {
    fun process(engine: NashornScriptEngine)
}