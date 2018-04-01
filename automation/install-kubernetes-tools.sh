#!/bin/bash
VERSION=${1:-1.8.3-00}
apt-get -y install kubectl=$VERSION kubelet=$VERSION kubeadm=$VERSION
