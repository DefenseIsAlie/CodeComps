# !/bin/bash

cmake . -B./build/ && cd build && make && clear && ./treasureHunt $1 && cd ..
