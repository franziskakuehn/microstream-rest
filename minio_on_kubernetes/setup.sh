#!/usr/bin/env bash

set -euo pipefail

HELM=${HELM:-helm}

JHUB_NAMESPACE=${JHUB_NAMESPACE:-jhub}

create_namespace() {
  # Create the vvp system and jobs namespaces if they do not exist
  kubectl get namespace "$JHUB_NAMESPACE" > /dev/null 2>&1 || kubectl create namespace "$JHUB_NAMESPACE"
}

helm_install() {
  local name chart namespace

  name="$1"; shift
  chart="$1"; shift
  namespace="$1"; shift

  $HELM \
    --namespace "$namespace" \
    upgrade --install "$name" "$chart" \
    "$@"
}

install_minio() {
  helm_install minio minio "$JHUB_NAMESPACE" \
    --repo https://helm.min.io \
    --values values-minio.yaml
}

main(){
    echo "> Creating Kubernetes namespaces..."
    create_namespace

    echo "> Installing MinIO..."
    install_minio || :
}

main "$@"


