package com.jvav.script.reflect

import com.jvav.script.core.AbstractJvavObject
import com.jvav.script.reflect.accessor.JvavClass
import com.jvav.script.reflect.jar.JarLoader
import org.openjdk.nashorn.api.scripting.NashornScriptEngine
import java.io.File

class JvavAccessor(engine: NashornScriptEngine) : AbstractJvavObject(engine) {
    fun eval(script: String) {
        engine.eval(script)
    }

    fun evalFile(filename: String) {
        engine.eval(File(filename).reader(Charsets.UTF_8))
    }

    fun findClass(classname: String): JvavClass<*>? {
        return try {
            JvavClass(Class.forName(classname))
        } catch (e: ClassNotFoundException) {
            null
        }
    }

    fun loadJar(path: String): JarLoader {
        val loader = JarLoader(File(path))
        loader.loads()
        return loader
    }
}