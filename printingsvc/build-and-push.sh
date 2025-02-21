#!/bin/bash

IMAGE_NAME="sunseaskyff/printing-poc" #define public docker registry, later it will be changed to mapfre docker registry
IMAGE_VERSION="latest"  # Change to specific version if needed (e.g., "v1.0.0")

# Ensure Docker is running
if ! docker info > /dev/null 2>&1; then
    echo "Docker is not running. Please start Docker and try again."
    exit 1
fi

# Build the Docker image
echo "Building Docker image..."
docker build -t $IMAGE_NAME:$IMAGE_VERSION .

# Authenticate with Docker Hub (prompts for username/password)
echo "Logging into Docker Hub..."
docker login

# Push the image to Docker Hub
echo "Pushing image to Docker Hub..."
docker push $IMAGE_NAME:$IMAGE_VERSION

# Verify the pushed image
echo "Image pushed successfully: $IMAGE_NAME:$IMAGE_VERSION"