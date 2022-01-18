#!/bin/bash

cd external/capicxx-core-runtime
git apply ../../patches/capicxx-core-runtime.patch

cd ../..

cd external/capicxx-someip-runtime
git apply ../../patches/capicxx-someip-runtime.patch