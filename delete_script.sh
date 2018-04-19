#!/bin/bash
kubectl delete service redis
kubectl delete service java-kubernetes-demo
kubectl delete deployment redis
kubectl delete deployment java-kubernetes-demo
kubectl delete hpa java-kubernetes-demo
kubectl get pods
kubectl get deployments
kubectl get hpa
