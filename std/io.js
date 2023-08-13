function read_file(filename){
    return jvav_io_File.read(filename)
}

function write_file(filename, content) {
    return jvav_io_File.write(filename, content)
}

function print(content) {
    jvav_io_Console.print(content)
}

function println(content) {
    jvav_io_Console.println(content)
}
