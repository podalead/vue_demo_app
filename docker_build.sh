#!/usr/bin/env bash

docker buildx build -t heryv1m/testerization:latest \
                    -t heryv1m/testerization:v1.0.8 \
                    --platform linux/amd64 \
                    --push \
                    .
