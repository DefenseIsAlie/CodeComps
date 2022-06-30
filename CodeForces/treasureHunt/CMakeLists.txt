cmake_minimum_required(VERSION 3.0)
project(treasureHunt)
set(CMAKE_CXX_STANDARD 17)

include_directories(/inputs/ /libs/)
add_compile_options(-g)

add_library(graph libs/Graph.cpp)

add_executable(treasureHunt main.cpp)
target_link_libraries(treasureHunt graph)


install(TARGETS treasureHunt RUNTIME DESTINATION ./build/)
