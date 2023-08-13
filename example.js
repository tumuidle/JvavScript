println("Hello JVAV")
println(http_get("https://myip.ipip.net"))

var system = reflect_class("java.lang.System")
var outField = system.findField("out")
var outInst = outField.get(null)
var outPrintln = outField.type.findMethod("println", ["java.lang.String"])
outPrintln.invoke(outInst, ["Jvav reflect"])
