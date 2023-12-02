#!/bin/sh

DOCKER_IMAGE_NAME="aoc-jenkins:latest"

docker rmi --force=true ${DOCKER_IMAGE_NAME}
docker build --force-rm=true -t ${DOCKER_IMAGE_NAME} .
