#include <jni.h>
#include <string>

#include "Interface1Service.hpp"

static Interface1Service interface1Service;

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_capihelloworld_ServiceCommonApiSrv_start(JNIEnv* env, jobject /* this */)
{
    std::string hello = "Hello from ServiceCommonApiSrvJNI";

    interface1Service.start();

    return env->NewStringUTF(hello.c_str());
}
