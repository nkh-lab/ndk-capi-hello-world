cmake_minimum_required(VERSION 3.4.1)

add_library( MainActivityJNI SHARED MainActivityJNI.cpp )

add_library(ServiceCommonApiSrvJNI SHARED ServiceCommonApiSrvJNI.cpp)
target_link_libraries(ServiceCommonApiSrvJNI Interface1-Service)

add_library(ServiceCommonApiCltJNI SHARED ServiceCommonApiCltJNI.cpp)
target_link_libraries(ServiceCommonApiCltJNI Interface1-Client)

