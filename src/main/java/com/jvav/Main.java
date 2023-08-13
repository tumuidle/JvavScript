package com.jvav;

import com.jvav.script.JvavInterrupter;
import com.jvav.script.core.JvavConstants;
import com.jvav.script.core.ModuleManager;
import com.jvav.script.io.JvavIO;
import com.jvav.script.reflect.JvavReflect;

public class Main {
    public static void main(String[] args) {
        ModuleManager.INSTANCE.addModule(JvavIO.INSTANCE);
        ModuleManager.INSTANCE.addModule(JvavReflect.INSTANCE);

        JvavConstants.stdLibPath = System.getProperty("jvav.stdlib", "std");

        new JvavInterrupter(args).launch();
    }
}