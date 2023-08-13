package com.jvav.script.reflect.jar

import com.jvav.script.reflect.accessor.JvavClass
import java.io.File
import java.lang.IllegalStateException
import java.net.URLClassLoader
import java.util.jar.JarFile

class JarLoader(val file: File) {
    private val jar = JarFile(file)
    private val classes = ArrayList<Class<*>>()

    init {

    }

    fun loads() = loads(false)

    fun loads(ignoreException: Boolean) {
        if (classes.isNotEmpty()) throw IllegalStateException("Jar already loaded")

        val ucl = URLClassLoader(arrayOf(file.toURI().toURL()))
        val ents = jar.entries()

        while (ents.hasMoreElements()) {
            val ent = ents.nextElement()
            if (ent.name.endsWith(".class") && !ent.name.endsWith("module-info.class")) {
                classes.add(ucl.loadClass(ent.name.split(".class")[0].replace("/", ".")))
            }
        }
    }

    fun findClass(name: String): JvavClass<*>? {
        if (classes.isEmpty()) throw IllegalStateException("Jar not loaded")
        for (c in classes) {
            if (c.name.equals(name, true)) return JvavClass(c)
        }
        return null
    }
}