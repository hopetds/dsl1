#!/bin/bash
rm -rf $WORKSPACE/*
BRANCH_NAME=$(echo $BRANCH_NAME | cut -c 8-)
wget https://raw.githubusercontent.com/MNT-Lab/mntlab-dsl/master/script.sh
chmod +x script.sh
./script.sh>>output.txt
tar -zcvf $BRANCH_NAME.tar.gz $WORKSPACE/script.sh