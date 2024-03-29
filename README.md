# ndk-capi-hello-world
Android Studio example how to use GENIVI CommonAPI via SOME/IP between two app services from native code.

## Environment
- Android Studio
- CMake 3.12 (for boost-cmake)

## Dependencies
Git submodule projects:
- vsomeip 3.1.20.2 (https://github.com/GENIVI/vsomeip.git);
- capicxx-core-runtime 3.2.0 + `patches/capicxx-core-runtime.patch`: (https://github.com/GENIVI/capicxx-core-runtime.git);
- capicxx-someip-runtime 3.2.0 + `patches/capicxx-someip-runtime.patch`: (https://github.com/GENIVI/capicxx-someip-runtime.git);
- boost-cmake: CMake adapted boost (https://github.com/Orphis/boost-cmake);
- logger 1.0.0: For easy logging (https://github.com/nkh-lab/logger.git);
- genivi-capi-someip-examples 3.0.0: Simple CommonAPI via SOME/IP example which supports Android (https://github.com/nkh-lab/genivi-capi-someip-examples.git).

## Project setup
1. Clone main git project:
```
git clone https://github.com/nkh-lab/ndk-capi-hello-world.git
```
2. Clone submodule projects:
```
git submodule update --init
```
3. Apply patches:
```
cd external/capicxx-core-runtime
git apply ../../patches/capicxx-core-runtime.patch
```
```
cd external/capicxx-someip-runtime
git apply ../../patches/capicxx-someip-runtime.patch
```
or via
```
./patches/apply-patches.sh 
```

## Open project in Android Studio
1. Run Android Studio
2. Then open ndk-capi-hello-world/capi-hello-world project
3. Build and run
4. Expected app output in `logcat`:
```
...
2020-06-24 23:16:08.708 15582-15638/com.example.capihelloworld I/Interface1Service: Interface1Service.cpp:16 main() Hello from Interface1Service
2020-06-24 23:16:08.711 15582-15640/com.example.capihelloworld I/Interface1Client: Interface1Client.cpp:27 main() Client1: Hello from Interface1Client
2020-06-24 23:16:08.711 15582-15638/com.example.capihelloworld I/Interface1Service: Interface1Service.cpp:33 main() Successfully Registered Service!
2020-06-24 23:16:08.712 15582-15638/com.example.capihelloworld I/Interface1Service: Interface1Service.cpp:37 main() Waiting for calls... (Abort with CTRL+C)
2020-06-24 23:16:08.712 15582-15640/com.example.capihelloworld I/Interface1Client: Interface1Client.cpp:41 main() Client1: Checking availability!
2020-06-24 23:16:08.720 15582-15640/com.example.capihelloworld I/Interface1Client: Interface1Client.cpp:46 main() Client1: Available...
2020-06-24 23:16:08.721 15582-15643/com.example.capihelloworld I/Interface1Client: Interface1Client.cpp:59 operator()() Client1: aString CallStatus: 0
2020-06-24 23:16:08.721 15582-15640/com.example.capihelloworld I/Interface1Client: Interface1Client.cpp:68 main() Client1: getAStringAttribute().setValue() was set to: 0
2020-06-24 23:16:08.721 15582-15640/com.example.capihelloworld I/Interface1Client: Interface1Client.cpp:71 main() Client1: setUInt32(): 0
2020-06-24 23:16:08.721 15582-15643/com.example.capihelloworld I/Interface1Client: Interface1Client.cpp:56 operator()() Client1: aString was changed to: 0
2020-06-24 23:16:11.725 15582-15640/com.example.capihelloworld I/Interface1Client: Interface1Client.cpp:81 main() Client1: getUInt32(): 0
2020-06-24 23:16:14.727 15582-15640/com.example.capihelloworld I/Interface1Client: Interface1Client.cpp:68 main() Client1: getAStringAttribute().setValue() was set to: 1
2020-06-24 23:16:14.728 15582-15643/com.example.capihelloworld I/Interface1Client: Interface1Client.cpp:56 operator()() Client1: aString was changed to: 1
2020-06-24 23:16:14.728 15582-15640/com.example.capihelloworld I/Interface1Client: Interface1Client.cpp:71 main() Client1: setUInt32(): 1
2020-06-24 23:16:17.733 15582-15640/com.example.capihelloworld I/Interface1Client: Interface1Client.cpp:81 main() Client1: getUInt32(): 1
2020-06-24 23:16:20.735 15582-15640/com.example.capihelloworld I/Interface1Client: Interface1Client.cpp:68 main() Client1: getAStringAttribute().setValue() was set to: 2
2020-06-24 23:16:20.735 15582-15643/com.example.capihelloworld I/Interface1Client: Interface1Client.cpp:56 operator()() Client1: aString was changed to: 2
2020-06-24 23:16:20.735 15582-15640/com.example.capihelloworld I/Interface1Client: Interface1Client.cpp:71 main() Client1: setUInt32(): 2
2020-06-24 23:16:23.740 15582-15640/com.example.capihelloworld I/Interface1Client: Interface1Client.cpp:81 main() Client1: getUInt32(): 2
...
```

