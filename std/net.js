function http_request(url, method) {
    return jvav_net_Http.request(url, method, "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0")
}

function http_get(url) {
    return jvav_net_Http.get(url)
}
