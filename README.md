# Advent of Code 2023

This year I've decided to try solve [Advent of Code](https://adventofcode.com/) using Jenkins jobs.

## Setup

- Build
    ```shell
    pushd docker
    ./build.sh
    popd
    ```
- Run
    ```shell
    docker run -p 8081:8080 aoc-jenkins:latest
    ```
- Open [localhost:8081](http://localhost:8081/) and log in as user `aoc` with the password `aoc`
