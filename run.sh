#!/bin/sh

docker run \
  -p 8081:8080 \
  -v ${PWD}/jcasc.yaml:/var/jenkins_home/casc_configs/jcasc.yaml \
  -v ${PWD}:/tmp/jcasc \
  aoc-jenkins:latest
