package com.jvav.script.reflect.accessor

import netscape.javascript.JSObject

class JvavClass<T>(private val j: Class<T>) {
    fun getRaw() = j

    fun findMethod(name: String, argTypes: Array<String>): JvavMethod? {
        return try{
            val argClasses = ArrayList<Class<*>>()
            for (a in argTypes) argClasses.add(Class.forName(a))

            JvavMethod(j.getDeclaredMethod(name, *argClasses.toTypedArray()), this)
        } catch (e: NoSuchMethodError) {
            e.printStackTrace()
            null
        }
    }

    fun newInstance(param: Array<Any>): T? {
        val paramTypes = ArrayList<Class<*>>()
        for (p in param) paramTypes.add(p.javaClass)
        val constructor = j.getDeclaredConstructor(*paramTypes.toTypedArray())
        return constructor.newInstance(*param)
    }

    fun findField(name: String): JvavField? {
        return try {
            JvavField(j.getDeclaredField(name), this)
        } catch (e: NoSuchFieldError) {
            null
        }
    }

    val name: String = j.name
    val packageName: String = j.packageName
    val simpleName: String = j.simpleName
    val rawName: String = j.name.replace(".", "/")
}