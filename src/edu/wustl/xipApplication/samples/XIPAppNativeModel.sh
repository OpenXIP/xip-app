#!/bin/sh -f -x
echo $1
echo $2
echo $3
echo $4
curpath=`pwd`
#echo "curpath 1 $curpath"
cd ../XIPApp/bin
curpath=`pwd`
java edu.wustl.xipApplication.examples.XIPAppNativeModel $1 $2 $3 $4
#echo "curpath 2 $curpath"
