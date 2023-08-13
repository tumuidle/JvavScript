package com.jvav.script.core

object ModuleManager {
    @JvmStatic private val modules: ArrayList<IJvavModule> = ArrayList()

    fun addModule(module: IJvavModule) = modules.add(module)

    fun getModules() = ArrayList(modules)
}