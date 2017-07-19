#!/usr/bin/env bash

export DEBIAN_FRONTEND=noninteractive

sudo apt-get update
sudo apt-get -y upgrade

# Get "add-apt-repository" Command
sudo apt-get install -y software-properties-common

sudo apt-get update

#Install Build essentials
sudo apt-get install -y build-essential git vim curl wget unzip tar



MONGO_VERSION=3.2.1

#Install JAVA

# See https://stackoverflow.com/questions/10268583/downloading-java-jdk-on-linux-via-wget-is-shown-license-page-instead
echo 'Installing JAVA 1.9'
mkdir /opt/java && cd /opt/java
# curl -v -j -k -L -H "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u25-b17/jdk-8u25-linux-x64.tar.gz > jdk-8u25-linux-x64.tar.gz
#wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u131-b11/jdk-8u131-linux-x64.tar.gz
wget –quiet  -c --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.java.net/java/jdk9/archive/178/binaries/jdk-9+178_linux-x64_bin.tar.gz

tar -xf jdk-9+178_linux-x64_bin.tar.gz
ln -sf /opt/java/jdk-9 /opt/java/current
sudo su vagrant
echo 'export JAVA_HOME=/opt/java/current' >> /home/vagrant/.bashrc
echo 'export PATH=$JAVA_HOME/bin:$PATH' >> /home/vagrant/.bashrc
source ~/.bashrc
sudo su root

#Install Mongo
mkdir /opt/mongo  
cd /opt/mongo  
wget –quiet  https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-ubuntu1404-$MONGO_VERSION.tgz  
tar -xf mongodb-linux-x86_64-ubuntu1404-$MONGO_VERSION.tgz  
ln -sf mongodb-linux-x86_64-ubuntu1404-$MONGO_VERSION current  
mkdir /opt/mongo/data  
/opt/mongo/current/bin/mongod --dbpath /opt/mongo/data/ --fork --logpath /var/log/mongod.log



#Install Gradel
wget –quiet https://services.gradle.org/distributions/gradle-4.0.1-bin.zip
unzip -d /opt/gradle gradle-4.0.1-bin.zip
echo 'export PATH=\$PATH:/opt/gradle/gradle-4.0.1/bin' >> /home/vagrant/.bashrc
echo 'export GRADLE_OPTS="--add-opens java.base/java.lang=ALL-UNNAMED"' >> /home/vagrant/.bashrc
echo 'cd /project/home' >> /home/vagrant/.bashrc



#I dont see a neeed for nodejs

# Using Debian, as root installing Node JS. So commenting the for now
#curl -sL https://deb.nodesource.com/setup_8.x | bash
#apt-get install -y nodejs