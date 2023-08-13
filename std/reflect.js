function reflect_class(classname) {
    return jvav_reflect_Accessor.findClass(classname)
}

function reflect_eval(script) {
    jvav_reflect_Accessor.eval(script)
}

function reflect_eval_file(filename) {
    jvav_reflect_Accessor.evalFile(filename)
}

function load_jar(path) {
    return jvav_reflect_Accessor.loadJar(path)
}
