#! /usr/bin/env bash
echo $1
echo $2
echo $3
echo $4
BASEDIR=$(dirname $0)
cd $BASEDIR
java edu.wustl.xipApplication.samples.XIPAppLazyRetrieveTest $1 $2 $3 $4
#java  -agentlib:jdwp=transport=dt_socket,address=localhost:8000,server=y,suspend=y edu.wustl.xipApplication.samples.XIPAppLazyRetrieveTest $1 $2 $3 $4
read -p "Press any key to continue..."

