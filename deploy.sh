#! /bin/bash
#--socks5-hostname 10.95.1.111:1080
curl --cookie cookies.txt --cookie-jar newcookies.txt --user tomcat:1qw23er4123 --upload-file ./integration.war "http://tomcat:1qw23er4123@94.75.213.172:8080/manager/html/deploy?path=/integration&update=true"
