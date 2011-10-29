#! /usr/bin/env bash
echo $1
echo $2
echo $3
echo $4
BASEDIR=$(dirname $0)
#echo $BASEDIR
cd $BASEDIR
java edu.wustl.xipApplication.samples.XIPApplication_WashU_3 $1 $2 $3 $4
read -p "Press any key to continue..."

