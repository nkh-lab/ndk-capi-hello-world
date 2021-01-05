cmake_minimum_required(VERSION 3.4.1)

project(vsomeip-hello-world)

list(APPEND CMAKE_MODULE_PATH ${CMAKE_SOURCE_DIR}/cmake)

add_subdirectory(external/boost-cmake)
add_subdirectory(external/vsomeip)
add_subdirectory(external/capicxx-core-runtime)
add_subdirectory(external/capicxx-someip-runtime)
add_subdirectory(external/logger)
add_subdirectory(external/genivi-capi-someip-examples)
add_subdirectory(capi-hello-world/app/src/main/cpp)
