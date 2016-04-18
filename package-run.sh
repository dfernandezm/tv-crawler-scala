#!/bin/bash

sbt assembly
scala target/scala-2.11/tvCrawler-assembly-1.0.jar --conf config.json