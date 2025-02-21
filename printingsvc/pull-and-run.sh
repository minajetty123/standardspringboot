#!/bin/bash

IMAGE_NAME="sunseaskyff/printing-poc" #define public docker registry, later it will be changed to mapfre docker registry
IMAGE_VERSION="latest"  # Change to specific version if needed (e.g., "v1.0.0")
CONTAINER_NAME="printing-poc-container"

# Ensure Docker is running
if ! docker info > /dev/null 2>&1; then
    echo "Docker is not running. Please start Docker and try again."
    exit 1
fi

# Pull the latest image from Docker Hub
echo "Pulling Docker image from Docker Hub..."
docker pull $IMAGE_NAME:$IMAGE_VERSION

# Stop and remove any existing container with the same name
if [ "$(docker ps -aq -f name=$CONTAINER_NAME)" ]; then
    echo "Stopping and removing existing container..."
    docker stop $CONTAINER_NAME
    docker rm $CONTAINER_NAME
fi

# Run the container
echo "Running the Docker container..."
docker run -d -p 8080:8080 --name $CONTAINER_NAME $IMAGE_NAME:$IMAGE_VERSION

# Verify the running container
echo "Container is running! Access the application at: http://localhost:8080"