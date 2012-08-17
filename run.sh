#!/bin/bash

trap ctrl_c KILL HUP INT TERM
ctrl_c() {
	echo -e "\n\033[31m******\033[0m Trapped CTRL-C"
	echo "kill proc# ($LASTPID)"
	kill -9 $LASTPID
	exit 3
}


LASTPID=0
started=0
SYSNAME=`uname`
cmd_name="md5sum"

case $SYSNAME in
	"Darwin"|"FreeBSD")
		cmd_name="md5 -r"
	;;

	*) 
		echo "LINUX";
	;;
esac

run(){
	echo "running"
	cd bin
	jcubepath="`jcube get-lib-path`"
	filelist=""
	for file in  `find $jcubepath | grep -i .jar` ; do filelist="$filelist:$file" ; done
	java -classpath $filelist RunDevelop &2>1 &
	LASTPID=$(($!-1))
	echo "proccess $LASTPID"
}

daemon() {
    chsum1=""
    run
    while [[ true ]]
    do
	if [[ $LASTPID > 0 ]] ; then
        chsum2=`find ../src/ -type f -exec $cmd_name {} \;`
        if [[ $chsum1 != $chsum2 ]] ; then
            # compile
            echo "restart"

            chsum1=`find ../src/ -type f -exec $cmd_name {} \;`
	    if [[ $started > 0 ]]; then
	    kill -9 $LASTPID
            run
	    fi
	    started=1
        fi
        sleep 1
	fi
    done
}

daemon $*
