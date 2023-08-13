package com.jvav.script.reflect.accessor

import java.lang.reflect.Field

class JvavField(private val j: Field, val owner: JvavClass<*>) {
    init {
        j.trySetAccessible()
    }

    fun get(obj: Any?): Any? = j.get(obj)

    val name: String = j.name
    val type = JvavClass(j.type)
}