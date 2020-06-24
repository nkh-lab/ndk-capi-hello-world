#include <jni.h>
#include <string>

#include "Interface1Client.hpp"

static Interface1Client interface1Client;

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_capihelloworld_ServiceCommonApiClt_start(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from ServiceCommonApiCltJNI";

    interface1Client.start();

    return env->NewStringUTF(hello.c_str());
}
