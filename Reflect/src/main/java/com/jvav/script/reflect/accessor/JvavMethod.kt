package com.jvav.script.reflect.accessor

import java.lang.reflect.Method

class JvavMethod(private val j: Method, val owner: JvavClass<*>) {
    init {
        j.trySetAccessible()
    }

    fun invoke(obj: Any?, params: Array<Any>): Any? {
        return j.invoke(obj, *params)
    }

    fun invoke(obj: Any?): Any? = j.invoke(obj)

    val name: String = j.name
}